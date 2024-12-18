import static utilities.Print.*;

public class EsecutoreV1 extends Esecutore {
	
	char codiceOperativo;
	Addr24 indirizzo;
	
	EsecutoreV1(char codiceOperativo, Istruzione i) {
		this.codiceOperativo = codiceOperativo;
		this.indirizzo = i.indirizzo;
	}
	void esegui(){
		switch (this.codiceOperativo){
			case '0' -> {
				if(Main.debug) println("\t "+colorizer("LOAD", "purple-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.loadIX(indirizzo);
			}
			case '1' -> {
				if(Main.debug) println("\t "+colorizer("STORE", "purple-li")+" : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.storeIX(indirizzo);
			}
			case '2' -> {
				if(Main.debug) println("\t "+colorizer("INITIX", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.initIX(indirizzo);
			}
			case '3' -> {
				if(Main.debug) println("\t "+colorizer("INITIY", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.initIY(indirizzo);
			}
			case '4' -> {
				if(Main.debug) println("\t "+colorizer("ADDTIX", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.addIX(indirizzo);
			}
			case '5' -> {
				if(Main.debug) println("\t "+colorizer("SUBTIX", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.subIX(indirizzo);
			}
			case '6' -> {
				if(Main.debug) println("\t "+colorizer("LOAD", "purple-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.loadIY(indirizzo);
			}
			case '7' -> {
				if(Main.debug) println("\t "+colorizer("STORE", "purple-li")+" : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.storeIY(indirizzo);
			}
			case '8' -> {
				if(Main.debug) println("\t "+colorizer("ADDIY", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.addIY(indirizzo);
			}
			case '9' -> {
				if(Main.debug) println("\t "+colorizer("SUBIY", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.subIY(indirizzo);
			}
			case 'A' -> {
				if(Main.debug) println("\t "+colorizer("SKIxLt", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.skipIX(indirizzo, 0);
			}
			case 'B' -> {
				if(Main.debug) println("\t "+colorizer("SKIxGt", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.skipIX(indirizzo, 1);
			}
			case 'C' -> {
				if(Main.debug) println("\t "+colorizer("SKIxEq", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", ix: "+Main.ix.addr_int+")");
				this.skipIX(indirizzo, 2);
			}
			case 'D' -> {
				if(Main.debug) println("\t "+colorizer("SKIyLt", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.skipIY(indirizzo, 0);
			}
			case 'E' -> {
				if(Main.debug) println("\t "+colorizer("SKIyGt", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.skipIY(indirizzo, 1);
			}
			case 'F' -> {
				if(Main.debug) println("\t "+colorizer("SKIyEq", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", iy: "+Main.iy.addr_int+")");
				this.skipIY(indirizzo, 2);
			}
		}
	}
	
	
	void loadIX (Addr24 addr) {
		Addr24 addr2 = new Addr24(new Hex().toHex(addr.addr_int+Main.ix.addr_int));//IX+addr
		Main.accumulatore.setAddr(memory.read(addr2));
	}
	void storeIX(Addr24 addr) {
		Addr24 addr2 = new Addr24(new Hex().toHex(addr.addr_int+Main.ix.addr_int));//IX+addr
		memory.write(addr2, Main.accumulatore.addr_hex);
	}
	void initIX (Addr24 addr) {
		Main.ix.setAddr(addr);
	}
	void initIY (Addr24 addr) {
		Main.iy.setAddr(addr);
	}
	void addIX  (Addr24 addr) {
		Main.ix.incrementa(addr.addr_int);
	}
	void subIX  (Addr24 addr) {
		Main.ix.decrementa(addr.addr_int);
	}
	void loadIY (Addr24 addr) {
		Addr24 addr2 = new Addr24(new Hex().toHex(addr.addr_int+Main.iy.addr_int));//IY+addr
		Main.accumulatore.setAddr(memory.read(addr2));
	}
	void storeIY(Addr24 addr) {
		Addr24 addr2 = new Addr24(new Hex().toHex(addr.addr_int+Main.iy.addr_int));//IY+addr
		memory.write(addr2, Main.accumulatore.addr_hex);
	}
	void addIY  (Addr24 addr) {
		Main.iy.incrementa(addr.addr_int);
	}
	void subIY  (Addr24 addr) {
		Main.iy.decrementa(addr.addr_int);
	}
	//Skip
	void skipIX(Addr24 addr, int condizione){
		switch (condizione){
			case 0 -> {
				if(Main.ix.addr_int < addr.addr_int){
					Main.ip.incrementa();
				}
			}
			case 1 -> {
				if(Main.ix.addr_int > addr.addr_int){
					Main.ip.incrementa();
				}
			}
			case 2 -> {
				if(Main.ix.addr_int == addr.addr_int){
					Main.ip.incrementa();
				}
			}
		}
	}
	void skipIY(Addr24 addr, int condizione){
		switch (condizione){
			case 0 -> {
				if(Main.iy.addr_int < addr.addr_int){
					Main.ip.incrementa();
				}
			}
			case 1 -> {
				if(Main.iy.addr_int > addr.addr_int){
					Main.ip.incrementa();
				}
			}
			case 2 -> {
				if(Main.iy.addr_int == addr.addr_int){
					Main.ip.incrementa();
				}
			}
		}
	}
	
}
