import static instr.Istruzioni_bak.hex2dec;
import static utilities.Strings.appartainToRadix;

public class Addr24 {
	String addr_hex;
	int addr_int;
	
	Addr24(){}
	Addr24(String hexAddr){
		this.addr_int = hex2dec(hexAddr);
		this.addr_hex = hexAddr;
		
		if(addr_hex.length()>6) throw new ArrayStoreException("Address too long");
		if(!appartainToRadix(hexAddr, 16)) throw new NumberFormatException("The given address is not a HEX number");
	}
	void init(String hexAddr){
		this.addr_int = hex2dec(hexAddr);
		this.addr_hex = hexAddr;
		
		if(addr_hex.length()>6) throw new ArrayStoreException("Address too long");
		if(!appartainToRadix(hexAddr, 16)) throw new NumberFormatException("The given address is not a HEX number");
	}
	
	void incrementa(int incremento){
		addr_int += incremento;
		addr_hex = Integer.toHexString(addr_int);
	}
	void decrementa(int decremento){
		addr_int -= decremento;
		addr_hex = Integer.toHexString(addr_int);
	}
}
