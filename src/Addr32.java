import static utilities.Print.print;

public class Addr32 extends Address {

	public Addr32(Hex address) {
		super(address, 32);
	}
	public Addr32() {
		super(new Hex("000000"), 32);
	}
}
