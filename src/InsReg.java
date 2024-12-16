public class InsReg extends Addr32 {

    //Se è un istruzione
    char versione;
    char codiceOperativo;
    Addr24 indirizzoIstruzione;

    private void refreshAttributes(){
        this.versione            = this.addr_hex.charAt(0);
        this.codiceOperativo     = this.addr_hex.charAt(1);
        this.indirizzoIstruzione = new Addr24(new Hex(addr_hex.substring(2)));
    }
	void initIR(Hex hexAddr){
		this.addr_int = hexAddr.toDec();
		this.addr_hex = hexAddr;
		
		if(addr_hex.length == length/4) refreshAttributes();
		
		if(addr_hex.length > length/4) throw new ArrayStoreException("Address too long");
	}
}
