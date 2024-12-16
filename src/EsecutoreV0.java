import utilities.General;

import static utilities.Print.*;

public class EsecutoreV0 extends Esecutore {
	
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
		if(debug || verbose) {
			printColor("0x"+ Main.accumulatore.addr_hex.value+"\n", "green");
		} else {
			println("0x"+ Main.accumulatore.addr_hex.value);
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
