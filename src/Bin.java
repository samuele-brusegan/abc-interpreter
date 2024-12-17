import static utilities.Print.print;
import static utilities.Print.println;
import static utilities.Strings.reverse;

public class Bin {
	//Max Len 32 bit
	String value;
	String value32b;
	
	
	public Bin(String value) {
		//Comprimi
		this.value = value;
		//TODO: Aggiungi il valore trimmato a value
		//TODO: Aggiungi il valore a 32b a value32b
		
		if(value.length()>32){
			throw new NumberFormatException("Bin value "+ value +" is too long ("+value.length()+"b instead of 32b)");
		}
	}
	
	Bin ca1(){
		String ca1 = "";
		String bin = value;
		for(int i = 0; i < value.length(); i++){
			ca1 += (bin.charAt(i)=='0')? '1' : '0';
		}
		return new Bin(ca1);
	}
	
	/*Bin ca2(){
		String ca2 = "";
		String bin = value;
		for(int i = 0; i < value.length(); i++){
		
		}
	}*/
	
	Bin add(Bin b2){
		int riporto = 0;
		String n1 = reverse(this.value);
		String n2 = reverse(b2.value);
		int shortestLen = Math.max(n1.length(), n2.length());
		String sum = "";
		for (int i = 0; !(riporto == 0 && i > shortestLen); i++) {
			int c1 = 0;
			if (i < n1.length()){
				c1 = n1.charAt(i)-'0';
			}
			int c2 = 0;
			if (i < n2.length()){
				c2 = n2.charAt(i)-'0';
			}
			
			if(c1 + c2 + riporto < 2) {
				sum += (char) (c1 + c2 + riporto + '0');
				riporto = 0;
			}
			else {
				sum += (char) ((c1 + c2 + riporto)%2+'0');
				riporto = 1;
			}
			//println(sum);
			
		}
		return new Bin(reverse(sum));
	}
	
	@Override
	public String toString(){
		return value;
	}
	
	public static void main(String[] args) {
		Bin b1 = new Bin("1");
		System.out.println(b1.add(new Bin("100")));
	}
}
