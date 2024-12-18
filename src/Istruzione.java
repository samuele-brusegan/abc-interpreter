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
		if(versione == '0') new EsecutoreV0(codiceOperativo, this).esegui();
		if(versione == '1') new EsecutoreV1(codiceOperativo, this).esegui();
		if(versione == '2') new EsecutoreV2(codiceOperativo, this).esegui();
		if(versione == '3') this.esegui_V3();
		if(versione == '4') this.esegui_V4();
		if(versione == 'F' && codiceOperativo == 'F') Main.foundEnd = true;
	}
	
	void esegui_V1(){
		switch (codiceOperativo){
			case '0' -> {}
			case '1' -> {}
			case '2' -> {}
			case '3' -> {}
			case '4' -> {}
			case '5' -> {}
			case '6' -> {}
			case '7' -> {}
			case '8' -> {}
			case '9' -> {}
			case 'A' -> {}
			case 'B' -> {}
			case 'C' -> {}
			case 'D' -> {}
			case 'E' -> {}
			case 'F' -> {}
		}
	}
	void esegui_V2(){
		switch (codiceOperativo){
			case '0' -> {}
			case '1' -> {}
			case '2' -> {}
			case '3' -> {}
			case '4' -> {}
			case '5' -> {}
			case '6' -> {}
			case '7' -> {}
			case '8' -> {}
			case '9' -> {}
			case 'A' -> {}
			case 'B' -> {}
			case 'C' -> {}
			case 'D' -> {}
			case 'E' -> {}
			case 'F' -> {}
		}
	}
	void esegui_V3(){
		switch (codiceOperativo){
			case '0' -> {}
			case '1' -> {}
			case '2' -> {}
			case '3' -> {}
			case '4' -> {}
			case '5' -> {}
			case '6' -> {}
			case '7' -> {}
			case '8' -> {}
			case '9' -> {}
			case 'A' -> {}
			case 'B' -> {}
			case 'C' -> {}
			case 'D' -> {}
			case 'E' -> {}
			case 'F' -> {}
		}
	}
	void esegui_V4(){
		switch (codiceOperativo){
			case '0' -> {}
			case '1' -> {}
			case '2' -> {}
			case '3' -> {}
			case '4' -> {}
			case '5' -> {}
			case '6' -> {}
			case '7' -> {}
			case '8' -> {}
			case '9' -> {}
			case 'A' -> {}
			case 'B' -> {}
			case 'C' -> {}
			case 'D' -> {}
			case 'E' -> {}
			case 'F' -> {}
		}
	}
	/*
	* switch (codiceOperativo){
	*		case '0' -> {}
	*		case '1' -> {}
	*		case '2' -> {}
	*		case '3' -> {}
	*		case '4' -> {}
	*		case '5' -> {}
	*		case '6' -> {}
	*		case '7' -> {}
	*		case '8' -> {}
	*		case '9' -> {}
	*		case 'A' -> {}
	*		case 'B' -> {}
	*		case 'C' -> {}
	*		case 'D' -> {}
	*		case 'E' -> {}
	*		case 'F' -> {}
	*	}
	*/
	
	/*public static void main(String[] args) {
		
		Istruzione i = new Istruzione('0', '0', new Addr24("000000"));
		i.esegui();
	}*/
}
