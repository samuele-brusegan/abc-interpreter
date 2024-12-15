import static utilities.Print.print;
import static utilities.Strings.appartainToRadix;

public class Addr32 {
	Hex addr_hex;
	int addr_int;
	
	//Se è un istruzione
	char versione;
	char codiceOperativo;
	Addr24 indirizzoIstruzione;
	
	Addr32(){}
	Addr32(Hex address){
		this.addr_int = address.toDec();
		this.addr_hex = address;
		
		refreshAttributes();
		
		if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
	}
	private void refreshAttributes(){
		this.versione            = this.addr_hex.charAt(0);
		this.codiceOperativo     = this.addr_hex.charAt(1);
		this.indirizzoIstruzione = new Addr24(new Hex(addr_hex.substring(2)));
	}
	
	void init(Hex hexAddr){
		this.addr_int = hexAddr.toDec();
		this.addr_hex = hexAddr;
		
		if(addr_hex.length == 8) refreshAttributes();
		
		if(addr_hex.length>8) throw new ArrayStoreException("Address too long");
	}
	
	void setAddr(Hex addr){
		this.addr_int = addr.toDec();
		this.addr_hex = addr;
		
		if(addr_hex.length == 8) refreshAttributes();
		
		if(addr_hex.length>8) throw new ArrayStoreException("Address too long");
	}
	void setAddr(String addr){
		Hex hexAddr = new Hex(addr);
		this.addr_int = hexAddr.toDec();
		this.addr_hex = hexAddr;
		
		if(addr_hex.length == 8) refreshAttributes();
		
		if(addr_hex.length>8) throw new ArrayStoreException("Address too long");
	}
	
	void incrementa(int incremento){
		addr_int += incremento;
		addr_hex.setValue(Integer.toHexString(addr_int));
	}
	void decrementa(int decremento){
		addr_int -= decremento;
		addr_hex.setValue(Integer.toHexString(addr_int));
	}
}
