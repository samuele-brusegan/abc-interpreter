import static utilities.Print.print;

public class Hex {
	String value;
	int length;
	
	Hex(String value){
		if(appartainToRadix(value,16)){
			this.value  = value;
			this.length = value.length();
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
	}
	
	int toDec(){
		return Integer.parseInt(value, 16);
	}
	Hex toHex(int value){
		return new Hex(Integer.toHexString(value));
	}
}
