package task04;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Podaj test to zakodowania:");
            String originalText = sc.nextLine();
            System.out.println("Podaj dodatni szyfr:");
            int code = sc.nextInt();
            sc.hasNextLine();
            if (code <= 0) {
                throw new NonPositiveCodeValueException();
            }
            System.out.println(originalText);
            String encodedText = CaesarCode.encodeText(originalText, code);
            System.out.println(encodedText);
            String decodedText = CaesarCode.decodeText(encodedText, code);
            System.out.println(decodedText);

        } catch (InputMismatchException e) {
            System.err.println("Szyfr powinien być liczbowy.");
        } catch (NonPositiveCodeValueException e) {
            System.err.println(e.getMessage());
        }
    }


}
