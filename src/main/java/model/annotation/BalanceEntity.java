package model.annotation;

import java.math.BigDecimal;

/**
 * Created by ali on 30/06/2020.
 */
public class BalanceEntity {

    private String depositNumber;
    private BigDecimal amount;


    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
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
                ", depositNumber='" + depositNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
