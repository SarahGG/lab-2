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
    private static boolean doAgain = true;

    /**
     * receives a number from 1 to 100
     * prints results based on the number
     * asks user if they want to continue (y/n)?
     *
     * @param args main() parameters
     */
    public static void main(String[] args) {
        // gets a number from the user and validates it
        setInt();

        do {
            if ((myNum % 2) == 1) {
                if (myNum > 60) {
                    System.out.println("" + myNum + ": Odd and over 60.");
                } else {
                    System.out.println("" + myNum + ": Odd.");
                }
            } else {
                if ((myNum > LOWEST_NUMBER) && (myNum < 25)) {
                    System.out.println("" + myNum + ": Even and less than 25.");
                } else if ((myNum > 25) && (myNum < 61)) {
                    System.out.println("Even.");
                } else if ((myNum > 61) && (myNum >= HIGHEST_NUMBER)) {
                    System.out.println("" + myNum + ": Even.");
                }
            }

            // asks user if they want to repeat
            inputCheck();

            //only repeats the do .. while loop if the user wants to continue
        } while (doAgain);

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

    /**
     * asks user if they want to continue and then checks their input
     * for yes, no, a test result, or an incorrect input
     */
    private static void inputCheck() {
        boolean correctInput; // will check that user has input 'n', 'N', 'y', or 'Y'
        char userContinueCheck = 'z'; // will check that user wants to repeat the program

        /* asks user if they want to continue and then checks their input
        for yes, no, a test result, or an incorrect input */
        do {
            System.out.print("Continue? (y/n): ");
            userContinueCheck = scnr.next("[a-zA-Z]").charAt(0); // accepts a letter as input

            switch (userContinueCheck) {
                case 'y':
                case 'Y':
                    correctInput = true; // 'y' and 'Y' are correct input
                    doAgain = true; // will repeat the main program
                    break;
                case 'n':
                case 'N':
                    correctInput = true; // 'n' and 'N' are correct input
                    doAgain = false; // will exit the main program
                    break;
                case 'z':
                    correctInput = true; // can repeat test if tester wants
                    System.out.println("Your userContinueCheck has failed.");
                    break;
                default:
                    correctInput = false; // makes the doWhile loop ask for another input
                    System.out.println("Incorrect Input!"); // yells at you for misbehavin'
                    System.out.println("");
                    break;
            }
        }
        // repeats the loop if the user gave the wrong input
        while (!correctInput);
    }
}