package ExeptionHandler;

import model.annotation.BalanceEntity;
import model.annotation.PayEntity;

import java.math.BigDecimal;
import java.util.List;

public class CheckDepositBalanceNotEnough extends DepositBalanceNotEnough {

    public CheckDepositBalanceNotEnough(List<PayEntity> payEntities, List<BalanceEntity> balanceEntities) throws DepositBalanceNotEnough {

        BigDecimal debtorBalace = new BigDecimal("0");
        BigDecimal sumOfCreditorBalace = new BigDecimal("0");
        String debtorDepositNumber = "";

        for (int i = 0; i < payEntities.size(); i++) {
            if (payEntities.get(i).getDepositType().equals("debtor")) {
                debtorDepositNumber = payEntities.get(i).getDepositNumber();

                break;
            }
        }

        for (int i = 0; i < balanceEntities.size(); i++) {
            if (balanceEntities.get(i).getDepositNumber().equals(debtorDepositNumber)) {
                debtorBalace = balanceEntities.get(i).getAmount();

                break;
            }
        }

        for (int i = 0; i < payEntities.size(); i++) {
            if (payEntities.get(i).getDepositNumber().equals(debtorDepositNumber)) {

            } else {
                sumOfCreditorBalace = sumOfCreditorBalace.add(payEntities.get(i).getAmount());
            }
        }

        if (debtorBalace.compareTo(sumOfCreditorBalace) == 0 || debtorBalace.compareTo(sumOfCreditorBalace) == 1) {


        } else {
            throw new DepositBalanceNotEnough(debtorDepositNumber);


        }


    }
}
