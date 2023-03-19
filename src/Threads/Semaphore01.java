package Threads;

import java.util.concurrent.Semaphore;

/*
Semaphore, birden fazla thread ortak bir kaynağa erişmeye çalıştığında
erişebilen thread sayısını sınırlandırmamıza yarar.
Synchronized keywordü ortak kaynağa aynı anda sadece bir threadin erişmesini sağlarken
semaphore ile n tane threade erişim izni verilebilir.
*/
public class Semaphore01 {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);

        Car car1=new Car("Audi",5000,semaphore);
        Car car2=new Car("Honda",6000,semaphore);
        Car car3=new Car("Volvo",4000,semaphore);
        Car car4=new Car("Mercedes",7000,semaphore);
        Car car5=new Car("Toyota",9000,semaphore);
        Car car6=new Car("BMW",10000,semaphore);
        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();

    }

}

class Car extends Thread{

    private String carName;
    private int duration;
    Semaphore semaphore;

    //constructor
    public Car(String carName, int duration, Semaphore semaphore) {
        this.carName = carName;
        this.duration = duration;
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        try {
            System.out.println(carName+" park etmek istiyor.");
            semaphore.acquire();//erişim için (park etmek) izin talep ediyor.

            Thread.sleep(2000);
            System.out.println(carName+" park etti.");
            Thread.sleep(duration);

            System.out.println(carName+" park yerinden ayrıldı.");
            semaphore.release();//erişim için serbest bırakıldı.
            //belirlemiş olduğumuz limit kadar threade acquire ve
            // release metodları arasındaki kodlara erişim izni verilir.

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
