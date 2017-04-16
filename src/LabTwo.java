import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * displays results based on user input
 * @author Sarah Guarino
 * @version 1.0
 */
public class LabTwo {
    private static int myNum = 0;
    private static Scanner scnr = new Scanner(System.in);
    final private static int HIGHEST_NUMBER = 100;
    final private static int LOWEST_NUMBER = 1;

    /**
     * this is my main method
     *
     * @param args
     */
    public static void main(String[] args) {
        setInt();
        do {
            if ( (myNum % 2) == 1) {
                if (myNum > 60) {
                    System.out.println("" + myNum + ": Odd and over 60.");
                } else {
                    System.out.println("" + myNum + ": Odd.");
                }
            } else {
                if ( (myNum > LOWEST_NUMBER) && (myNum < 25) ) {
                    System.out.println("" + myNum + ": Even and less than 25.");
                } else if( (myNum > 25) && (myNum < 61) ) {
                    System.out.println("Even.");
                }
                else if( (myNum > 61) && (myNum >= HIGHEST_NUMBER) ){
                    System.out.println("" + myNum + ": Even.");
                }
                inputCheck;
            }
            while (doAgain);

            System.out.println("Goodbye!");
        }

        /**
         * receives and validates input from Scanner
         * ensures that input is between 1 and 100
         */
    private static void setInt() {
        boolean isValid;
        do {
            System.out.print("Enter a number between 1 and 100: ");

            if (scnr.hasNextInt()) {
                myNum = scnr.nextInt();

                if ((myNum >= LOWEST_NUMBER) && (myNum <= HIGHEST_NUMBER)) {
                    isValid = true;
                }
                else {
                    System.out.println("This is not between 1 and 100");
                    isValid = false;
                }
            } else {
                System.out.println("This is not a number");
                isValid = false;
                scnr.next();
            }
        } while(!isValid);
    }
}