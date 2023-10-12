import java.util.Scanner;

public class assignment5 {
    public static void main(String[] args) {
        System.out.println("1: Kilograms to Pounds (kg to lb)");
        System.out.println("2: Grams to Ounces (g to oz)");
        System.out.println("3: Kilometers to Miles (km to mi)");
        System.out.println("4: Millimeters to Inches (mm to in)");
        System.out.println("Type 'exit' or '-1' to quit.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter a conversion: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                System.out.println("Successfully exited");
                break;
            }

            String[] parts = userInput.split(" ");
            if (parts.length != 4 || !parts[2].equals("=")) {
                System.out.println("Invalid input format. Try again.");
                continue;
            }

            try {
                double value = Double.parseDouble(parts[0]);
                String fromUnit = parts[1];
                String toUnit = parts[3];
                double result = convert(value, fromUnit, toUnit);
                System.out.println(value + " " + fromUnit + " = " + result + " " + toUnit);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input format. Try again.");
            }
        }
    }

    private static double convert(double value, String fromUnit, String toUnit) {
        switch (fromUnit + " " + toUnit) {
            case "kg lb":
                return value * 2.20462;
            case "g oz":
                return value * 0.035274;
            case "km mi":
                return value * 0.621371;
            case "mm in":
                return value * 0.03937;
            default:
                return 0.0; 
        }
    }
}