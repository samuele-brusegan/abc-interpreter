import utilities.General;

import java.util.Arrays;

import static utilities.Print.*;

public class EsecutoreV0 extends Esecutore {
	char codiceOperativo;
	Addr24 indirizzo;
	
	EsecutoreV0(char codiceOperativo, Istruzione i){
		this.codiceOperativo = codiceOperativo;
		this.indirizzo = i.indirizzo;
	}
	
	void esegui(){
		//Gestione accumulatore
		if(codiceOperativo == '0'){
			if(Main.debug) println("\t "+colorizer("LOAD", "purple-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.load(indirizzo);
		}
		if(codiceOperativo == '1'){
			if(Main.debug) println("\t "+colorizer("STORE", "purple-li")+" : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.store(indirizzo);
		}
		
		// Input / Output
		if(codiceOperativo == '2'){
			this.input(indirizzo);
		}
		if(codiceOperativo == '3'){
			this.output(indirizzo);
		}
		
		//Operazioni Aritmetiche
		if(codiceOperativo == '4'){
			if(Main.debug) println("\t "+colorizer("SOMMA", "purple-li")+" : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.add(indirizzo);
		}
		if(codiceOperativo == '5'){
			if(Main.debug) println("\t "+colorizer("SOTTRA", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.sub(indirizzo);
		}
		if(codiceOperativo == '6'){
			if(Main.debug) println("\t "+colorizer("MOLTIP", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.mul(indirizzo);
		}
		if(codiceOperativo == '7'){
			if(Main.debug) println("\t "+colorizer("DIVISI", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.div(indirizzo);
		}
		if(codiceOperativo == '8'){
			if(Main.debug) println("\t "+colorizer("MODULO", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			this.mod(indirizzo);
		}
		//Operazioni logiche
		
		/* TODO: Implementa le operazioni logiche */
		
		//Salti
		if(codiceOperativo == 'C'){
			
			//Prevent jump to same cell
			if(Main.ip.addr_int-1 != indirizzo.addr_int){
				if(Main.debug) printColor("\t Ho saltato all addr " + indirizzo.addr_hex.value+"\n", "blue-li");
				Main.ip.setAddr(indirizzo);
			}
			else {
				if(Main.debug) printColor("\t Ho raggiunto l'addr " + indirizzo.addr_hex.value+" [end]", "blue-li");
				Main.foundEnd = true;
			}
		}
		if(codiceOperativo == 'D'){     /* JZ  */
			if(Main.debug) printColor("\t Ho provato a saltare (JZ) all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value+"\n", "blue-li");
			if(Main.accumulatore.addr_int == 0){
				Main.ip.setAddr(indirizzo);
			}
		}
		if(codiceOperativo == 'E'){     /* JLZ */
			if(Main.debug) printColor("\t Ho provato a saltare (JLZ) all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value+"\n", "blue-li");
			if(Main.accumulatore.addr_int < 0){
				Main.ip.setAddr(indirizzo);
			}
		}
		if(codiceOperativo == 'F'){     /* JGZ */
			if(Main.debug) printColor("\t Ho provato a saltare (JGZ) all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value+"\n", "blue-li");
			if(Main.accumulatore.addr_int > 0){
				Main.ip.setAddr(indirizzo);
			}
		}
	}
	
	void load(Addr24 addr) {
        Main.accumulatore.setAddr(memory.read(addr));
    }
    void store(Addr24 addr) {
        memory.write(addr, Main.accumulatore.addr_hex);
    }
	
	
	void input(Addr24 port) {
		if (debug) {
			println("IN: \t" + port.addr_int);
			print("|    |          | ");
		}
		Main.accumulatore.setAddr(General.input("Inserisci un valore(HEX): ", ""));
	}
	void output(Addr24 port) {
		if (debug) {
			println("OUT: \t" + port.addr_int);
			print("|    |          | ");
		}
		if(!Main.encodeOutUTF32) {
			if (debug || verbose) {
				printColor("0x" + Main.accumulatore.addr_hex.value + "\n", "green");
			} else {
				println("0x" + Main.accumulatore.addr_hex.value);
			}
		} else {
			if (debug || verbose) {
				printColor(Arrays.toString(Character.toChars(Main.accumulatore.addr_int)) + "\n", "green");
			} else {
				print(Arrays.toString(Character.toChars(Main.accumulatore.addr_int)));
			}
		}
	}
	
    void add(Addr24 addr) {
	    int value = memory.read(addr).toDec();
	    int accVal = Main.accumulatore.addr_int;
	    Main.accumulatore.setAddr(new Hex().toHex(accVal + value));
    }
	void sub(Addr24 addr) {
        int accVal = Main.accumulatore.addr_int;
        int value = memory.read(addr).toDec();
        int subValue = accVal - value;
		Main.accumulatore.setAddr(new Hex().toHex(subValue));
    }
	void mul(Addr24 addr) {
        int value = memory.read(addr).toDec();
        int accVal = Main.accumulatore.addr_int;
		Main.accumulatore.setAddr(new Hex().toHex(accVal * value));
    }
	void div(Addr24 addr) {
		int value = memory.read(addr).toDec();
		int accVal = Main.accumulatore.addr_int;
		Main.accumulatore.setAddr(new Hex().toHex(accVal / value));
    }
	void mod(Addr24 addr) {
		int value = memory.read(addr).toDec();
		int accVal = Main.accumulatore.addr_int;
		Main.accumulatore.setAddr(new Hex().toHex(accVal % value));
    }
    /*public static void main(String[] args) {
	   new Esecutore().input(new Addr24("200"));
    }*/
}
