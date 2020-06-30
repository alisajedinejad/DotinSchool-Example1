package Controller;

import java.math.BigInteger;

/**
 * Created by ali on 30/06/2020.
 */
public class TransactionEntity {

    private String debtorDepositNumber;

    public String getCreditorDepositNumber() {
        return creditorDepositNumber;
    }

    public void setCreditorDepositNumber(String creditorDepositNumber) {
        this.creditorDepositNumber = creditorDepositNumber;
    }

    public String getDebtorDepositNumber() {
        return debtorDepositNumber;
    }

    public void setDebtorDepositNumber(String debtorDepositNumber) {
        this.debtorDepositNumber = debtorDepositNumber;
    }

    private String creditorDepositNumber;
    private BigInteger amount;


    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "TransactionEntity{" +
                "debtorDepositNumber='" + debtorDepositNumber + '\'' +
                ", creditorDepositNumber='" + creditorDepositNumber + '\'' +
                ", amount=" + amount +
                '}';
    }
}
