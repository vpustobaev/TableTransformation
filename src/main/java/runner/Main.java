package runner;

import model.Table;
import serializer.TableSerializer;
import sort.TableManipulator;
import util.Util;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello. This program is intended to transform provided Table from the file." +
                "\nPlease provide the file path:");

        TableSerializer tableSerializer = new TableSerializer();
        Table initialTable = null;
        while (initialTable == null) {
            String filePath = in.nextLine();
            try {
                String fileText = Util.readFile(filePath);
                initialTable = tableSerializer.deserialize(fileText);
            } catch (Exception e) {
                System.out.println("Could not find a file in the path: " + filePath);
                System.out.println("Please check if file exists or available and try again.");
            }
        }
        TableManipulator tableManipulator = new TableManipulator();
        Table sortedTable = tableManipulator.sort(initialTable);
        String serializedTable = tableSerializer.serialize(sortedTable);
        System.out.println("Table was successfully transformed." +
                "\nPlease input name of the text file where it gonna be saves:");
        String fileToSave = in.nextLine();
        Util.saveToFile(serializedTable, fileToSave);

    }

}
