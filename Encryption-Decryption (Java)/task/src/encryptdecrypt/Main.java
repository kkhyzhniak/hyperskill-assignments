package encryptdecrypt;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static Algorithm algorithm;

    public static void main(String[] args) {
        String operation = "enc";
        String message = "";
        String alg = "shift";
        int offset = 0;

        String input = null;
        String output = null;

        for (int i = 0; i < args.length - 1; i+=2) {
            switch (args[i]) {
                case "-mode" -> operation = args[i + 1];
                case "-key" -> offset = Integer.parseInt(args[i + 1]);
                case "-data" -> message = args[i + 1];
                case "-in" -> input = args[i + 1];
                case "-out" -> output = args[i + 1];
                case "-alg" -> alg = args[i + 1];
            }
        }
        
        if (message.isEmpty() && input != null) {
            message = readFromFile(input);
        }

        String result = "";

        if ("enc".equals(operation)) {
            algorithm = AlgorithmFactory.createAlgorithm(alg, offset, message);
            result = algorithm.encrypt();
        } else if ("dec".equals(operation)) {
            algorithm = AlgorithmFactory.createAlgorithm(alg, offset, message);
            result = algorithm.decrypt();
        }

        if (output != null) {
            writeToFile(output, result);
        } else {
            System.out.println(result);
        }
    }

    public static String readFromFile(String from) {
        String message = null;
        File file = new File(from);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
               message = scanner.nextLine();
            }
        } catch (IOException exception) {
            System.out.printf("Error: %s", exception.getMessage());
        }
        return message;
    }

    public static void writeToFile(String to, String data) {
        File file = new File(to);
        try(FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        } catch (IOException exception) {
            System.out.printf("Error: %s", exception.getMessage());
        }
    }

}

