package Threads;
//Thread bir processin parçasıdır, birden fazla thread kullandığımızda
//multithread yaparak eş zamanlı görevler yapabiliriz, CPU en verimli şekilde kullanabiliriz.

public class ThreadCreationWays {

    public static void main(String[] args) {

        //ilk çalışan main threaddir, görelim:
        System.out.println("Current Thread " + Thread.currentThread().getName()); //Current Thread main

        //Thread classini extend ederek
        MyThread thread1 = new MyThread();
        //Start methodu ile yeni bir thread oluşturur
        //Override edilen run() methodunu çağırır,Yaptırmak istediğimiz işlemi yapar.
        //Doğrudan run methodu çağrıldıgında icindeki islemler yapılır ama thread olusmaz. Yani run methodu main thread icinde calisir.
        thread1.start();


        //Runnable interfaceini implement ederek
        MyRunnable myRunnable = new MyRunnable();
        Thread thread2 = new Thread(myRunnable);
        thread2.start();

        //Annonymous(isimsiz) class ile thread oluşturma.
        //Runnable ile thread olusturmanın kısa yolu.
        //Runnable interfaceini implement eden isimsiz bir class.
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(500);//Threadi istedigimiz saniye kadar duraklatabiliyoruz.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Current Thread : " + Thread.currentThread().getName());
                System.out.println("Bu Thread isimsiz class ile oluşturuldu...");

            }
        });

        //Thread ismini degistirdik.
        thread3.setName("Threadcik");

        thread3.start();

        //Annonymous(isimsiz) class ile thread oluşturma. 2
        //lambda exp kullanarak
        //Bir interfacede override edilecek bir tane method varsa bunu lambdayla daha kolay sekilde yapabiliriz.
        Thread thread4 = new Thread(()-> {
            Thread.currentThread().setName("Harika");
            System.out.println("Current Thread : " + Thread.currentThread().getName());
            System.out.println("Bu thread LAMBDA ile oluşturuldu.");
        }
        );
        thread4.start();

        Thread thread5 = new Thread(()-> {

            System.out.println("Current Thread : " + Thread.currentThread().getName());
            System.out.println("Bu thread LAMBDA ile oluşturuldu.");
        }
        );

        thread5.start();

        System.out.println("Main methodun işlemi burada bitti");



    }

}

//Thread olusturma:
//1.yol; Thread Classını extend ederek
class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("MyThread threadi calisiyor...");
    }
}

//2.yol: Runnable intefaceini implement ederek
class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("MyRunnable ile olusturdugumuz thread çalışıyor...");
    }
}