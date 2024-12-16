public class Address {
    Hex addr_hex;
    int addr_int;
    int length;

    Address(){}
    Address(Hex address, int length){
        this.addr_int = address.toDec();
        this.addr_hex = address;
        this.length   = length;

        if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
    }


    void init(Hex hexAddr){
        this.addr_int = hexAddr.toDec();
        this.addr_hex = hexAddr;

        //if(addr_hex.length == length/4) refreshAttributes();

        if(addr_hex.length > length/4) throw new ArrayStoreException("Address too long");
    }

    void setAddr(Hex addr){
        this.addr_int = addr.toDec();
        this.addr_hex = addr;

        //if(addr_hex.length == length/4) refreshAttributes();

        if(addr_hex.length > length/4) throw new ArrayStoreException("Address too long");
    }
    void setAddr(String addr){
        Hex hexAddr = new Hex(addr);
        this.addr_int = hexAddr.toDec();
        this.addr_hex = hexAddr;

        //if(addr_hex.length == length/4) refreshAttributes();

        if(addr_hex.length > length/4) throw new ArrayStoreException("Address too long");
    }
    void setAddr(Addr24 address){
        this.addr_int = address.addr_int;
        this.addr_hex = address.addr_hex;
        if(addr_hex.length>6) throw new ArrayStoreException("Address too long");
    }

    void incrementa(int incremento){
        addr_int += incremento;
        addr_hex.setValue(Integer.toHexString(addr_int));
    }
    void decrementa(int decremento){
        addr_int -= decremento;
        addr_hex.setValue(Integer.toHexString(addr_int));
    }
    void incrementa(){
        this.incrementa(1);
    }
    void decrementa(){
        this.decrementa(1);
    }
}
