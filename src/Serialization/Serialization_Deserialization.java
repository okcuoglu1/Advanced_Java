package Serialization;

import java.io.*;

//ObjectOutputStream Java objelerini kodlar ve karşılık gelen akışları (stream) oluşturur.
//bu işleme serialization denir
public class Serialization_Deserialization {
    public static void main(String[] args) {

        //writeObjects();
        readObjects();

    }


    //objectleri dosyaya yazdırma
    public static void writeObjects(){
        System.out.println("User objeleri oluşturuluyor...");
        User user1=new User(1L,"Ferit","55522233311");
        User user2=new User(2L,"Necmi","55522233312");
        User user3=new User(3L,"Şaban","55522233313");
        User user4=new User(4L,"Mahmut","55522233314");

        try {
            //objelerin yazılacacağı dosyaya yazmak için
            FileOutputStream fos=new FileOutputStream("user.txt");
            //objeleri yazmak için
            ObjectOutputStream output=new ObjectOutputStream(fos);
            //OOS in objeleri akışa yazdırabilmesi için objelerin Class'ı Serializable interface'ini
           //implement etmiş olmalı. Çünkü objelerin serileştirilmesi gerekir.

            output.writeObject(user1);
            output.writeObject(user2);
            output.writeObject(user3);
            output.writeObject(user4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //objectleri dosyadan okuma:de-serialization
    public static void readObjects(){

        try {
            //okuyacağımız dosyayı belirtelim
            FileInputStream fis=new FileInputStream("user.txt");
            //objectleri okumak için
            ObjectInputStream input=new ObjectInputStream(fis);

            User user1=(User)input.readObject();
            User user2=(User)input.readObject();
            User user3=(User)input.readObject();
            User user4=(User)input.readObject();



            System.out.println(user1);
            System.out.println(user2);
            System.out.println(user3);
            System.out.println(user4);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}