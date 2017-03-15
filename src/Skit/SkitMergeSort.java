package Skit;

/**
 * Created by martin on 15/03/2017.
 */
public class SkitMergeSort {
    private float[] arrayToBeSorted;
    private float[] mergeArray;

    public void sort(float[] values) {
        this.arrayToBeSorted = values;
        this.mergeArray = new float[arrayToBeSorted.length];
        mergeSort(0, arrayToBeSorted.length - 1);
    }

    private void mergeSort(int low, int high) {
        if (low >= high)
            return;
        int middle = low + (high - low) / 2;
        mergeSort(low, middle);
        mergeSort(middle+1, high);
        merge(low, middle, high);
    }

    private void merge(int low, int middle, int high) {
        int i = low, j = middle + 1, k = low;
        copyArray(low,high);
        while (i <= middle && j <= high)
            arrayToBeSorted[k++] = mergeArray[i] <= mergeArray[j] ? mergeArray[i++] : mergeArray[j++];
        while (i <= middle)
            arrayToBeSorted[k++] = mergeArray[i++];
    }
    private void copyArray(int low, int high){
        for (int i = low; i <= high; i++) {
            mergeArray[i] = arrayToBeSorted[i];
        }
    }
}