import java.util.Random;
import java.util.Scanner;

public class Zgadywanie {

    public static void main(String[] args) {
        generateRandom();
        System.out.println("Zgadni liczbę od 1 do 100");
        scnInt();
        checkAnswer();
    }

    static private int intRandom;
    static private int scnnedInt;

    static void generateRandom() {
        Random random = new Random();
        intRandom = random.nextInt(101);
    }

    static void scnInt() {
        Scanner scn = new Scanner(System.in);
        while (!scn.hasNextInt()) {
            System.out.println("To nie jest liczba!");
            scn.next();
        }
        scnnedInt = scn.nextInt();
    }

    static void checkAnswer() {
        while (intRandom != scnnedInt) {
            if (intRandom > scnnedInt) {
                System.out.println("Za mało!");
                scnInt();
            } else if (intRandom < scnnedInt) {
                System.out.println("Za dużo!");
                scnInt();
            }
        }
        System.out.println("Brawo! Liczba została odgadniętą.");
    }
}
