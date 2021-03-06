package Service.Handler;

import model.BalanceEntity;
import model.PayEntity;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    static Logger log = Logger.getLogger(FileReader.class.getName());

    public List<PayEntity> getPaysEntities() {
        List<PayEntity> payEntities = new ArrayList<PayEntity>();
        try {
            File myObj = new File("DataBase/pay.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] thisLine = line.split("\t");
                PayEntity payEntity = new PayEntity();
                payEntity.setAmount(new BigDecimal(thisLine[2]));
                payEntity.setDepositNumber(thisLine[1]);
                payEntity.setDepositType(thisLine[0]);
                payEntities.add(payEntity);
            }
            log.info("All files successfully read .");
            myReader.close();
        } catch (FileNotFoundException e) {
            log.error("An error occurred.");
            e.printStackTrace();
        }
        return payEntities;
    }

    public List<BalanceEntity> getBalanceEntities() {
        List<BalanceEntity> balanceEntities = new ArrayList<BalanceEntity>();
        try {
            File myObj = new File("DataBase/balance.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] thisLine = line.split("\t");
                BalanceEntity balanceEntity = new BalanceEntity();
                balanceEntity.setAmount(new BigDecimal(thisLine[1]));
                balanceEntity.setDepositNumber(thisLine[0]);
                balanceEntities.add(balanceEntity);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return balanceEntities;
    }
}
