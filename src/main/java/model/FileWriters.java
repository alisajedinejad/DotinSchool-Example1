package model;

import Controller.BalanceEntity;
import Controller.TransactionEntity;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by ali on 30/06/2020.
 */
public class FileWriters {


    public FileWriters() {
    }

    public void writeToBalance(List<BalanceEntity> balanceEntities) {

        String data = "";
        for (int i = 0; i < balanceEntities.size(); i++) {

            data += balanceEntities.get(i).getDepositNumber() + "\t" + balanceEntities.get(i).getAmount() + "\n";


        }
        try {
            FileWriter myWriter = new FileWriter("DataBase/balance.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the balance.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    public void writeToTransaction(List<TransactionEntity> transactionEntity) {

        String data = "";
        try {
            File myObj = new File("DataBase/transactions.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        for (int i = 0; i < transactionEntity.size(); i++) {

            data+=transactionEntity.get(i).getDebtorDepositNumber() + "\t" + transactionEntity.get(i).getCreditorDepositNumber() + "\t" + transactionEntity.get(i).getAmount()+"\n";
        }

        try {
            FileWriter myWriter = new FileWriter("DataBase/transactions.txt");
            myWriter.write(data);
            myWriter.close();
            System.out.println("Successfully wrote to the transactions.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }


}
