import static utilities.Print.*;

public class EsecutoreV2 extends Esecutore {
	
	char codiceOperativo;
	Addr24 indirizzo;
	
	EsecutoreV2(char codiceOperativo, Istruzione i) {
		this.codiceOperativo = codiceOperativo;
		this.indirizzo = i.indirizzo;
	}
	void esegui(){
		switch (this.codiceOperativo){
			case '0' -> {
				if(Main.debug) println("\t "+colorizer("INITSP", "purple-li")+": (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+/*Main.memory.read(indirizzo).value*/0+", sp: "+Main.sp.addr_hex.value+")");
				this.initSp(indirizzo);
			}
			case '1' -> {
				if(Main.debug) println("\t "+colorizer("PUSH", "purple-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.push();
			}
			case '2' -> {
				if(Main.debug) println("\t "+colorizer("POP", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
					Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.pop();
			}
			case '3' -> {
				if(Main.debug) println("\t "+colorizer("CALL", "blue-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.call(indirizzo);
			}
			case '4' -> {
				if(Main.debug) println("\t "+colorizer("RET", "blue-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.ret();
			}
			case '5' -> {
				if(Main.debug) println("\t "+colorizer("CLEAR", "purple-li")+" : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+")");
				this.clear();
			}
			case '6' -> {
				if(Main.debug) println("\t "+colorizer("INC", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+")");
				this.incrementa();
			}
			case '7' -> {
				if(Main.debug) println("\t "+colorizer("DEC", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+")");
				this.decrementa();
			}
			case '8' -> {
				if(Main.debug) println("\t "+colorizer("INC", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
				this.incrementa(indirizzo);
			}
			case '9' -> {
				if(Main.debug) println("\t "+colorizer("DEC", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
				this.decrementa(indirizzo);
			}
			case 'A' -> {
				if(Main.debug) println("\t "+colorizer("PUSH", "purple-li")+"  : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.push(indirizzo);
			}
			case 'B' -> {
				if(Main.debug) println("\t "+colorizer("POP", "purple-li")+"   : (addr: "+indirizzo.addr_hex.value+", acc: "+
						Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+", sp: "+Main.sp.addr_hex.value+")");
				this.pop(indirizzo);
			}
			case 'C','D','E','F' -> {/* Non ancora definiti al momento della stesura */}
		}
	}
	
	void initSp(Addr24 addr) {
		Bin addrBin = new Bin(addr.addr_hex.toBin());
		Hex addrHexCa1 = new Hex(Integer.toString(Integer.parseInt(addrBin.ca1().value, 2),16));
		Main.sp.setAddr(addrHexCa1);
	}
	void push(){
		Main.stack.push(Main.accumulatore.addr_hex);
		Main.sp.incrementa();
	}
	void pop(){
		Main.sp.decrementa();
		Main.accumulatore.setAddr(Main.stack.read(Main.sp));
	}
	void push(Addr24 addr){
		Main.stack.push(Main.memory.read(addr));
		Main.sp.incrementa();
	}
	void pop(Addr24 addr){
		Main.sp.decrementa();
		Main.memory.write(addr, Main.stack.read(Main.sp));
	}
	void clear(){
		Main.accumulatore.setAddr("0");
	}
	void incrementa(){
		Main.accumulatore.setAddr(new Hex().toHex(Main.accumulatore.addr_int + 1));
	}
	void decrementa(){
		Main.accumulatore.setAddr(new Hex().toHex(Main.accumulatore.addr_int - 1));
	}
	void incrementa(Addr24 addr){
		int val = Main.memory.read(addr).toDec();
		Main.memory.write(addr, new Hex().toHex(val + 1));
	}
	void decrementa(Addr24 addr){
		int val = Main.memory.read(addr).toDec();
		Main.memory.write(addr, new Hex().toHex(val - 1));
	}
	void call(Addr24 addr){
		Main.stack.push(Main.ip.addr_hex);
		Main.sp.incrementa();
		Main.ip.setAddr(addr);
	}
	void ret(){
		Main.sp.decrementa();
		Main.ip.setAddr(Main.stack.read(Main.sp));
	}
}
