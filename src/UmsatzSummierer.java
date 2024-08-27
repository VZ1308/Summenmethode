import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Main {

    // Methode zur Berechnung der Summe von x-beliebig (double...) vielen Zahlen
    public static double sumNumbers(double... numbers) {
        double sum = 0;

        // Iteriere über jedes Element im numbers-Array und addiere es zur Summe
        for (double num : numbers) {
            sum += num;
        }

        // Anzahl der eingegebenen Zahlen ausgeben
        System.out.println("Anzahl der eingegebenen Zahlen: " + numbers.length);

        // Ergebnis zurückgeben
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        Set<Double> uniqueUmsatze = new HashSet<>();

        // Zeitraum vom Benutzer abfragen
        System.out.print("Geben Sie den Startmonat (1-12) ein: ");
        int startMonth = scanner.nextInt();

        System.out.print("Geben Sie den Endmonat (1-12) ein: ");
        int endMonth = scanner.nextInt();

        // Sicherstellen, dass der Zeitraum gültig ist
        if (startMonth < 1 || startMonth > 12 || endMonth < 1 || endMonth > 12 || startMonth > endMonth) {
            System.out.println("Ungültiger Zeitraum. Bitte geben Sie Monate zwischen 1 und 12 ein, und der Endmonat muss nach dem Startmonat liegen.");
            return;
        }

        // Anzahl der Monate im Zeitraum berechnen
        int numberOfMonths = endMonth - startMonth + 1;

        // Zufällige Umsatzzahlen generieren, die eindeutig sind
        while (uniqueUmsatze.size() < numberOfMonths) {
            double newUmsatz = random.nextDouble() * 15000; // Zufallsumsatz zwischen 0 und 15.000
            if (uniqueUmsatze.add(newUmsatz)) { // Umsatz hinzufügen, wenn er noch nicht existiert
                System.out.printf("Umsatz für Monat %d: %.2f EUR\n", startMonth + uniqueUmsatze.size() - 1, newUmsatz);
            }
        }

        // Summe der zufälligen Umsätze berechnen
        double sum = sumNumbers(uniqueUmsatze.stream().mapToDouble(Double::doubleValue).toArray());
        System.out.printf("Summe der Umsätze im Zeitraum: %.2f EUR\n", sum);
    }
}
