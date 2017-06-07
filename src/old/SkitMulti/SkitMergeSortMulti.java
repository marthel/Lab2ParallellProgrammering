package old.SkitMulti;

import java.util.concurrent.RecursiveTask;

/**
 * Created by martin on 15/03/2017.
 */
public class SkitMergeSortMulti extends RecursiveTask<float[]> {

    private float[] arrayToBeSorted;
    private float[] mergeArray;
    int low,high;
    private static int Threshold = 1000000;


    public SkitMergeSortMulti(float[] values, int low, int high,float[] mergeArray) {
        this.arrayToBeSorted = values;
        this.low = low;
        this.high = high;
        this.mergeArray = mergeArray;
    }

    @Override
    protected float[] compute() {
        if (low >= high) {
            return mergeSort(low, high);
        }else {
            int middle = low + (high - low) / 2;
            SkitMergeSortMulti left = new SkitMergeSortMulti(arrayToBeSorted, low, middle, mergeArray);
            SkitMergeSortMulti right = new SkitMergeSortMulti(arrayToBeSorted, middle+1, high, mergeArray);
            left.fork();
            right.compute();
            left.join();

            return merge(low, middle, high);
        }
    }

    private float[] mergeSort(int low, int high) {
        if (low >= high)
            return arrayToBeSorted;
        int middle = low + (high - low) / 2;
        mergeSort(low, middle);
        mergeSort(middle+1, high);
        return merge(low, middle, high);
    }

    private float[] merge(int low, int middle, int high) {
        copyArray();
        int i = low, j = middle + 1, k = low;
        while (i <= middle && j <= high)
            arrayToBeSorted[k++] = mergeArray[i] <= mergeArray[j] ? mergeArray[i++] : mergeArray[j++];
        while (i <= middle)
            arrayToBeSorted[k++] = mergeArray[i++];
        return arrayToBeSorted;
    }
    private void copyArray(){
        for (int i = low; i <= high; i++) {
            mergeArray[i] = arrayToBeSorted[i];
        }
    }
}
