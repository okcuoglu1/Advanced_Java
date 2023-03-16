package Enums;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {

        useNonEnumVariable(1);
        useNonEnumVariable(2);
        useNonEnumVariable(3);
        useNonEnumVariable(4);
        useNonEnumVariable(5);
        useNonEnumVariable(100);//CTE,


        useEnumType(TransactionTypeEnum.DEPOSIT);
        useEnumType(TransactionTypeEnum.WITHDRAW);
        useEnumType(TransactionTypeEnum.PAYMENT);
        useEnumType(TransactionTypeEnum.TRANSFER);
        useEnumType(TransactionTypeEnum.OTHER);

       // useEnumType(aaaaa);//enum type dışında değer girilemez CTE





    }
     public static void useNonEnumVariable(int n){
        if(n==TransactionTypeConstant.DEPOSIT){
            System.out.println("Para yatırılıyor...");
        }else if(n==TransactionTypeConstant.WITHDRAW){
            System.out.println("Para çekiliyor...");
        }else if(n==TransactionTypeConstant.TRANSFER){
            System.out.println("Para transfer ediliyor...");
        }else if(n==TransactionTypeConstant.PAYMENT){
            System.out.println("Ödeme gerçekleşiyor...");
        }else if(n==TransactionTypeConstant.OTHER){
            System.out.println("Diğer işlemler...");
        }
     }

     public static void useEnumType(TransactionTypeEnum transactionType){
//        if(transactionType.getCode()==1){
//            System.out.println("Para yatırılıyor...");
//
//        }


         //Ordinal kullanmanın riski vardır?
         //Enumların sırası değişirse sıkıntı yasanabilir.
         //Yeni bir enum eklemek ya da enumı silmek sıralarını değiştirir.

//         if(transactionType.ordinal()==0){
//             System.out.println("Para yatırılıyor...");
//         }

        if(transactionType==TransactionTypeEnum.DEPOSIT){
            System.out.println("Para yatırılıyor...");
        } else if (transactionType==TransactionTypeEnum.WITHDRAW) {
            System.out.println("Para çekiliyor...");
        }else if (transactionType==TransactionTypeEnum.TRANSFER) {
            System.out.println("Para transfer ediliyor...");
       } else if (transactionType==TransactionTypeEnum.PAYMENT) {
            System.out.println("Ödeme gerçekleşiyor...");
        }else if (transactionType==TransactionTypeEnum.OTHER){
            System.out.println("Diğer işlemler...");
        }

        //Enumun ismini görmek icin
         System.out.println("Enums name : " + transactionType.name());

        //Enumun sırasını görmek için
         System.out.println("Enum sırası: " + transactionType.ordinal());




     }






}
