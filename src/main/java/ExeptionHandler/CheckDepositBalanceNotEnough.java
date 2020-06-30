package ExeptionHandler;

import Controller.BalanceEntity;
import Controller.PayEntity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CheckDepositBalanceNotEnough extends DepositBalanceNotEnough {
    public CheckDepositBalanceNotEnough() {
    }

    public CheckDepositBalanceNotEnough(List<PayEntity> payEntities, List<BalanceEntity> balanceEntities) throws DepositBalanceNotEnough {

        BigInteger moneyToPay = new BigInteger("0");
        BigInteger debtorBalace = new BigInteger("0");
        BigInteger sumOfCreditorBalace = new BigInteger("0");
        String debtorDepositNumber = "";

        for (int i = 0; i < payEntities.size(); i++) {
            if (payEntities.get(i).getDepositType().equals("debtor")) {
                moneyToPay = payEntities.get(i).getAmount();
                debtorDepositNumber = payEntities.get(i).getDepositNumber();
                break;
            }
        }

        for (int i = 0; i < balanceEntities.size(); i++) {
            if (balanceEntities.get(i).getDepositNumber().equals(debtorDepositNumber)) {
                debtorBalace=balanceEntities.get(i).getAmount();

            }
            else{
                sumOfCreditorBalace=sumOfCreditorBalace.add(balanceEntities.get(i).getAmount());
            }
        }

        if (debtorBalace.compareTo(sumOfCreditorBalace) == 0 || debtorBalace.compareTo(sumOfCreditorBalace) == 1) {

        } else {
            throw new DepositBalanceNotEnough(debtorDepositNumber);


        }



    }
}
