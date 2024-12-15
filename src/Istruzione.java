import static utilities.Print.println;

public class Istruzione {
	
	char versione;
	char codiceOperativo;
	Addr24 indirizzo;
	
	Istruzione(char versione, char codiceOperativo, Addr24 indirizzo){
		this.versione = versione;
		this.codiceOperativo = codiceOperativo;
		this.indirizzo = indirizzo;
		
	}
	
	void esegui(){
		if(versione == '0') this.esegui_V0();
		if(versione == '1') this.esegui_V1();
		if(versione == '2') this.esegui_V2();
		if(versione == '3') this.esegui_V3();
		if(versione == '4') this.esegui_V4();
		if(versione == '5' && codiceOperativo == '0') Main.foundEnd = true;
	}
	
	void esegui_V0(){
		Esecutore istruzione = new Esecutore();
		//Gestione accumulatore
		if(codiceOperativo == '0'){
			if(Main.debug) println("\t  LOAD : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.load(indirizzo);
		}
		if(codiceOperativo == '1'){
			if(Main.debug) println("\t STORE : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.store(indirizzo);
		}
		
		// Input / Output
		if(codiceOperativo == '2'){
			istruzione.input(indirizzo);
		}
		if(codiceOperativo == '3'){
			istruzione.output(indirizzo);
		}
		
		//Operazioni Aritmetiche
		if(codiceOperativo == '4'){
			if(Main.debug) println("\t SOMMA : (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.add(indirizzo);
		}
		if(codiceOperativo == '5'){
			if(Main.debug) println("\t SOTTRA: (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.sub(indirizzo);
		}
		if(codiceOperativo == '6'){
			if(Main.debug) println("\t MOLTIP: (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.mul(indirizzo);
		}
		if(codiceOperativo == '7'){
			if(Main.debug) println("\t DIVISI: (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.div(indirizzo);
		}
		if(codiceOperativo == '8'){
			if(Main.debug) println("\t MODULO: (addr: "+indirizzo.addr_hex.value+", acc: "+Main.accumulatore.addr_hex.value+", memRead: "+Main.memory.read(indirizzo).value+")");
			istruzione.mod(indirizzo);
		}
		//Operazioni logiche
		
			/* TODO: Implementa le operazioni logiche */
		
		//Salti
		if(codiceOperativo == 'C'){
			if(Main.debug) println("\tHo provato a saltare all addr " + indirizzo.addr_hex.value);
			Main.ip.setAddr(indirizzo);
		}
		if(codiceOperativo == 'D'){     /* JZ  */
			if(Main.debug) println("\tHo provato a saltare all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value);
			if(Main.accumulatore.addr_int == 0){
				Main.ip.setAddr(indirizzo);
			}
		}
		if(codiceOperativo == 'E'){     /* JLZ */
			if(Main.debug) println("\tHo provato a saltare all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value);
			if(Main.accumulatore.addr_int < 0){
				Main.ip.setAddr(indirizzo);
			}
		}
		if(codiceOperativo == 'F'){     /* JGZ */
			if(Main.debug) println("\tHo provato a saltare all addr " + indirizzo.addr_hex.value+ " con acc.: "+Main.accumulatore.addr_hex.value);
			if(Main.accumulatore.addr_int > 0){
				Main.ip.setAddr(indirizzo);
			}
		}
	}
	void esegui_V1(){
	
	}
	void esegui_V2(){
	
	}
	void esegui_V3(){
	
	}
	void esegui_V4(){
	
	}
	
	/*public static void main(String[] args) {
		
		Istruzione i = new Istruzione('0', '0', new Addr24("000000"));
		i.esegui();
	}*/
}
