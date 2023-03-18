package Threads;
//threadler aynı anda aynı kaynağa erişip değişiklik yapmak isterlerse ne olacak?
public class Multithreading02 {
    public static int counter=0;

    public static void main(String[] args) {
        //iki tane thread oluşturup bu threadlerin aynı kaynağa(counter) erişmesini sağlayalım
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalıştı.");
                Counter.count();
            }
        });
        thread1.setName("Tom");
        thread1.start();


        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" çalıştı.");
                Counter.count();
            }
        });
        thread2.setName("Jerry");
        thread2.start();

    }

}
class Counter{
    //counter değişkeninin değerini 1000 kez artırsın.
    public static void count(){
        for (int i=1;i<=1000;i++){
            Multithreading02.counter++;//1000+1000=beklenen 2000
        }

    }


}