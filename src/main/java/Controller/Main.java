package Controller;

import ExeptionHandler.CheckDepositBalanceNotEnough;
import ExeptionHandler.DepositBalanceNotEnough;
import model.FileReader;
import model.FileWriters;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 30/06/2020.
 */
public class Main {
    public static void main(String args[]) {


        FileReader fileReader = new FileReader();
        List<PayEntity> payEntities = fileReader.getPaysEntities();
        List<BalanceEntity> balanceEntities = fileReader.getBalanceEntities();
        List<TransactionEntity> transactionEntities = new ArrayList<TransactionEntity>();


        try {
            CheckDepositBalanceNotEnough checkNegativeDepositBalance = new CheckDepositBalanceNotEnough(payEntities, balanceEntities);

        } catch (DepositBalanceNotEnough depositBalanceNotEnough) {
            depositBalanceNotEnough.printStackTrace();
        }


        SettleSalary settleSalary = new SettleSalary();
        settleSalary.setBalanceEntities(balanceEntities);
        settleSalary.setPayEntities(payEntities);
        balanceEntities = settleSalary.setSalary();
        transactionEntities = settleSalary.getTransactionEntities();


        FileWriters fileWriters = new FileWriters();
        fileWriters.writeToBalance(balanceEntities);
        fileWriters.writeToTransaction(transactionEntities);


    }


}
