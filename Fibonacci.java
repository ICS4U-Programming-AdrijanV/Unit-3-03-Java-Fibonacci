// Importing
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program will calculate the fibonacci number.
 *
 * @author  Adrijan Vranjkovic
 * @version 1.0
 * @since   2023-04-24
 */
public final class Fibonacci {
    /**
     * For the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main function.
     *
     * @param args Unused
     */
    public static void main(String[] args) {

        // Create array list
        final ArrayList<String> inputList = new ArrayList<String>();

        // Try statement.
        try {

            // Create input file.
            final File input = new File("input.txt");
            final Scanner scanInput = new Scanner(input);

            // Create output file.
            final FileWriter output = new FileWriter("output.txt");

            // This reads through every line of the input file.
            while (scanInput.hasNextLine()) {
                inputList.add(scanInput.nextLine());
            }

            // This fills up the array with the array list.
            final String[] inputArr = new String[inputList.size()];
            for (int count = 0; count < inputArr.length; count++) {
                inputArr[count] = inputList.get(count);
            }

            // This for loop checks for valid input
            // Then it calls the function to get the fibonacci number
            // Then it displays the number to the output file.
            for (String str : inputArr) {
                try {

                    // Parse string to int.
                    final int num = Integer.parseInt(str);

                    if (num < 0) {

                        // Display if error.
                        throw new IllegalArgumentException("Input must be"
                            + " non-negative" + "\n");
                    }

                    // Call function
                    final int calculatedNumber = fibonacci(num);

                    // Display final output to file.
                    output.write(calculatedNumber + "\n");

                } catch (NumberFormatException err) {
                    // Display error.
                    output.write("Error: " + str + " is not a valid integer."
                        + "\n");
                } catch (IllegalArgumentException err) {
                    // Display error.
                    output.write("Error: " + err.getMessage());
                }
            }
            output.close();

        } catch (IOException err) {
            // Display error.
            System.err.println("Error: " + err.getMessage());
        }
    }

    /**
    * This function gets th fibonacci number.
    *
    * @param num from file
    * @return num
    */
    public static int fibonacci(int num) {

        // Base case
        if (num == 0) {
            return 0;
        } else if (num == 1) {
            return 1;
        } else {
            // Call this function recursively.
            return fibonacci(num - 2) + fibonacci(num - 1);
        }
    }
}