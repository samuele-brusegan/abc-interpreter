import static utilities.Strings.appartainToRadix;

public class Addr24 extends Address {

	public Addr24(Hex address) {
		super(address, 24);
	}
	public Addr24(String strAddr) {
		super(new Hex(strAddr), 24);
	}
	public Addr24() {
		super(new Hex("000000"), 24);
	}
	/*Hex addr_hex;
	int addr_int;
	
	Addr24(){}
	Addr24(Hex addr){
		this.addr_int = addr.toDec();
		this.addr_hex = addr;
		
		if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
	}
	Addr24(String strAddr){
		Hex addr = new Hex(strAddr);
		this.addr_int = addr.toDec();
		this.addr_hex = addr;
		
		if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
		if(!appartainToRadix(addr.value, 16)) throw new NumberFormatException("The given address is not a HEX number");
	
	}
	void setAddr(Addr24 address){
		this.addr_int = address.addr_int;
		this.addr_hex = address.addr_hex;
		if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
	}
	
	void setAddr(Hex addr){
		this.addr_int = addr.toDec();
		this.addr_hex = addr;
		
		if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
	}
	
	void incrementa(){
		this.incrementa(1);
	}
	void incrementa(int incremento){
		addr_int += incremento;
		addr_hex.setValue(Integer.toHexString(addr_int));
	}
	void decrementa(int decremento){
		addr_int -= decremento;
		addr_hex.setValue(Integer.toHexString(addr_int));
	}*/
}
