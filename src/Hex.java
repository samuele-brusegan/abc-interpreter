import static java.lang.Math.pow;
import static utilities.Print.print;
import static utilities.Print.println;
import static utilities.Strings.reverse;

@SuppressWarnings("StringConcatenationInLoop")
public class Hex {
	String value;
	String value8c;
	Bin binValue;
	int length;
	
	Hex(String value){
		if(appartainToRadix(value,16)){
			this.value  = value;
			this.length = value.length();
			updateValue8c();
			this.binValue = new Bin(this.toBin());
		} else {
			throw new NumberFormatException("String "+value+" is not a hexadecimal number");
		}
	}
	Hex(){}
	
	public static boolean appartainToRadix(String str, int radix){
		str = str.toUpperCase();
		char[] charsAllowed = new char[radix];
		
		for (int i = 0; i < radix; i++) {
			if(i+'0' <= '9') charsAllowed[i] = (char) (i+'0');
			else charsAllowed[i] = (char) (i-10+'A');
		}
		//printArray(charsAllowed);
		for(int i = 0; i < str.length(); i++){
			boolean theres = false;
			for(char c : charsAllowed){
				if (str.charAt(i) == c) {
					theres = true;
					break;
				}
			}
			if(!theres) return false;
		}
		return true;
	}
	char charAt(int index){
		return value.charAt(index);
	}
	String substring(int start, int end){
		return value.substring(start, end);
	}
	String substring(int start){
		return substring(start,length);
	}
	void setValue(String value){
		this.value = value;
		this.length = value.length();
		updateValue8c();
	}

	private void updateValue8c(){
		value8c = "";
		for (int i = 0; i < 8; i++) {
			if(i < value.length()){
				value8c = value.charAt(i) + value8c;
			} else if (i == value.length()) {
				value8c = reverse(value8c);
				value8c = '0' + value8c;
			} else {
				value8c = '0' + value8c;
			}
		}
		if(value.length() == 8) value8c = reverse(value8c);
	}
	
	int toDec(){
		int dec = 0;
		String revValue = reverse(value8c);

		for(int i = 0; i < 8; i++){
			int hexCharToDec  = Integer.parseInt(revValue.charAt(i)+"",16);
			dec += (int) (hexCharToDec * (Math.pow(16,i)));
		}

		return dec;
		//return Integer.parseInt(value,16);


		// FF FF FF FF
		//4294967296/2
		//2147483648
	}

	String toBin(){
		//value;
		String bin = "";
		for (int i = 0; i < value.length(); i++) {
			switch (value.charAt(i)) {
				case '0' -> bin += "0000";
				case '1' -> bin += "0001";
				case '2' -> bin += "0010";
				case '3' -> bin += "0011";
				case '4' -> bin += "0100";
				case '5' -> bin += "0101";
				case '6' -> bin += "0110";
				case '7' -> bin += "0111";
				case '8' -> bin += "1000";
				case '9' -> bin += "1001";
				case 'A' -> bin += "1010";
				case 'B' -> bin += "1011";
				case 'C' -> bin += "1100";
				case 'D' -> bin += "1101";
				case 'E' -> bin += "1110";
				case 'F' -> bin += "1111";
			}
		}
		return bin;
	}
	Hex toHex(int value){
		return new Hex(Integer.toHexString(value));
	}

	public static void main(String[] args) {
		Hex h = new Hex("000006");
		println(h.toDec());
	}
}
