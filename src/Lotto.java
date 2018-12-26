import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lotto {

    public static void main(String[] args) {
        drawGuessTab();
        winTabGenerator();
        winCheck();
    }

    static int[] winTab = new int[6];
    static int[] guessTab = new int[6];

    static void winTabGenerator() {
        Random r = new Random();

        for (int i = 0; i < winTab.length; i++) {
            int draw = r.nextInt(49) + 1;
            while (checkRepeatibility(draw, winTab)) {
                draw = r.nextInt(49) + 1;
            }
            winTab[i] = draw;
        }
        Arrays.sort(winTab);
        System.out.println("Szczęśliwe liczby na dziś to: " + Arrays.toString(winTab));
    }

    static void shuffleTab() {

    }

    static boolean checkRepeatibility(int intToCheck, int[] tabToCheck) {
        boolean state = false;
        for (int tabElement : tabToCheck) {
            if (intToCheck == tabElement) {
                state = true;
                break;
            }
        }
        return state;
    }

    static int scnInt() {
        Scanner scn = new Scanner(System.in);
        int draw;
        while (!scn.hasNextInt()) {
            System.out.println("To nie jest liczba!");
            scn.nextLine();
        }
        draw = scn.nextInt();
        return draw;
    }

    static boolean checkIntRange(int intToCheck) {
        boolean state = false;
        if (intToCheck < 1 || intToCheck > 49) {
            System.out.println("Liczba z poza zakresu!");
            state = true;
        }
        return state;
    }

    static void drawGuessTab() {
        for (int i = 0; i < 6; i++) {
            System.out.println("Podaj liczbę nr" + (i + 1));
            int draw = drawProperInt();
            guessTab[i] = draw;
        }
        Arrays.sort(guessTab);
        System.out.println("Wybrano nastepujące liczby: " + Arrays.toString(guessTab));
    }

    static int drawProperInt() {
        int draw = scnInt();
        while (checkIntRange(draw) || checkRepeatibility(draw, guessTab)) {
            if (checkRepeatibility(draw, guessTab)) {
                System.out.println("Ta liczba już została wybrana!");
            }
            draw = scnInt();
        }
        return draw;
    }

    static void winCheck() {
        int hitCount = 0;
        for (int winElement : winTab) {
            for (int guessElement : guessTab) {
                if (winElement == guessElement) {
                    hitCount++;
                }
            }
        }
        System.out.println("Celne strzały to: "+hitCount+"!");
    }
}
