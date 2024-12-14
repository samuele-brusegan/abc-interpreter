package utilities;

@SuppressWarnings("StringConcatenationInLoop")
public class Morse {
    /**
     * Translates the Morse to text <br/> {@code MORSE -> TEXT}
     * @param mTxt the text you want to translate
     * @return the text translated
     */
    public static String decode(String mTxt) {
        //Init
        String out = "";
        String[] ciph1 = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] ciph2 = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        //Cycle through the whole PHRASE
        for (int i = 0; i < mTxt.length(); /* Sposta l' incremento e aggiusta le condizioni  */) {
            String let = "";
            //Cycle through the LETTER
            while (mTxt.charAt(i) != '/') {
                let += mTxt.charAt(i);
                i++;
                if (i >= mTxt.length()) {
                    break;
                }
            }
            //println("LET: "+let);
            i++;
            //Conversion from MORSE to LETTERS
            boolean found = false;
            for(int j = 0; j < ciph2.length; j++) {
                if (let.equals(ciph2[j])) {
                    out += ciph1[j];
                    found = true;
                    break;
                }
            }

            //Check if the WORD is ended
            if (i < mTxt.length() && mTxt.charAt(i) == '/') {
                out += " ";
            }

            if (!found) {
                // Handle Morse code not found
                // CHAR not found / Morse WRONG
                out += "#";
            }
        }
        return out;
    }

    /**
     * Translates the text to Morse <br/> {@code TEXT -> MORSE}
     * @param txt the text to be translated
     * @return the text translated
     */
    public static String encode(String txt) {

        //Init

        String out = "";
        char[] ciph1 = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] ciph2 = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        String[] ciph3 = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        //Direct Translation
        for (int i = 0; i < txt.length(); i++) {
            for(int j = 0; j < ciph3.length; j++) {
                if (txt.charAt(i) == ciph1[j] || txt.charAt(i) == ciph2[j]) {
                    out += ciph3[j];
                    out += "/";
                    //println(ciph1[j]);
                }

                if (txt.charAt(i) == ' ') {
                    out += "/";
                    break;
                }
            }

        }
        out += "/";
        return out;
    }
}
