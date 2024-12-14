package utilities;
import static utilities.Print.printArray;

public class Sort {
    /**
     * Sorts the array with the BubbleSort algorithm
     * @param array the array to be sorted
     */
    public static void bubbleSort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {
                //printArray(array);
                if(array[j] < array[j-1]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the array with the BubbleSort algorithm
     * @param array the array to be sorted
     */
    public static void insertionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length-i; j++) {

                while (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * Tells if the given array is ordered from the lowest
     * @param array an array of integers
     * @return {@code true} if the array is ordered<br/>
     * else returns {@code false}
     */
    public static boolean isArrOrdered(int[] array){
        boolean isOrdered = true;
        for (int i = 1; i < array.length && isOrdered; i++) {
            isOrdered = (array[i] >= array[i-1]);
        }
        return isOrdered;
    }
}
