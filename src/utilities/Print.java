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

    /**
     * Prints an array
     * @param array the array to be printed
     */
    public static void printArray(int[] array){
        for (int arrayItem : array) {
            System.out.print(arrayItem + ", ");
        }
    }
    public static void printArray(int[] array, String string){
        for (int arrayItem : array) {
            System.out.print(arrayItem + ", ");
        }
        System.out.print(string);
    }
    public static void printArrayLn(int[] array){
        for (int arrayItem : array) {
            System.out.print(arrayItem + ", ");
        }
        System.out.println();
    }

    public static void printTabulatedArray(int[] array){
        for (int arrayItem : array) {
            System.out.printf("%5s", arrayItem);
        }
        System.out.println();
    }
    public static void printMatrix(int[][] matrix){
        for (int[] item : matrix) {
            printTabulatedArray(item);
        }
    }

}
