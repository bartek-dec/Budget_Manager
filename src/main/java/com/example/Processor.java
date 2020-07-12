package com.example;

import com.example.menu.*;
import com.example.util.Printer;

import java.util.Scanner;

public class Processor {

    private Scanner scanner;
    private Person person;
    private IncomeAdder incomeAdder;
    private PurchaseAdder purchaseAdder;
    private ListShower listShower;
    private BalanceShower balanceShower;
    private PurchaseSaver purchaseSaver;
    private PurchaseLoader purchaseLoader;
    private Analyzer analyzer;
    private Printer printer;

    public Processor(Person person) {
        this.scanner = new Scanner(System.in);
        this.person = person;
        incomeAdder = new IncomeAdder(scanner, person);
        purchaseAdder = new PurchaseAdder(scanner, person);
        listShower = new ListShower(scanner, person);
        balanceShower = new BalanceShower(person);
        purchaseSaver = new PurchaseSaver(person);
        purchaseLoader = new PurchaseLoader(person);
        analyzer = new Analyzer(person, scanner);
        this.printer = new Printer();
    }

    public void runMenu() {
        int input = -1;
        do {
            options();

            try {
                input = Integer.parseInt(scanner.nextLine().trim());
                switch (input) {
                    case 1:
                        incomeAdder.addIncome();
                        break;
                    case 2:
                        purchaseAdder.categorySubMenu();
                        break;
                    case 3:
                        if (person.getPurchases().size() == 0) {
                            printer.showAllPurchases(person.getPurchases(), person.countTotal());
                        } else {
                            listShower.listSubMenu();
                        }
                        break;
                    case 4:
                        balanceShower.showBalance();
                        break;
                    case 5:
                        purchaseSaver.savePurchases();
                        break;
                    case 6:
                        purchaseLoader.loadPurchases();
                        break;
                    case 7:
                        analyzer.analyzeSubMenu();
                        break;
                    case 0:
                        System.out.println("Bye!");
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Bad action\n");
            }

        } while (input != 0);
    }

    private void options() {
        System.out.println("Choose your action:");
        System.out.println("1) Add income");
        System.out.println("2) Add purchase");
        System.out.println("3) Show list of purchases");
        System.out.println("4) Balance");
        System.out.println("5) Save");
        System.out.println("6) Load");
        System.out.println("7) Analyze (Sort)");
        System.out.println("0) Exit\n");
    }
}
