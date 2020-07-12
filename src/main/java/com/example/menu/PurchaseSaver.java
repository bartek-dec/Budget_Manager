package com.example.menu;

import com.example.Person;
import com.example.Purchase;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PurchaseSaver {

    private final String source = "./src/main/resources/purchase.txt";
    private Person person;

    public PurchaseSaver(Person person) {
        this.person = person;
    }

    public void savePurchases() {
        File file = new File(source);

        try (FileWriter writer = new FileWriter(file)) {

            writer.write(person.getBalance() + "\n");

            for (Purchase p : person.getPurchases()) {
                writer.write(p.getName() + "\n");
                writer.write(p.getPrice() + "\n");
                writer.write(p.getCategory() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Purchases were saved!\n");
    }
}
