import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.##");

        
        while (true) {
            System.out.println("Currency Converter");
            System.out.println("------------------");

            // Input amount
            System.out.print("Enter amount: ");
            double amount;
            try {
                amount = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                continue;
            }

            
            System.out.print("From (USD, EUR, GBP, INR): ");
            String fromCurrency = scanner.nextLine().toUpperCase();

            
            System.out.print("To (USD, EUR, GBP, INR): ");
            String toCurrency = scanner.nextLine().toUpperCase();

            
            double convertedAmount = convertCurrency(amount, fromCurrency, toCurrency);

            
            if (convertedAmount != -1) {
                System.out.println("Converted Amount: " + df.format(convertedAmount) + " " + toCurrency);
            } else {
                System.out.println("Invalid currency conversion.");
            }

            
            System.out.print("Do you want to convert another amount? (yes/no): ");
            String choice = scanner.nextLine().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Exiting Currency Converter. Goodbye!");
                break;
            }
        }

        scanner.close();
    }

    
    private static double convertCurrency(double amount, String from, String to) {
        
        double rate = 0.0;
        if (from.equals("USD") && to.equals("EUR")) rate = 0.85;
        else if (from.equals("USD") && to.equals("GBP")) rate = 0.75;
        else if (from.equals("USD") && to.equals("INR")) rate = 75.0;
        else if (from.equals("EUR") && to.equals("USD")) rate = 1.18;
        else if (from.equals("EUR") && to.equals("GBP")) rate = 0.88;
        else if (from.equals("EUR") && to.equals("INR")) rate = 88.5;
        else if (from.equals("GBP") && to.equals("USD")) rate = 1.33;
        else if (from.equals("GBP") && to.equals("EUR")) rate = 1.14;
        else if (from.equals("GBP") && to.equals("INR")) rate = 100.5;
        else if (from.equals("INR") && to.equals("USD")) rate = 0.013;
        else if (from.equals("INR") && to.equals("EUR")) rate = 0.011;
        else if (from.equals("INR") && to.equals("GBP")) rate = 0.0099;
        else if (from.equals(to)) rate = 1.0;
        else return -1; 
        return amount * rate;
    }
}
