package QuickSingle;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class SinglePivotQuick{


    public  void quckSort(float[] arrayToBeSorted){
        quickSort(arrayToBeSorted, 0, arrayToBeSorted.length );
    }

    private void quickSort(float[] arrayOfRandomNumbers, int lo, int hi){

        if ((hi-lo) <= 1)
            return;
        int i = lo;
        float pivot = arrayOfRandomNumbers[hi-1];

        for(int j=lo; j<hi-1; j++){

            if (arrayOfRandomNumbers[j] < pivot){
                float tmp = arrayOfRandomNumbers[j];
                arrayOfRandomNumbers[j] = arrayOfRandomNumbers[i];
                arrayOfRandomNumbers[i++] = tmp;
            }
        }

        arrayOfRandomNumbers[hi-1] = arrayOfRandomNumbers[i];
        arrayOfRandomNumbers[i] = pivot;

        quickSort(arrayOfRandomNumbers, lo, i);
        quickSort(arrayOfRandomNumbers, i+1, hi);

    }
}
