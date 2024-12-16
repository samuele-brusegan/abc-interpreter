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

    /**
     *
     * @param array the array to be searched
     * @param rand the int to be found
     * @return {@code true} if {@code rand} is found else it returns {@code false}
     */
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
    public static int[] arrayAppend(int[] arr1, int[] arr2){
        int[] arr = new int[arr1.length+arr2.length];
        for (int i = 0; i < arr.length; i++) {
            if(i < arr1.length){
                arr[i] = arr1[i];
            } else {
                arr[i] = arr2[i-arr1.length];
            }
        }
        return arr;
    }
    public static int[] arrayIntersect(int[] arr1, int[] arr2){
        int numeroElementiInComune = 0;
        for (int item : arr1){
            if(contains(arr2, item)) numeroElementiInComune++;
        }
        /*for (int item : arr2){
            if(contains(arr1, item)) numeroElementiInComune++;
        }*/
        int[] arr = new int[numeroElementiInComune];
        int i = 0;
        for (int item : arr1){
            if(contains(arr2, item)) {
                arr[i] = item;
                i++;
            }
        }
        /*for (int item : arr2){
            if(contains(arr1, item)) {
                arr[i] = item;
                i++;
            }
        }*/
        return arr;

    }
}
