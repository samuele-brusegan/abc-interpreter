package instr;

//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utilities.Print.*;
import static utilities.Strings.*;

@SuppressWarnings("StringConcatenationInLoop")
public class Istruzioni_bak {

    //public static String[] memory = new String[memLength];
    public static String[] memory = new String[10];

    //VER 1
//    public static String load(String addr) {
//        int targetAddress = hex2dec(addr);
//        return memory[targetAddress];
//    }
//    public static void store(String addr, String accHEX) {
//        int a = 0;
//        memoryWrite(addr, accHEX);
//    }
//
//    public static String add(String accHEX, String addr) {
//        int targetAddress = hex2dec(addr);
//        int value = hex2dec(memory[targetAddress]);
//        int accVal = hex2dec(accHEX);
//        return dec2hex(accVal + value);
//    }
//    public static String sub(String accHEX, String addr) {
//        int targetAddress = hex2dec(addr);
//
//        int accVal = hex2dec(accHEX);
//        int value = hex2dec(memory[targetAddress]);
//
//        //println(accVal + " - " + value);
//        int subValue = accVal - value;
//        //println(subValue);
//        return dec2hex(subValue);
//    }
//    public static String mul(String accHEX, String addr) {
//        int targetAddress = hex2dec(addr);
//        int value = hex2dec(memory[targetAddress]);
//        int accVal = hex2dec(accHEX);
//        return dec2hex(accVal * value);
//    }
//    public static String div(String accHEX, String addr) {
//        int targetAddress = hex2dec(addr);
//        int value = hex2dec(memory[targetAddress]);
//        int accVal = hex2dec(accHEX);
//        return dec2hex(accVal / value);
//    }
//    public static String mod(String accHEX, String addr) {
//        int targetAddress = hex2dec(addr);
//        int value = hex2dec(memory[targetAddress]);
//        int accVal = hex2dec(accHEX);
//        return dec2hex(accVal % value);
//    }

    //INT accumulator
    /*/    public static int addInt(int acc, String addr) {
    //        int targetAddress = hex2dec(addr);
    //        int value = hex2dec(memory[targetAddress]);
    //        return acc + value;
    //    }
    //
    //    public static int subInt(int acc, String addr) {
    //        int targetAddress = hex2dec(addr);
    //        int value = hex2dec(memory[targetAddress]);
    //        return acc - value;
    //    }
    //
    //    public static int mulInt(int acc, String addr) {
    //        int targetAddress = hex2dec(addr);
    //        int value = hex2dec(memory[targetAddress]);
    //        return acc * value;
    //    }
    //
    //    public static int divInt(int acc, String addr) {
    //        int targetAddress = hex2dec(addr);
    //        int value = hex2dec(memory[targetAddress]);
    //        return acc / value;
    //    }
    //
    //    public static int modInt(int acc, String addr) {
    //        int targetAddress = hex2dec(addr);
    //        int value = hex2dec(memory[targetAddress]);
    //        return acc % value;
    //    }*/

    //Utils
    public static int hex2dec(String hex)    {
        // Converte la stringa hex in un intero decimale utilizzando la funzione parseInt
        return (int) Long.parseLong(hex, 16);
    }
    public static String dec2hex(int dec)    {
        /*boolean segno = false; //F -> POS; T -> NEG
        if(dec<0){
            segno = true;
            dec = -dec;
        }

        int temp = dec;
        int base_des = 16;
        String hex_rev = "";
        char[] hex_chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

        while (temp >= base_des-1) {
            hex_rev += hex_chars[temp % base_des];
            temp /= base_des;
        }

        String hex = reverse(hex_rev);

        String out;
        if (!segno) {
            out = hex;
        } else {
            String bin = hex2bin(hex);
            int num_zeros = 8 - bin.length();
            for (int i = 0; i < num_zeros; i++) {
                bin = '0' + bin;
            }
            String ca2 = ca2(bin);
            println("CA2:\t"+ca2);
            out = bin2hex(ca2);
        }
        return out;*/
        return Integer.toHexString(dec);
    }
    public static String hex2bin(String hex) {
        char[] hex_chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String[] bin_equivalent = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String bin = "";
        for (int i = 0; i < hex.length(); i++) {
            //Trovo index of curr_char
            char curr_char = hex.charAt(i);
            int index = Arrays.binarySearch(hex_chars, curr_char);

            //Converto
            bin += bin_equivalent[index];
        }
        return bin;
    }
    public static String bin2hex(String bin) {
        char[] hex_chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        String[] bin_char = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010", "1011", "1100", "1101", "1110", "1111"};
        String hex = "";
        for (int i = 0; i < bin.length(); i+=4) {
            String hex_ch = bin.substring(i, i + 4);
            int index = Arrays.binarySearch(bin_char, hex_ch);
            hex += hex_chars[index]+"";
            println(hex_ch);
        }
        return hex;
    }
    public static String   ca2  (String bin) {
        String bin_rev = reverse(bin);
        String ca2_rev = "";
        boolean firstOneFound = false;
        for (int i = 0; i < bin_rev.length(); i++) {
            if(!firstOneFound){
                if (bin_rev.charAt(i) == '1') firstOneFound = true;
                ca2_rev += bin_rev.charAt(i);
            } else {
                if (bin_rev.charAt(i) == '0') ca2_rev += 1;
                if (bin_rev.charAt(i) == '1') ca2_rev += 0;
            }
        }
        return reverse(ca2_rev);
    }

    /*public static BufferedReader initFile(String file_name) {

	    try {
	        Path path = Paths.get(file_name);
	        Path absolutePath = path.toAbsolutePath();
	        File file = new File(String.valueOf(absolutePath));
	    
		    return new BufferedReader(new FileReader(file));
	    } catch (FileNotFoundException e) {
		    throw new RuntimeException(e);
	    }
    }*/
	
	public void givenFilePath_whenUsingFilesLines_thenFileData(String file_name) {
		try {
			Path path = Paths.get(getClass().getClassLoader().getResource(file_name).toURI());
			Stream<String> lines = Files.lines(path);
			String data = lines.collect(Collectors.joining("\n"));
			lines.close();
			
		} catch (Exception e){print("File not found");}
	}
	
	/*
    //Manage Virtual Memory
    public static int getMemoryLength(String file_name) throws Exception {
        BufferedReader br = initFile(file_name);

        int numberOfRows = 0;
        while (br.readLine() != null) {
            numberOfRows++;
        }
        return numberOfRows;
    }
    public static void memoryWrite(String address, String AccHEX) {
        int addr = hex2dec(address);
        int accDEC = hex2dec(AccHEX);
        memory[addr] = remSpace(Integer.toHexString(accDEC));
    }
    public static void populateMemory(String file_name) throws Exception {
        BufferedReader br = initFile(file_name);
        String str;
        memory = Arrays.copyOf(memory, getMemoryLength(file_name));

        int memoryCell = 0;
        while ((str = br.readLine()) != null) {
            if (str.charAt(str.length() - 1) == 'x') {
                str = str.substring(0, str.length() - 1);
            }
            memory[memoryCell] = remSpace(str).split("\\|")[1];
            memoryCell++;
        }
    }*/

}