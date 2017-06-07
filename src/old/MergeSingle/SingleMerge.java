package old.MergeSingle;

/**
 * Created by martin on 27/03/2017.
 */
public class SingleMerge{

    public void sort(float[] array, int low, int high) {
        if (high-low <= 1) {
            return;
        }
        int middle = low + ((high - low)/2);
        sort(array, low, middle);
        sort(array, middle, high);

        merge(middle,array,low,high);
    }

    /**
     * Merges the two sorted arrays this.low, middle - 1 and middle, this.high - 1
     * @param middle the index in the array where the second sorted list begins
     */
    private void merge(int middle,float[] array, int low, int high) {
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
}