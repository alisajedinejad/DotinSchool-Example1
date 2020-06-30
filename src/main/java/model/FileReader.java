package model;

import Controller.BalanceEntity;
import Controller.PayEntity;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ali on 30/06/2020.
 */
public class FileReader {



    public FileReader(){}


    public List<PayEntity> getPaysEntities(){

        List<PayEntity> payEntities =new ArrayList<PayEntity>();
        try {
            File myObj = new File("DataBase/pay.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] thisLine = line.split("\t");
                PayEntity payEntity =new PayEntity();
                payEntity.setAmount(new BigInteger(thisLine[2]));
                payEntity.setDepositNumber(thisLine[1]);
                payEntity.setDepositType(thisLine[0]);
                payEntities.add(payEntity);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return payEntities;
    }

    public List<BalanceEntity> getBalanceEntities(){

        List<BalanceEntity> balanceEntities =new ArrayList<BalanceEntity>();
        try {
            File myObj = new File("DataBase/balance.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] thisLine = line.split("\t");
                BalanceEntity balanceEntity =new BalanceEntity();
                balanceEntity.setAmount(new BigInteger(thisLine[1]));
                balanceEntity.setDepositNumber(thisLine[0]);
                balanceEntities.add(balanceEntity);

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


        return balanceEntities;
    }
}
