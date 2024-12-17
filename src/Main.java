import static java.lang.Thread.sleep;
import static utilities.General.input;
import static utilities.Print.*;


public class Main {
	static Addr32 accumulatore = new Addr32();
	static InsReg ir           = new InsReg();
	
	static Addr24 ip           = new Addr24();
	static Addr24 ix           = new Addr24();
	static Addr24 iy           = new Addr24();
	static Memoria memory;
	
	//static int accInt = 0;
	
	static String FILE_EXTENSION = "mtcp";
	static String file           = "numPrimeNew";
	static String file_name;
	//static String file_name      = "euclide";
	
	//Settings
	static boolean foundEnd      = false;
	
	static boolean debug         = true;
	static boolean showTrace     = false;
	static boolean verbose       = false;
	
	public static void main(String[] args) throws Exception {
		
		userInterface();
		//file_name = "src/assembledCode/"+file+"."+FILE_EXTENSION;
		file_name = "src/assembledCode/"+file;
		
		//Click Reset
		memory = new Memoria(file_name);
		memory.populateMemory(file_name);
		//memory.printMemory();
		
		//IP = 0
		ip.setAddr(new Hex("000000"));
		if(debug)println("+----+----------+");
		while (!foundEnd){
			//print(ip.addr_int);
			
			//Fetch
			ir.initIR(memory.read(ip)); //Decode
			ip.incrementa();
			
			if(debug){
				print("| ");
				System.out.printf("%2s", new Hex().toHex(ip.addr_int -1).value);
				print(" | " + ir.addr_hex.value + " | ");
			}
			
			//Execute
			execute();
			//println("");
			if(debug) {
				//println("");
				sleep(100);
			}
		}
		if(debug)println("\n+----+----------+");
	}
	
	private static void execute() {
		//println("Executing "+ip.addr_hex.value);
		Istruzione istruzione = new Istruzione(ir.versione, ir.codiceOperativo, ir.indirizzoIstruzione);

		istruzione.esegui();
	}
	
	private static void userInterface() {
		Graphics g = new Graphics();
		g.printHeading();
		file = g.printFileDropdown("src/assembledCode");
		
		println("");
	}
	
	
//	private static void execute() throws Exception {
//		Istruzioni istruzione = new Istruzioni(ir.versione, ir.codiceOperativo, ir.indirizzoIstruzione);
//
//		istruzione.esegui();
//
//		if(ir.versione == 0){
//			switch (ir.codiceOperativo) {
//				case '0' -> {
//					if (debug) {println("LOAD: \t" + addr_int);}
//					accumulatore = load(addr_int);
//					//accInt = hex2dec(load(addr_int));
//				}
//				case '1' -> {
//					if (debug) {
//
//						println("STORE: \t" + addr_int);
//					}
//					store(addr_int, accumulatore);
//					//store(addr_int, dec2hex(accInt));
//				}
//				case '2' -> {
//					if (debug) {
//
//						println("IN: \t" + addr_int);
//						print(" \t\t");
//					}
//					accumulatore = input("Inserisci un valore(HEX): ", "");
//					//accInt = hex2dec(input("Inserisci un valore(HEX): ", ""));
//				}
//				case '3' -> {
//					if (debug) {
//
//						println("OUT: \t" + addr_int);
//						print(" \t\t");
//					}
//					if(debug || verbose) {
//						printColor("0x"+ accumulatore+"\n", "green");
//					} else {
//						println("0x"+ accumulatore);
//					}
//					//println(addr_int + " -> 0x"+dec2hex(accInt));
//				}
//				case '4' -> {
//					if (debug) {
//
//						println("ADD: \t" + addr_int);
//					}
//					if(showTrace) print(accumulatore+"\t->\t");
//					accumulatore = add(accumulatore, addr_int);
//					if(showTrace) println(accumulatore);
//				}
//				case '5' -> {
//					if (debug) {
//						println("SUB: \t" + addr_int);
//					}
//					if(showTrace) print(accumulatore+"\t->\t");
//					accumulatore = sub(accumulatore, addr_int);
//					if(showTrace) println(accumulatore);
//				}
//				case '6' -> {
//					if (debug) {
//
//						println("MUL: \t" + addr_int);
//					}
//					if(showTrace) print(accumulatore+"\t->\t");
//					accumulatore = mul(accumulatore, addr_int);
//					if(showTrace) println(accumulatore);
//				}
//				case '7' -> {
//					if (debug) {
//
//						println("DIV: \t" + addr_int);
//					}
//					if(showTrace) print(accumulatore+"\t->\t");
//					accumulatore = div(accumulatore, addr_int);
//					if(showTrace) println(accumulatore);
//				}
//				case '8' -> {
//					if (debug) {
//
//						println("MOD: \t" + addr_int);
//					}
//					if(showTrace) print(accumulatore+"\t->\t");
//					accumulatore = mod(accumulatore, addr_int);
//					if(showTrace) println(accumulatore);
//				}
//				case '9' -> {
//					if (debug) {
//
//						println("AND: \t" + addr_int);
//					}
//					println("(AND) NOT WORKING");
//				}
//				case 'A' -> {
//					if (debug) {
//
//						println("OR: \t" + addr_int);
//					}
//					println("(OR) NOT WORKING");
//				}
//				case 'B' -> {
//					if (debug) {
//
//						println("XOR: \t" + addr_int);
//					}
//					println("(XOR) NOT WORKING");
//				}
//				case 'C' -> {
//					if (debug) {
//						println("JUMP: \t" + addr_int + "\tinc.");
//					}
//					exec(hex2dec(addr_int));
//					return;
//				}
//				case 'D' -> {
//					if (debug) {
//
//						print("jz \t\t" + addr_int+"\t(x=0)");
//					}
//					if (hex2dec(accumulatore) == 0) {
//						if(debug) println("\t true");
//						exec(hex2dec(addr_int));
//						return;
//					}
//					if(debug) println("\t false");
//				}
//				case 'E' -> {
//					if (debug) {
//						//jlz
//						print("jlz \t" + addr_int+"\t(x<0)");
//					}
//					if (hex2dec(accumulatore) < 0) {
//						if(debug) println("\t true");
//						exec(hex2dec(addr_int));
//						return;
//					}
//					if(debug) println("\t false");
//
//				}
//				case 'F' -> {
//					if (debug) {
//						//jgz
//						print("jgz \t" + addr_int+"\t(x>0)");
//					}
//					if (hex2dec(accumulatore) > 0) {
//						if(debug) println("\t true");
//						exec(hex2dec(addr_int));
//						return;
//					}
//					if(debug) println("\t false");
//				}
//			}
//		}
//
//		switch (inst) {
//			//VER 0
//
//
//			//VER 1
//			case "10" -> {
//				if (debug) {
//					println("LOAD IX: \t" + addr_int);
//				}
//				String newAddr = dec2hex(hex2dec(addr_int)+ix);
//				accumulatore = load(newAddr);
//			}
//			case "11" -> {
//				if (debug) {
//					println("STORE IX: \t" + addr_int);
//				}
//				String newAddr = dec2hex(hex2dec(addr_int)+ix);
//				store(newAddr, accumulatore);
//			}
//			case "12" -> {
//				if (debug) {
//					println("INIT IX: \t" + addr_int);
//				}
//				ix = hex2dec(addr_int);
//			}
//			case "13" -> {
//				if (debug) {
//					println("INIT IY: \t" + addr_int);
//				}
//				iy = hex2dec(addr_int);
//			}
//			case "14" -> {
//				if (debug) {
//					println("ADD IX: \t" + addr_int);
//				}
//				ix += hex2dec(addr_int);
//			}
//			case "15" -> {
//				if (debug) {
//					println("SUB IX: \t" + addr_int);
//				}
//				ix -= hex2dec(addr_int);
//			}
//			case "16" -> {
//				if (debug) {
//					println("LOAD IY: \t" + addr_int);
//				}
//				String newAddr = dec2hex(hex2dec(addr_int)+iy);
//				accumulatore = load(newAddr);
//			}
//			case "17" -> {
//				if (debug) {
//					println("STORE IY: \t" + addr_int);
//				}
//				String newAddr = dec2hex(hex2dec(addr_int)+iy);
//				store(newAddr, accumulatore);
//			}
//			case "18" -> {
//				if (debug) {
//					println("ADD IY: \t" + addr_int);
//				}
//				iy += hex2dec(addr_int);
//			}
//			case "19" -> {
//				if (debug) {
//					println("SUB IY: \t" + addr_int);
//				}
//				iy -= hex2dec(addr_int);
//			}
//			case "1A" -> {
//				if (debug) {
//					println("SKIP IX LT: \t" + addr_int);
//				}
//				if (ix < hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//			case "1B" -> {
//				if (debug) {
//					println("SKIP IX GT: \t" + addr_int);
//				}
//				if (ix > hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//			case "1C" -> {
//				if (debug) {
//					println("SKIP IX EQ: \t" + addr_int);
//				}
//				if (ix == hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//			case "1D" -> {
//				if (debug) {
//					println("SKIP IY LT: \t" + addr_int);
//				}
//				if (iy < hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//			case "1E" -> {
//				if (debug) {
//					println("SKIP IY GT: \t" + addr_int);
//				}
//				if (iy > hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//			case "1F" -> {
//				if (debug) {
//					println("SKIP IY EQ: \t" + addr_int);
//				}
//				if (iy == hex2dec(addr_int)) exec(instructionPointer+1);
//			}
//
//
//			//END
//			case "FF" -> {
//				foundEnd = true;
//			}
//		}
//	}
}