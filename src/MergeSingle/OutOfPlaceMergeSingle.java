package MergeSingle;

import java.util.Arrays;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class OutOfPlaceMergeSingle {



    public void mergeSort(float[] unSortedArr){

        if (unSortedArr.length <= 1)
            return;

        float[] left = Arrays.copyOf(unSortedArr,(unSortedArr.length / 2));
        float[] right = Arrays.copyOfRange(unSortedArr,(unSortedArr.length/2),unSortedArr.length);

        mergeSort(left);
        mergeSort(right);

        merge(left,right,unSortedArr);
    }


    private void merge(float[] left, float[] right, float[] unSortedArr){

        int leftIndex = 0,rightIndex = 0,resultIndex = 0;

        while (leftIndex < left.length && rightIndex < right.length) {
            unSortedArr[resultIndex++] = left[leftIndex] <= right[rightIndex] ? left[leftIndex++] : right[rightIndex++];
        }
        while (leftIndex < left.length){
            unSortedArr[resultIndex++] = left[leftIndex++];
        }
        while (rightIndex < right.length){
            unSortedArr[resultIndex++] = right[rightIndex++];
        }
    }
}
