package old.MergeMulti;

import java.util.concurrent.RecursiveAction;

/**
 * Created by martin on 27/03/2017.
 */
public class MultiMerge extends RecursiveAction {
    private final float[] array;
    private final int low;
    private final int high;
    private int THRESHOLD = 10000;

    /**
     * Creates a {@code MergeSortTask} containing the array and the bounds of the array
     *
     * @param array the array to sort
     * @param low the lower element to start sorting at
     * @param high the non-inclusive high element to sort to
     */
    protected MultiMerge(float[] array, int low, int high, int threshold) {
        this.THRESHOLD = threshold;
        this.array = array;
        this.low = low;
        this.high = high;
    }

    @Override
    protected void compute() {
        if (high - low <= THRESHOLD) {
           // Arrays.sort(array,low,high);
            quickSort(array, low, high);
        } else {
            int middle = low + ((high - low)/2);
            // Execute the sub tasks and wait for them to finish
            invokeAll(new MultiMerge(array, low, middle,THRESHOLD), new MultiMerge(array, middle, high,THRESHOLD));
            // Then merge the results
            merge(middle);
        }
    }

    /**
     * Merges the two sorted arrays this.low, middle - 1 and middle, this.high - 1
     * @param middle the index in the array where the second sorted list begins
     */
    private void merge(int middle) {
        if (array[middle - 1] < array[middle]) {
            return; // the arrays are already correctly sorted, so we can skip the merge
        }
        float[] copy = new float[high - low];
        System.arraycopy(array, low, copy, 0, copy.length);
        int copyHigh = high - low, copyMiddle = middle - low;

        int i = low, j = 0, k = copyMiddle;
        while (i < high)
            array[i++] = (k >= copyHigh) || (j< copyMiddle && copy[j] < copy[k]) ? copy[j++] : copy[k++];
    }
    private void quickSort(float[] listToBeSorted, int lo, int hi){

        if ((hi-lo) <= 1)
            return;
        int i = lo;
        float pivot = listToBeSorted[hi-1];

        for(int j=lo; j<hi-1; j++){

            if (listToBeSorted[j] < pivot){
                float tmp = listToBeSorted[j];
                listToBeSorted[j] = listToBeSorted[i];
                listToBeSorted[i++] = tmp;
            }
        }

        listToBeSorted[hi-1] = listToBeSorted[i];
        listToBeSorted[i] = pivot;

        quickSort(listToBeSorted, lo, i);
        quickSort(listToBeSorted, i+1, hi);

    }
}