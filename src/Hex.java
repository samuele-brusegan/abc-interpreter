public class Hex {
	String hex;
	
	Hex(String value){
		if(appartainToRadix(value,16)){
			this.hex = value;
		} else {
			throw new NumberFormatException();
		}
	}
	
	
	
	public static boolean appartainToRadix(String str, int radix){
		str = str.toUpperCase();
		char[] charsAllowed = new char[radix];
		
		for (int i = 0; i < radix; i++) {
			if(i+'0' <= '9') charsAllowed[i] = (char) (i+'0');
			else charsAllowed[i] = (char) (i-10+'a');
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
}
