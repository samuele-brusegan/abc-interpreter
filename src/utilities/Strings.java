package utilities;

import java.util.Arrays;

import static utilities.Print.*;

//@SuppressWarnings("ALL")
@SuppressWarnings({"StringConcatenationInLoop", "unused"})


public class Strings {
    /**
     * Returns the {@code String} with the words inverted individually
     * <p>[Example: The cat => ehT tac]</p>
     *
     * @param str The string you want to invert words
     * @return the argument with each word inverted
     */
    public static String invertPhrase(String str) {

        String phrase = "";
        //Build phrase
        for(int i = 0; i < str.length(); i++) {

            String word = "";
            //Build word
            while ( i < str.length() && str.charAt(i) != ' ' ) { //Fino a che non trovo uno spazio (la parola non è finita)

                word += str.charAt(i);
                i++;
            }

            phrase += invertWord(word);
            phrase += " ";
        }

        return phrase;
    }

    /**
     *
     * @param str A string to be inverted
     * @return The {@code String} inverted
     */
    public static String invertWord(String str) {
        String tmp = "";
        for(int i = str.length(); i > 0; i--){
            tmp += str.charAt(i-1);
        }
        return tmp;
    }

    /**
     * Removes spaces and convert the {@code String} to lower case
     *
     * @param str a string to be normalized
     * @return The argument normalized
     */
    public static String normalize(String str) {
        String tmp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                tmp += str.charAt(i);
            }
        }
        return tmp.toLowerCase();
    }
    /**
     * Removes spaces from the {@code String}
     *
     * @param str a string to be normalized
     * @return The argument normalized
     */
    public static String remSpace(String str) {
        String tmp = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                tmp += str.charAt(i);
            }
        }
        return tmp;
    }

    /**
     * Removes double spaces
     * @param str a string to be compacted
     * @return the argument compacted
     */
    public static String compact(String str) {
        //Fa diventare gli spazi multipli spazi singoli
        String tmp = "";
        boolean isLastCharSpace = false;

        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) != ' '){
                tmp += str.charAt(i);
                isLastCharSpace = false;
            }
            else if (str.charAt(i) == ' ' && !isLastCharSpace) {
                tmp += str.charAt(i);
                isLastCharSpace = true;
            }
        }
        return tmp;
    }

    /**
     * Returns the index-th word of the string in input
     *
     * <p>
     * Notice:
     * <ul>
     *     <li>The first word has index 0</li>
     *     <li>The outputted word hasn't any space</li>
     * </ul>
     * </p>
     *
     *
     * @param str_input     a {@code String}
     * @param wordNumber    an {@code int} number, the "word index"
     * @return the {@code wordNumber}-th word of the argument
     */
    public static String segmentatePhrase(String str_input, int wordNumber) {
        String str = compact(str_input);
        int currWordNumber = 0;
        //Build phrase
        for(int i = 0; i < str.length(); i++) {

            String word = "";
            //Build word
            while ( i < str.length() && str.charAt(i) != ' ' ) { //Fino a che non trovo uno spazio (la parola non è finita)

                word += str.charAt(i);
                i++;
            }
            if(currWordNumber == wordNumber){
                return word;
            }
            currWordNumber++;
        }
        return "";
    }


/*--------------------------------------------------------------------------------------------------*/

    /**
     * Returns the number of spaces in a {@code String}
     * @param str a {@code String}
     * @return the number of spaces
     */
    public static int countSpaces(String str) {

        int counter = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                counter++;
            }
        }
        return counter;
    }
	/**
	 * Returns the number of spaces in a {@code String}
	 * @param str a {@code String}
	 * @return the number of spaces
	 */
	public static int countChar(String str, char c) {
		
		int counter = 0;
		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == c){
				counter++;
			}
		}
		return counter;
	}

    /**
     * Returns the number of words (substrings ending with space) starting with a Capital letter
     * @param str a {@code String}
     * @return the number of words starting with a Capital letter
     */
    public static int contaNomiPropri(String str) {
        int counter = 0;
        for(int i = 0; i < numberOfWords(str); i++){

            String word = segmentatePhrase(str, i);
            String firstCharWord = word.substring(0, 1);
            String norm_firstCharWord = firstCharWord.toLowerCase();

            if(!firstCharWord.equals(norm_firstCharWord)) counter++;
        }
        return counter;
    }

    /**
     * Returns the number of words (substrings ending with space)
     * @param str a {@code String}
     * @return the number of words in a main String
     */
    public static int numberOfWords(String str) {
        String str_compact = compact(str);
        int wordCounter = 0;
        //Build phrase
        for(int i = 0; i < str_compact.length(); i++) {

            String word = "";
            //Build word
            while ( i < str_compact.length() && str_compact.charAt(i) != ' ' ) { //Fino a che non trovo uno spazio (la parola non è finita)

                word += str_compact.charAt(i);
                i++;
            }
            wordCounter++;
        }
        return wordCounter;
    }


    public static String invertCase(String str){
        String invertedCaseString = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String currentCharStr = str.charAt(i)+"";

            if(currentChar >= 'a' && currentChar <= 'z'){ //Lower Case
                invertedCaseString += currentCharStr.toUpperCase();
            }
            else if(currentChar >= 'A' && currentChar <= 'Z') { //UPPER Case
                invertedCaseString += currentCharStr.toLowerCase();
            } else {
                invertedCaseString += currentCharStr;
            }
        }
        return invertedCaseString;
    }
    public static String capitalizedCase(String str){
        String output = "";
        for (int i = 0; i < numberOfWords(str); i++) {
            String word = segmentatePhrase(str, i);

            for (int j = 0; j < word.length(); j++) {
                char currentChar = word.charAt(j);
                String currentCharStr = word.charAt(j)+"";
                if(j == 0){
                    if(currentChar >= 'a' && currentChar <= 'z') { //Lower Case
                        output += currentCharStr.toUpperCase();
                    } else {
                        output += currentCharStr;
                    }
                } else {
                    output += currentCharStr;
                }
            }
            output += " ";

        }
        return output;
    }
    public static String alternatingCase(String str){
        String output = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            String currentCharStr = str.charAt(i)+"";

            if(i % 2 == 0){ //Lower Case
                output += currentCharStr.toUpperCase();
            }
            else {
                output += currentCharStr.toLowerCase();
            }
        }
        return output;
    }
    public static String removeComma(String arg){
        String tmp = "";
        char charToBeRemoved = ',';
        boolean streak = true;
        for(int i = arg.length()-1; i >= 0; i--){
            if (arg.charAt(i) != charToBeRemoved || !streak) {
                tmp += arg.charAt(i);
                streak = false;
            }
        }
        return invertWord(tmp);
    }
    public static String reverse(String str) {
        //Alias di Invert Word
        return invertWord(str);
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
