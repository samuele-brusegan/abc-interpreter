import instr.Istruzioni;
import java.io.BufferedReader;
import static utilities.General.input;
import static utilities.Print.*;
import static utilities.Strings.*;
import static instr.Istruzioni.*;


public class Main {
    static String accumulatore = "";
    static String accBack = "";
    static int ix = 0;
    static int iy = 0;

    //static int accInt = 0;

    static String FILE_EXTENSION = "mtcp";
    //static String file_name      = "euclide";
    static String file_name      = "numPrimeNew";
    static boolean foundEnd      = false;

    static boolean debug         = false;
    static boolean showTrace     = false;
    static boolean verbose       = false;

    public static void main(String[] args) throws Exception {
        file_name="src/"+file_name+"."+FILE_EXTENSION;
        Istruzioni.populateMemory(file_name);
        exec(0);
    }
    public static void exec(int targetIP) throws Exception {
        BufferedReader br; try {
            br = initFile(file_name);
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
        String str;
        int instructionPointer = 0;
        while ((str = br.readLine()) != null && instructionPointer < getMemoryLength(file_name) && !foundEnd) {
            str = remSpace(str);
            String strNoComment = str.split("\\|")[1];

            if(strNoComment.length() <= 1) continue;
            instructionPointer++;
            String inst = strNoComment.substring(0, 2);
            String addr = (strNoComment.substring(2));

            if(verbose) print((dec2hex(instructionPointer-1)).toUpperCase() + "\t");

            if (instructionPointer > targetIP) {
                if(debug && !verbose) print((dec2hex(instructionPointer-1)).toUpperCase() + "\t");
                
                sortInstruction(inst, addr, instructionPointer);
                
            } else if (verbose) {
                printColor("\t  "+strNoComment+"\n", "cyan");
            }
            accBack = accumulatore;
        }
    }

    private static void sortInstruction(String inst, String addr, int instructionPointer) throws Exception {
        switch (inst) {
            //VER 0
            case "00" -> {
                if (debug) {

                    println("LOAD: \t" + addr);
                }
                accumulatore = load(addr);
                //accInt = hex2dec(load(addr));
            }
            case "01" -> {
                if (debug) {

                    println("STORE: \t" + addr);
                }
                store(addr, accumulatore);
                //store(addr, dec2hex(accInt));
            }
            case "02" -> {
                if (debug) {

                    println("IN: \t" + addr);
                    print(" \t\t");
                }
                accumulatore = input("Inserisci un valore(HEX): ", "");
                //accInt = hex2dec(input("Inserisci un valore(HEX): ", ""));
            }
            case "03" -> {
                if (debug) {

                    println("OUT: \t" + addr);
                    print(" \t\t");
                }
                if(debug || verbose) {
                    printColor("0x"+ accumulatore+"\n", "green");
                } else {
                    println("0x"+ accumulatore);
                }
                //println(addr + " -> 0x"+dec2hex(accInt));
            }
            case "04" -> {
                if (debug) {

                    println("ADD: \t" + addr);
                }
                if(showTrace) print(accumulatore+"\t->\t");
                accumulatore = add(accumulatore, addr);
                if(showTrace) println(accumulatore);
            }
            case "05" -> {
                if (debug) {
                    println("SUB: \t" + addr);
                }
                if(showTrace) print(accumulatore+"\t->\t");
                accumulatore = sub(accumulatore, addr);
                if(showTrace) println(accumulatore);
            }
            case "06" -> {
                if (debug) {

                    println("MUL: \t" + addr);
                }
                if(showTrace) print(accumulatore+"\t->\t");
                accumulatore = mul(accumulatore, addr);
                if(showTrace) println(accumulatore);
            }
            case "07" -> {
                if (debug) {

                    println("DIV: \t" + addr);
                }
                if(showTrace) print(accumulatore+"\t->\t");
                accumulatore = div(accumulatore, addr);
                if(showTrace) println(accumulatore);
            }
            case "08" -> {
                if (debug) {

                    println("MOD: \t" + addr);
                }
                if(showTrace) print(accumulatore+"\t->\t");
                accumulatore = mod(accumulatore, addr);
                if(showTrace) println(accumulatore);
            }
            case "09" -> {
                if (debug) {

                    println("AND: \t" + addr);
                }
                println("(AND) NOT WORKING");
            }
            case "0A" -> {
                if (debug) {

                    println("OR: \t" + addr);
                }
                println("(OR) NOT WORKING");
            }
            case "0B" -> {
                if (debug) {

                    println("XOR: \t" + addr);
                }
                println("(XOR) NOT WORKING");
            }
            case "0C" -> {
                if (debug) {
                    println("JUMP: \t" + addr + "\tinc.");
                }
                exec(hex2dec(addr));
                return;
            }
            case "0D" -> {
                if (debug) {

                    print("jz \t\t" + addr+"\t(x=0)");
                }
                if (hex2dec(accumulatore) == 0) {
                    if(debug) println("\t true");
                    exec(hex2dec(addr));
                    return;
                }
                if(debug) println("\t false");
            }
            case "0E" -> {
                if (debug) {
                    //jlz
                    print("jlz \t" + addr+"\t(x<0)");
                }
                if (hex2dec(accumulatore) < 0) {
                    if(debug) println("\t true");
                    exec(hex2dec(addr));
                    return;
                }
                if(debug) println("\t false");

            }
            case "0F" -> {
                if (debug) {
                    //jgz
                    print("jgz \t" + addr+"\t(x>0)");
                }
                if (hex2dec(accumulatore) > 0) {
                    if(debug) println("\t true");
                    exec(hex2dec(addr));
                    return;
                }
                if(debug) println("\t false");
            }

            //VER 1
            case "10" -> {
                if (debug) {
                    println("LOAD IX: \t" + addr);
                }
                String newAddr = dec2hex(hex2dec(addr)+ix);
                accumulatore = load(newAddr);
            }
            case "11" -> {
                if (debug) {
                    println("STORE IX: \t" + addr);
                }
                String newAddr = dec2hex(hex2dec(addr)+ix);
                store(newAddr, accumulatore);
            }
            case "12" -> {
                if (debug) {
                    println("INIT IX: \t" + addr);
                }
                ix = hex2dec(addr);
            }
            case "13" -> {
                if (debug) {
                    println("INIT IY: \t" + addr);
                }
                iy = hex2dec(addr);
            }
            case "14" -> {
                if (debug) {
                    println("ADD IX: \t" + addr);
                }
                ix += hex2dec(addr);
            }
            case "15" -> {
                if (debug) {
                    println("SUB IX: \t" + addr);
                }
                ix -= hex2dec(addr);
            }
            case "16" -> {
                if (debug) {
                    println("LOAD IY: \t" + addr);
                }
                String newAddr = dec2hex(hex2dec(addr)+iy);
                accumulatore = load(newAddr);
            }
            case "17" -> {
                if (debug) {
                    println("STORE IY: \t" + addr);
                }
                String newAddr = dec2hex(hex2dec(addr)+iy);
                store(newAddr, accumulatore);
            }
            case "18" -> {
                if (debug) {
                    println("ADD IY: \t" + addr);
                }
                iy += hex2dec(addr);
            }
            case "19" -> {
                if (debug) {
                    println("SUB IY: \t" + addr);
                }
                iy -= hex2dec(addr);
            }
            case "1A" -> {
                if (debug) {
                    println("SKIP IX LT: \t" + addr);
                }
                if (ix < hex2dec(addr)) exec(instructionPointer+1);
            }
            case "1B" -> {
                if (debug) {
                    println("SKIP IX GT: \t" + addr);
                }
                if (ix > hex2dec(addr)) exec(instructionPointer+1);
            }
            case "1C" -> {
                if (debug) {
                    println("SKIP IX EQ: \t" + addr);
                }
                if (ix == hex2dec(addr)) exec(instructionPointer+1);
            }
            case "1D" -> {
                if (debug) {
                    println("SKIP IY LT: \t" + addr);
                }
                if (iy < hex2dec(addr)) exec(instructionPointer+1);
            }
            case "1E" -> {
                if (debug) {
                    println("SKIP IY GT: \t" + addr);
                }
                if (iy > hex2dec(addr)) exec(instructionPointer+1);
            }
            case "1F" -> {
                if (debug) {
                    println("SKIP IY EQ: \t" + addr);
                }
                if (iy == hex2dec(addr)) exec(instructionPointer+1);
            }


            //END
            case "FF" -> {
                foundEnd = true;
            }
        }
    }
}