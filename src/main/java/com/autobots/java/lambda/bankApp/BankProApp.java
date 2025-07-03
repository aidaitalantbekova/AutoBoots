package com.autobots.java.lambda.bankApp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class BankProApp {

    private static final Map<String, Client> clients = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // Создаём клиента и его счета
        Client asan = new Client("Asan Yson", "1234");

        DepositAccount asanDeposit = new DepositAccount(asan, Currency.USD);
        CreditAccount asanCredit = new CreditAccount(asan, Currency.EUR);
        asanDeposit.deposit(10000);
        asanCredit.deposit(5000);

        asan.addAccount(asanDeposit);
        asan.addAccount(asanCredit);


        System.out.println("Client ID: " + asan.getClientID());

        clients.put(asan.getClientID(), asan);

        // Авторизация
        System.out.println("======= Welcome to MBank ==========");
        System.out.print("Please enter Client ID: ");
        String clientID = scanner.nextLine();
        Client client = clients.get(clientID);

        if (client == null) {
            System.out.println("Client was not found");
            return;
        }

        System.out.print("Please enter pin code: ");
        String pinCode = scanner.nextLine();

        if (!client.authenticate(pinCode)) {
            System.out.println("You entered wrong pin code!");
            return;
        }

        System.out.println(client.getFullName() + ", welcome to MBank!");

        // Меню
        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Посмотреть счета");
            System.out.println("2. Перевести между счетами");
            System.out.println("3. Показать чек");
            System.out.println("0. Выход из программы");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.printf("%s | %s | Баланс: %.2f %s\n",
                                bankAccount.getClass().getSimpleName(),
                                bankAccount.getAccountNumber(),
                                bankAccount.getBalance(),
                                bankAccount.getCurrency());
                    }
                    break;

                case "2":
                    System.out.print("Введите номер счета отправителя: ");
                    String fromID = scanner.nextLine();
                    System.out.print("Введите номер счета получателя: ");
                    String toID = scanner.nextLine();
                    System.out.print("Сумма: ");
                    double amount = Double.parseDouble(scanner.nextLine());

                    BankAccount from = findAccount(fromID);
                    BankAccount to = findAccount(toID);

                    if (from != null && to != null) {
                        boolean result = BankService.transfer(from, to, amount);
                        System.out.println(result ? "Операция прошла успешно" : "Ошибка перевода");
                    } else {
                        System.out.println("Счета не найдены");
                    }
                    break;

                case "3":
                    for (BankAccount bankAccount : client.getAccounts()) {
                        System.out.println("\n== Чек по счёту " + bankAccount.getAccountNumber());
                        for (Transaction transaction : bankAccount.getTransactions()) {
                            System.out.println(transaction);
                        }
                    }
                    break;

                case "0":
                    System.out.println("Выход...");
                    return;

                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    public static BankAccount findAccount(String accountNumber) {
        for (Client client : clients.values()) {
            for (BankAccount bankAccount : client.getAccounts()) {
                if (bankAccount.getAccountNumber().equals(accountNumber)) {
                    return bankAccount;
                }
            }
        }
        return null;


    }


        }

