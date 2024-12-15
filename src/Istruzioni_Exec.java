public class Istruzioni_Exec {
	
	static Memoria memory       = Main.memory;
	static Addr32  accumulatore = Main.accumulatore;
	
	public static String load(Addr24 addr) {
        return memory.read(addr);
    }
    public static void store(Addr24 addr, Hex value) {
        memory.write(addr, value);
    }

    public static String add(String accHEX, String addr) {
        int targetAddress = hex2dec(addr);
        int value = hex2dec(memory[targetAddress]);
        int accVal = hex2dec(accHEX);
        return dec2hex(accVal + value);
    }
    public static String sub(String accHEX, String addr) {
        int targetAddress = hex2dec(addr);

        int accVal = hex2dec(accHEX);
        int value = hex2dec(memory[targetAddress]);

        //println(accVal + " - " + value);
        int subValue = accVal - value;
        //println(subValue);
        return dec2hex(subValue);
    }
    public static String mul(String accHEX, String addr) {
        int targetAddress = hex2dec(addr);
        int value = hex2dec(memory[targetAddress]);
        int accVal = hex2dec(accHEX);
        return dec2hex(accVal * value);
    }
    public static String div(String accHEX, String addr) {
        int targetAddress = hex2dec(addr);
        int value = hex2dec(memory[targetAddress]);
        int accVal = hex2dec(accHEX);
        return dec2hex(accVal / value);
    }
    public static String mod(String accHEX, String addr) {
        int targetAddress = hex2dec(addr);
        int value = hex2dec(memory[targetAddress]);
        int accVal = hex2dec(accHEX);
        return dec2hex(accVal % value);
    }
}
