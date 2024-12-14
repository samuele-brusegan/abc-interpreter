package utilities;

import java.util.Scanner;
import static utilities.Print.*;

@SuppressWarnings("unused")
public class General {
    /**
     * Takes an input from the user, prompting the {@code String} str
     * @param str the prompt for the user
     * @param a a value with the same type of the desired return
     * @return the {@code int} typed by the user
     */
    public static int input(String str, int a) {
        Scanner input = new Scanner(System.in);
        print(str);
        return input.nextInt();
    }

    /**
     * Takes an input from the user, prompting the {@code String} str
     *
     * @param str the prompt for the user
     * @param a a value with the same type of the desired return
     * @return the {@code String} typed by the user
     */
    public static String input(String str, String a) {
        Scanner input = new Scanner(System.in);
        print(str);
        return input.nextLine();
    }
}
