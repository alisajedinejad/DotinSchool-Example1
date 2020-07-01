package Controller;

import model.annotation.BalanceEntity;
import model.annotation.PayEntity;
import model.annotation.TransactionEntity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 30/06/2020.
 */
public class SettleSalary {

    private List<BalanceEntity> balanceEntities;
    private List<TransactionEntity> transactionEntities = new ArrayList<TransactionEntity>();
    private List<PayEntity> payEntities;


    public List<TransactionEntity> getTransactionEntities() {
        return transactionEntities;
    }

    public List<BalanceEntity> getBalanceEntities() {
        return balanceEntities;
    }

    public void setBalanceEntities(List<BalanceEntity> balanceEntities) {
        this.balanceEntities = balanceEntities;
    }

    public List<PayEntity> getPayEntities() {
        return payEntities;
    }

    public void setPayEntities(List<PayEntity> payEntities) {
        this.payEntities = payEntities;
    }

    @Override
    public String toString() {
        return "SettleSalary{" +
                "balanceEntities=" + balanceEntities +
                ", payEntities=" + payEntities +
                '}';
    }


    public List<BalanceEntity> setSalary() {

        BigDecimal debtorSumMoney = new BigDecimal("0");
        String debtorDepositNumber = "";


        for (int i = 0; i < payEntities.size(); i++) {
            if (payEntities.get(i).getDepositType().equals("debtor")) {

                debtorDepositNumber = payEntities.get(i).getDepositNumber();
                break;
            }
        }

        for (int i = 0; i < this.payEntities.size(); i++) {
            if (this.payEntities.get(i).getDepositType().equals("creditor")) {


                String creatorNumber = this.payEntities.get(i).getDepositNumber();
                BigDecimal creatorMoney = this.payEntities.get(i).getAmount();
                debtorSumMoney = debtorSumMoney.add(creatorMoney);
                for (int j = 0; j < this.balanceEntities.size(); j++) {

                    if (this.balanceEntities.get(j).getDepositNumber().equals(creatorNumber)) {

                        this.balanceEntities.get(j).setAmount(this.balanceEntities.get(j).getAmount().add(creatorMoney));
                        TransactionEntity transactionEntity = new TransactionEntity();
                        transactionEntity.setDebtorDepositNumber(debtorDepositNumber);
                        transactionEntity.setCreditorDepositNumber(this.balanceEntities.get(j).getDepositNumber());
                        transactionEntity.setAmount(creatorMoney);
                        System.out.println("this is transactionEntity -->>> " + transactionEntity);
                        this.transactionEntities.add(transactionEntity);
                        System.out.println("this is transactionEntities -->>> " + this.transactionEntities);
                        break;
                    }
                }
            }
        }


        for (int i = 0; i < this.balanceEntities.size(); i++) {
            if (this.balanceEntities.get(i).getDepositNumber().equals(debtorDepositNumber)) {
                balanceEntities.get(i).setAmount(balanceEntities.get(i).getAmount().subtract(debtorSumMoney));
                break;
            }
        }


        return balanceEntities;
    }
}
