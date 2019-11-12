package task02;

import java.io.*;

public class MathApp {
    private static final String INPUT_FILE = "math_input.txt";
    private static final String OUTPUT_FILE = "math_output.txt";

    public static void main(String[] args) {
        File inputFile = new File(INPUT_FILE);
        File outputFile = new File(OUTPUT_FILE);

        try (FileReader fileReader = new FileReader(inputFile);
             BufferedReader bufferedReader = new BufferedReader(fileReader);
             FileWriter fileWriter = new FileWriter(outputFile);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)
        ) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                double result = calculateResult(line);
                System.out.println(line + " = " + result);
                bufferedWriter.write(line + " = " + result);
                bufferedWriter.newLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static double calculateResult(String line) {
        String[] mathOperation = line.split(" ");
        String operator = mathOperation[1];

        double result;
        switch (operator) {
            case "+":
                result = (Double.parseDouble(mathOperation[0]) + Double.parseDouble(mathOperation[2]));
                break;
            case "-":
                result = (Double.parseDouble(mathOperation[0]) - Double.parseDouble(mathOperation[2]));
                break;
            case "*":
                result = (Double.parseDouble(mathOperation[0]) * Double.parseDouble(mathOperation[2]));
                break;
            case "/":
                result = (Double.parseDouble(mathOperation[0]) / Double.parseDouble(mathOperation[2]));
                break;
            default:
                result = 0;
        }
        return result;
    }
}