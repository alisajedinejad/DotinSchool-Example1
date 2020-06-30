package Controller;

import java.math.BigInteger;

/**
 * Created by ali on 30/06/2020.
 */
public class PayEntity {
    private String depositType;
    private String depositNumber;
    private BigInteger amount;

    public String getDepositType() {
        return depositType;
    }

    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    @Override
    public String toString() {
        return "PayEntity{" +
                "depositType='" + depositType + '\'' +
                ", depositNumber='" + depositNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
