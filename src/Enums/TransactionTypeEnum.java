package Enums;

public enum TransactionTypeEnum {

    DEPOSIT(1),
    WITHDRAW(2),
    TRANSFER(3),
    PAYMENT(4),
    OTHER(5);

    private final int code;

    public int getCode() {
        return code;
    }

    TransactionTypeEnum(int code){
        this.code=code;
    }

}
