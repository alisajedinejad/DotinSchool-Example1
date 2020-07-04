package Service;

import model.BalanceEntity;
import model.PayEntity;
import model.TransactionEntity;
import org.apache.log4j.BasicConfigurator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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
        BasicConfigurator.configure();
        BigDecimal debtorSumMoney = BigDecimal.ZERO;
        String debtorDepositNumber = "";
        for (PayEntity payEntity : this.payEntities) {
            if (payEntity.getDepositType().equals("debtor")) {
                debtorDepositNumber = payEntity.getDepositNumber();
                break;
            }
        }
        for (PayEntity payEntity : this.payEntities) {
            if (payEntity.getDepositType().equals("creditor")) {
                String creatorNumber = payEntity.getDepositNumber();
                BigDecimal creatorMoney = payEntity.getAmount();
                debtorSumMoney = debtorSumMoney.add(creatorMoney);
                for (BalanceEntity balanceEntity : this.balanceEntities) {
                    if (balanceEntity.getDepositNumber().equals(creatorNumber)) {
                        balanceEntity.setAmount(balanceEntity.getAmount().add(creatorMoney));
                        TransactionEntity transactionEntity = new TransactionEntity();
                        transactionEntity.setDebtorDepositNumber(debtorDepositNumber);
                        transactionEntity.setCreditorDepositNumber(balanceEntity.getDepositNumber());
                        transactionEntity.setAmount(creatorMoney);
                        this.transactionEntities.add(transactionEntity);
                        break;
                    }
                }
            }
        }
        for (BalanceEntity balanceEntity : this.balanceEntities) {
            if (balanceEntity.getDepositNumber().equals(debtorDepositNumber)) {
                balanceEntity.setAmount(balanceEntity.getAmount().subtract(debtorSumMoney));
                break;
            }
        }
        return balanceEntities;
    }
}
