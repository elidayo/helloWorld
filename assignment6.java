import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class assignment6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Bubble Sort Example!");
        System.out.println("Please choose an option:");
        System.out.println("1. Create a random array and sort it.");
        System.out.println("2. Read an array from a file and sort it.");
        System.out.println("Enter 'exit' or '-1' to exit the program.");

        while (true) {
            String userInput = scanner.nextLine();
            if (userInput.equalsIgnoreCase("exit") || userInput.equals("-1")) {
                System.out.println("Exiting the program.");
                break;
            } else {
                int option = Integer.parseInt(userInput);
                if (option == 1) {
                    int[] randomArray = createRandomArray(10);
                    System.out.println("Random Array: " + Arrays.toString(randomArray));
                    bubbleSort(randomArray);
                    System.out.println("Sorted Array: " + Arrays.toString(randomArray));
                } else if (option == 2) {
                    System.out.println("Enter the filename to read from:");
                    String filename = scanner.nextLine();
                    int[] array = readFileToArray(filename);
                    if (array != null) {
                        System.out.println("Read Array: " + Arrays.toString(array));
                        bubbleSort(array);
                        System.out.println("Sorted Array: " + Arrays.toString(array));
                    } else {
                        System.out.println("Failed to read the array from the file.");
                    }
                } else {
                    System.out.println("Invalid option. Please choose 1 or 2.");
                }
            }
        }

        scanner.close();
    }

    public static int[] createRandomArray(int arrayLength) {
        int[] randomArray = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            randomArray[i] = random.nextInt(101); // Generate random integers between 0 and 100
        }
        return randomArray;
    }

    public static void writeArrayToFile(int[] array, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int num : array) {
                writer.write(num + "\n");
            }
            writer.close();
            System.out.println("Array written to " + filename);
        } catch (IOException e) {
            System.err.println("Error writing to the file.");
        }
    }

    public static int[] readFileToArray(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            int count = 0;
            while (reader.readLine() != null) {
                count++;
            }
            reader.close();

            int[] array = new int[count];
            reader = new BufferedReader(new FileReader(filename));
            for (int i = 0; (line = reader.readLine()) != null; i++) {
                array[i] = Integer.parseInt(line);
            }
            reader.close();

            return array;
        } catch (IOException e) {
            System.err.println("Error reading from the file.");
            return null;
        }
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
