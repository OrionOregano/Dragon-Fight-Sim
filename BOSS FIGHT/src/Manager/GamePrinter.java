package Manager;

// PRINTER FOR VARIOUS STYLES OF TEXT, EACH ONE GOES THROUGH THE TEXT DIFFERENTLY

public class GamePrinter {

    // PRINTS ONE BY ONE SOMEWHAT SLOWLY
    public static void println(String text) {
        int delay = 13;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
        System.out.println();
    }

    // PRINTS ONE BY ONE SOMEWHAT SLOWLY
    public static void print(String text) {
        int delay = 13;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
    }

    // FASTER PRINT
    public static void fastPrint(String text) {
        int delay = 3;
        for (char c : text.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
        System.out.println();
    }

    // PRINTS A DIVIDER
    public static void printDivider() {
        String div = "---------------------------------------";
        int delay = 6;
        for (char c : div.toCharArray()) {
            System.out.print(c);
            sleep(delay);
        }
        System.out.println();
    }

    // PRINTS TITLE
    public static void printTitle() {
        // CALLED TO CLEAR THE SCREEN
        clearScreen();
        String[] art = {
            "/$$$$$$$$  /$$$$$$$  /$$$$$$$  /$$$$$$$       /$$$$$$$$$/$$$$$$$$/$$$$$$  /$$   /$$ /$$$$$$$$$",
            "| $$__  $$ /$$__  $$ /$$__  $$ /$$__  $$      | $$_____/|_  $$_/ /$$__  $$| $$  | $$|__  $$__/",
            "| $$  \\ $$| $$  \\ $$| $$  \\__/| $$  \\__/      | $$        | $$  | $$  \\__/| $$  | $$   | $$",
            "| $$$$$$$ | $$  | $$|  $$$$$$ |  $$$$$$       | $$$$$     | $$  | $$ /$$$$| $$$$$$$$   | $$",
            "| $$__  $$| $$  | $$ \\____  $$ \\____  $$      | $$__/     | $$  | $$|_  $$| $$__  $$   | $$",
            "| $$  \\ $$| $$  | $$ /$$  \\ $$ /$$  \\ $$      | $$        | $$  | $$  \\ $$| $$  | $$   | $$",
            "| $$$$$$$/|  $$$$$$/|  $$$$$$/|  $$$$$$/      | $$       /$$$$$$|  $$$$$$/| $$  | $$   | $$",
            "|_______/  \\______/  \\______/  \\______/       |__/      |______/ \\______/ |__/  |__/   |__/"
        };

        GamePrinter.println("");
        for (String line : art) {
            System.out.println(line);
            sleep(200);
        }

        System.out.println("\n");
    }

    // TO CREATE THE DELAY SO TEXT SLOWLY PRINTS OUT
    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // FOR CLEARING THE SCREEN
    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}