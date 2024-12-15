import static instr.Istruzioni_bak.hex2dec;
import static utilities.Strings.appartainToRadix;

public class Addr32 {
	String addr_hex;
	int addr;
	
	//Se è un istruzione
	char versione;
	char codiceOperativo;
	Addr24 indirizzoIstruzione;
	
	Addr32(){}
	Addr32(String hexAddr){
		this.addr = hex2dec(hexAddr);
		this.addr_hex = hexAddr;
		
		versione            = addr_hex.charAt(0);
		codiceOperativo     = addr_hex.charAt(1);
		indirizzoIstruzione = new Addr24(addr_hex.substring(2));
		
		if(addr_hex.length()>6) throw new ArrayStoreException("Address too long");
		if(!appartainToRadix(hexAddr, 16)) throw new NumberFormatException("The given address is not a HEX number");
	}
	void init(String hexAddr){
		this.addr = hex2dec(hexAddr);
		this.addr_hex = hexAddr;
		
		if(addr_hex.length()>6) throw new ArrayStoreException("Address too long");
		if(!appartainToRadix(hexAddr, 16)) throw new NumberFormatException("The given address is not a HEX number");
	}
	
	void incrementa(int incremento){
		addr += incremento;
		addr_hex = Integer.toHexString(addr);
	}
	void decrementa(int decremento){
		addr -= decremento;
		addr_hex = Integer.toHexString(addr);
	}
}
