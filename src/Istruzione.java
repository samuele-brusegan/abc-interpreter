
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
	}
	
	void esegui_V0(){
		//Gestione accumulatore
		if(codiceOperativo == '0'){
			Istruzioni_Exec.load(indirizzo) ;}
		if(codiceOperativo == '1'){
			Istruzioni_Exec.store(indirizzo);}
		
		// Input / Output
		if(codiceOperativo == '2'){
			Istruzioni_Exec.input(indirizzo) ;}
		if(codiceOperativo == '3'){
			Istruzioni_Exec.output(indirizzo);}
		
		//Operazioni Aritmetiche
		if(codiceOperativo == '4'){
			Istruzioni_Exec.add(indirizzo);}
		if(codiceOperativo == '5'){
			Istruzioni_Exec.sub(indirizzo);}
		if(codiceOperativo == '6'){
			Istruzioni_Exec.mul(indirizzo);}
		if(codiceOperativo == '7'){
			Istruzioni_Exec.div(indirizzo);}
		if(codiceOperativo == '8'){
			Istruzioni_Exec.mod(indirizzo);}
		//Operazioni logiche
		
			/* TODO: Implementa le operazioni logiche */
		
		//Salti
		if(codiceOperativo == 'C'){}
		if(codiceOperativo == 'D'){}
		if(codiceOperativo == 'E'){}
		if(codiceOperativo == 'F'){}
	}
	void esegui_V1(){
	
	}
	void esegui_V2(){
	
	}
	void esegui_V3(){
	
	}
	void esegui_V4(){
	
	}
	
	public static void main(String[] args) {
		
		Istruzione i = new Istruzione('0', '0', new Addr24("000000"));
		i.esegui();
	}
}
