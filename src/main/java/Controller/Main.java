package Controller;

import model.FileReader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ali on 30/06/2020.
 */
public class Main {
    public static void main(String args[]){
        List<PayEntity> payEntities =new ArrayList<PayEntity>();
        FileReader fileReader = new FileReader();
        payEntities=fileReader.getPaysEntities();
        System.out.println(payEntities.get(1));
    }
}
