package MergeMulti;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class OutOfPlaceMergeMulti extends RecursiveTask<float[]>{


    private float[] listToBeSorted;
    private static int Threshold = 100000;

    public OutOfPlaceMergeMulti(float[] listToBeSorted) {
        this.listToBeSorted = listToBeSorted;
    }

    @Override
    protected float[] compute() {

        if (listToBeSorted.length < Threshold){
           return mergeSort(listToBeSorted);
        }else {
            OutOfPlaceMergeMulti left = new OutOfPlaceMergeMulti(Arrays.copyOf(listToBeSorted,listToBeSorted.length/2));
            OutOfPlaceMergeMulti right = new OutOfPlaceMergeMulti(Arrays.copyOfRange(listToBeSorted,listToBeSorted.length/2,listToBeSorted.length));
            left.fork();
            right.compute();
            left.join();
            return merge(left.listToBeSorted,right.listToBeSorted,listToBeSorted);
        }
    }


    public float[] mergeSort(float[] unSortedArr){

        if (unSortedArr.length == 1)
            return unSortedArr;

        float[] left = Arrays.copyOf(unSortedArr,(unSortedArr.length / 2));
        float[] right = Arrays.copyOfRange(unSortedArr,(unSortedArr.length/2),unSortedArr.length);

        mergeSort(left);
        mergeSort(right);

        return merge(left,right,unSortedArr);
    }
    private float[] merge(float[] left, float[] right, float[] unSortedArr){

        int leftIndex = 0,rightIndex = 0,resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length){
            unSortedArr[resultIndex++] = left[leftIndex] <= right[rightIndex] ? left[leftIndex++] : right[rightIndex++];
        }

        while (leftIndex < left.length){
            unSortedArr[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length){
            unSortedArr[resultIndex++] = right[rightIndex++];
        }
        return unSortedArr;
    }
}

