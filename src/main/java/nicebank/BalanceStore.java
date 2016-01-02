package nicebank;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class BalanceStore {

    private static String BALANCE_FILE_PATH ="./balance";

    public static void clear() {
        new File(BALANCE_FILE_PATH).delete();

        setBalance(new Money(0,0));
    }

    public static Money getBalance() {
        File balanceFile = new File(BALANCE_FILE_PATH);
        Scanner scanner;
        try {
            scanner = new Scanner(balanceFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        Money balance = new Money(scanner.nextLine());
        scanner.close();
        return balance;
    }

    public static void setBalance(Money newBalance) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(BALANCE_FILE_PATH, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        writer.println(newBalance.toString());
        writer.close();
    }
}
