package utilities;

public class Print {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void print(String arg){
        System.out.print(arg);
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void print(int arg){
        System.out.print(arg);
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void print(float arg){
        System.out.print(arg);
    }


    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void println(String arg){
        System.out.print(arg+"\n");
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void println(int arg){
        System.out.print(arg+"\n");
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void println(float arg){
        System.out.print(arg+"\n");
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void println(double arg){
        System.out.print(arg+"\n");
    }


    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void printErr(String arg){
        println(ANSI_RED + arg + ANSI_RESET);
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void printErr(int arg){
        println(ANSI_RED + arg + ANSI_RESET);
    }
    /**
     * Prints the argument
     * @param arg the value to be printed
     */
    public static void printErr(float arg){
        println(ANSI_RED + arg + ANSI_RESET);
    }


    public static void printColor(String arg, String color){
        switch (color){
            case "black" -> print(ANSI_BLACK + arg + ANSI_RESET);
            case "red" -> print(ANSI_RED + arg + ANSI_RESET);
            case "green" -> print(ANSI_GREEN + arg + ANSI_RESET);
            case "yellow" -> print(ANSI_YELLOW + arg + ANSI_RESET);
            case "blue" -> print(ANSI_BLUE + arg + ANSI_RESET);
            case "cyan" -> print(ANSI_CYAN + arg + ANSI_RESET);
            case "purple" -> print(ANSI_PURPLE + arg + ANSI_RESET);

            default -> print(ANSI_WHITE + arg + ANSI_RESET);

        }
    }
    public static void printColor(int arg, String color){
        printColor(arg + "", color);
    }
    public static void printColor(float arg, String color){
        printColor(arg + "", color);
    }


}
