package nicebank;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.Scanner;

public class TransactionQueue {

    private static final String MESSAGES_FOLDER = "./messages";
    private static final String MESSAGE_FILE_PATH = "%s/%03d";

    private int nextId = 1;

    public static void clear() {
        try {
            FileUtils.deleteDirectory(new File(MESSAGES_FOLDER));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new File(MESSAGES_FOLDER).mkdirs();
    }

    public void write(String transaction) {
        String messageFilePath = String.format(MESSAGE_FILE_PATH, MESSAGES_FOLDER, nextId);

        PrintWriter writer;

        try {
            writer = new PrintWriter(messageFilePath, "UTF-8");
        } catch (FileNotFoundException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

        writer.println(transaction);
        writer.close();

        nextId++;
    }

    public String read() {
        // Get files in 'messages'
        File messagesFolder = new File(MESSAGES_FOLDER);
        File[] messages = messagesFolder.listFiles();

        String message = "";

        // If message file found
        if (messages != null && messages.length > 0) {
            Arrays.sort(messages, (f1, f2) -> Integer.parseInt(f1.getName()) - Integer.parseInt(f2.getName()));

            // Open it
            Scanner scanner;
            try {
                scanner = new Scanner(messages[0]);

                if (scanner.hasNextLine()) {
                    message = scanner.nextLine();
                    scanner.close();

                    // Delete it
                    messages[0].delete();
                } else {
                    scanner.close();
                }
            } catch (FileNotFoundException e) {
            }
        }
        return message;
    }

}
