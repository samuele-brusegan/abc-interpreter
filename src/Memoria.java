import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static instr.Istruzioni_bak.*;

import static java.lang.Math.pow;
import static utilities.Print.*;
import static utilities.Strings.countChar;
import static utilities.Strings.remSpace;

public class Memoria {
	int length;
	String[] memory = {};
	
	Memoria(String file_name){
		this.length = getMemoryLength(file_name);
		this.initMemory(file_name);
	}
	
	void initMemory(String file_name){
		this.populateMemory(file_name);
		//memory = new String[length];
	}
	void populateMemory(String file_name) {
		try {
			memory = Arrays.copyOf(memory, length);
			Path path = FileSystems.getDefault().getPath(file_name);

			Stream<String> lines = Files.lines(path);
			String data = lines.collect(Collectors.joining("\n"));
			String[] rows = remSpace(data).split("\n");
			
			for (int i = 0; i < rows.length; i++) {
				memory[i] = rows[i].split("\\|")[1];
			}
			
			lines.close();
		} catch (Exception e){printErr(e+"");}
	}
	private int getMemoryLength(String file_name){
		
		try {
			Path path = FileSystems.getDefault().getPath(file_name);
			Stream<String> lines = Files.lines(path);
			String data = lines.collect(Collectors.joining("\n"));
			lines.close();
			return countChar(data, '\n')+1;
			
		} catch (Exception e){printErr(e+"");}
		return -1;
	}
	

	void write(Addr24 address, Hex valueObj) {
		String value = valueObj.value;
		int addr = address.addr_int;
		if(addr <= this.length){
			this.memory[addr] = remSpace(value);
		} else {
			this.memory = Arrays.copyOf(memory, addr+1);
			this.memory[addr] = remSpace(value);
		}
	}
	
	Hex read(Addr24 address) {
		return new Hex(memory[address.addr_int]);
	}
	
	void printMemory(){
		int i = 0;
		println("+----------+----------+");
		println("| -ADDR24- | -MEMORY- |");
		println("+----------+----------+");
		for(String s : memory){
			print("| "+ANSI_CYAN);
			if(i<pow(16, 1)) print("0x00000");
			else if(i<pow(16, 2)) print("0x0000");
			else if(i<pow(16, 3)) print("0x000");
			else if(i<pow(16, 4)) print("0x00");
			else if(i<pow(16, 5)) print("0x0");
			else if(i<pow(16, 6)) print("0x");
			print(dec2hex(i).toUpperCase());
			print(ANSI_RESET);
			print(" | ");
			printColor(s.substring(0, 2), "green");
			println(s.substring(2)+" |");
			i++;
		}
		println("+----------+----------+");
	}
	
}
