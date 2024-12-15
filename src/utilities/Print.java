package utilities;

public class Print {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_LIGHT_PURPLE = "\033[1;35m";
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
	    switch (color) {
		    case "black" -> {
			    print(ANSI_BLACK + arg + ANSI_RESET);
		    }
		    case "red" -> {
			    print(ANSI_RED + arg + ANSI_RESET);
		    }
		    case "green" -> {
			    print(ANSI_GREEN + arg + ANSI_RESET);
		    }
		    case "yellow" -> {
			    print(ANSI_YELLOW + arg + ANSI_RESET);
		    }
		    case "blue" -> {
			    print(ANSI_BLUE + arg + ANSI_RESET);
		    }
		    case "cyan" -> {
			    print(ANSI_CYAN + arg + ANSI_RESET);
		    }
		    case "purple" -> {
			    print(ANSI_PURPLE + arg + ANSI_RESET);
		    }
            case "purple-li" -> {
                print(ANSI_LIGHT_PURPLE + arg + ANSI_RESET);
            }
		    default -> {
			    print(ANSI_WHITE + arg + ANSI_RESET);
		    }
	    }
    }
	
	/**
	 *
	 * @param arg the parameter to be colored
	 * @param color the color (accepted: black, red, green, yellow, blue, cyan, purple, purple-li)
	 * @return a string with at the start the ANSI code for the color selected and at the ant the ANSI code for the reset color
	 */
	public static String colorizer(String arg, String color){
		switch (color) {
			case "black" -> {
				return(ANSI_BLACK + arg + ANSI_RESET);
			}
			case "red" -> {
				return(ANSI_RED + arg + ANSI_RESET);
			}
			case "green" -> {
				return(ANSI_GREEN + arg + ANSI_RESET);
			}
			case "yellow" -> {
				return(ANSI_YELLOW + arg + ANSI_RESET);
			}
			case "blue" -> {
				return(ANSI_BLUE + arg + ANSI_RESET);
			}
			case "cyan" -> {
				return(ANSI_CYAN + arg + ANSI_RESET);
			}
			case "purple" -> {
				return(ANSI_PURPLE + arg + ANSI_RESET);
			}
			case "purple-li" -> {
				return(ANSI_LIGHT_PURPLE + arg + ANSI_RESET);
			}
			default -> {
				return(ANSI_WHITE + arg + ANSI_RESET);
			}
		}
	}
	public static String colorizer(int arg, String color){
		return colorizer(arg+"", color);
	}
	public static String colorizer(float arg, String color){
		return colorizer(arg+"", color);
	}
    public static void printColor(int arg, String color){
        printColor(arg + "", color);
    }
    public static void printColor(float arg, String color){
        printColor(arg + "", color);
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
	public static void printArray(char[] array){
		for (char arrayItem : array) {
			System.out.print(arrayItem + ", ");
		}
	}
	public static void printArray(String[] array){
		for (String arrayItem : array) {
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
