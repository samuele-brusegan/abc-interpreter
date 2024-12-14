package utilities;


import static java.lang.Math.random;
import static utilities.Math.rand;
import static utilities.Print.println;

public class Array {
    public static int[] randomArray(int length) {
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = rand(1, length);
        }
        return array;
    }
    public static int[] randomArrayExclusive(int length) {//TODO: Fix it please
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            int rand = rand(1, length);
            if(!contains(array, rand)){
                array[i] = rand;
            } else {
                i--;
            }
        }
        return array;
    }

    private static boolean contains(int[] array, int rand) {
        for(int item : array){
            if(item == rand){
                return true;
            }
        }
        return false;
    }
    public static int[] cavaElemento(int[] arrBak, int indexOfTheElementToRemove){
        int[] copyArr = new int[arrBak.length - 1];
        for (int k = 0; k < copyArr.length; k++) {
            if(k < indexOfTheElementToRemove){
                copyArr[k] = arrBak[k];
            }
            if(k >= indexOfTheElementToRemove){
                copyArr[k] = arrBak[k+1];
            }
        }
        return copyArr;
    }
}
