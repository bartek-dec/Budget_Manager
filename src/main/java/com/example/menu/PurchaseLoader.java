package com.example.menu;

import com.example.Person;
import com.example.Purchase;

import java.io.*;
import java.math.BigDecimal;

public class PurchaseLoader {

    private final String source = "./src/main/resources/purchase.txt";
    private Person person;

    public PurchaseLoader(Person person) {
        this.person = person;
    }

    public void loadPurchases() {

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {

            String line = reader.readLine().trim();
            person.addIncome(line);

            while ((line = reader.readLine()) != null) {
                Purchase purchase = new Purchase(line, new BigDecimal(reader.readLine().trim()), reader.readLine().trim());
                person.getPurchases().add(purchase);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Purchases were loaded!\n");
    }
}
