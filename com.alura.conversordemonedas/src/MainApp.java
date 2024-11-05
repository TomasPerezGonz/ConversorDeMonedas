import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyConverter converter = new CurrencyConverter();

        boolean continueConversion = true;

        while (continueConversion) {
            converter.displayCurrencyOptions();

            System.out.print("Ingrese el número de la moneda que desea convertir: ");
            int fromChoice = scanner.nextInt();
            String fromCurrency = converter.getCurrencyCode(fromChoice);

            System.out.print("Ingrese el número de la moneda a la que desea convertir: ");
            int toChoice = scanner.nextInt();
            String toCurrency = converter.getCurrencyCode(toChoice);

            System.out.print("Ingrese la cantidad a convertir: ");
            double amount = scanner.nextDouble();

            double convertedAmount = converter.convertCurrency(fromCurrency, toCurrency, amount);

            if (convertedAmount != 0) {
                System.out.printf("%.2f %s son %.2f %s\n", amount, fromCurrency, convertedAmount, toCurrency);
            }

            System.out.print("¿Desea realizar otra conversión? (s/n): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("s")) {
                continueConversion = false;
            }
        }

        System.out.println("Gracias por usar el conversor de monedas.");
        scanner.close();
    }
}
