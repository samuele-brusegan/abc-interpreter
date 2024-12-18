import java.io.File;
import java.io.IOException;

import static java.lang.Thread.sleep;
import static utilities.General.input;
import static utilities.Print.*;

public class Graphics {
	Graphics(){
	
	}
	void printHeading(){
		println("+---------------------------------------------------------------------------------------------------------+");
		println("|                                                                                                         |");
		println("|                                   _     _         _____       _                           _             |");
		println("|      /\\                          | |   | |       |_   _|     | |                         | |            |");
		println("|     /  \\   ___ ___  ___ _ __ ___ | |__ | |_   _    | |  _ __ | |_ ___ _ __ _ __  _ __ ___| |_ ___ _ __  |");
		println("|    / /\\ \\ / __/ __|/ _ \\ '_ ` _ \\| '_ \\| | | | |   | | | '_ \\| __/ _ \\ '__| '_ \\| '__/ _ \\ __/ _ \\ '__| |");
		println("|   / ____ \\\\__ \\__ \\  __/ | | | | | |_) | | |_| |  _| |_| | | | ||  __/ |  | |_) | | |  __/ ||  __/ |    |");
		println("|  /_/    \\_\\___/___/\\___|_| |_| |_|_.__/|_|\\__, | |_____|_| |_|\\__\\___|_|  | .__/|_|  \\___|\\__\\___|_|    |");
		println("|                                            __/ |                          | |                           |");
		println("|                                           |___/                           |_|                           |");
		println("|                                                                                                         |");
		println("+---------------------------------------------------------------------------------------------------------+");
	}
	String printFileDropdown(String path) {
		try {
			File file = new File(path);
			String[] arr = file.list();
			for (int i = 0; i < arr.length; i++) {
				System.out.printf("%-106s","| "+(i+1)+". "+arr[i]);
				println("|");
			}
			println("|                                                                                                         |");
			int selected = input("|\tSeleziona il file(1-"+arr.length+"): ", 0);
			println("|                                                                                                         |");
			System.out.printf("%-117s","|  You have selected "+colorizer(arr[selected-1], "blue-li")+" file."); println("|");
			println("|                                                                                                         |");
			println("+---------------------------------------------------------------------------------------------------------+");
			sleep(100);
			return arr[selected-1];
			
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		//clearConsole();
	}
	
	public static void clearConsole() {
		try {
			if (System.getProperty("os.name").contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			}
			else {
				System.out.print('\u000C');
				System.out.print("\033\143");
			}
		} catch (IOException | InterruptedException ex) {}
	}
}
