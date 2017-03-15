package QuickMulti;

import java.util.concurrent.RecursiveTask;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class MultiPivotQuick extends RecursiveTask<float[]> {


    private float[] listToBeSorted;
    private static int Threshold = 100000;
    private int lo,hi;

    public MultiPivotQuick(float[] listToBeSorted,int lo,int hi) {
        this.lo = lo;
        this.hi = hi;
        this.listToBeSorted = listToBeSorted;
    }

    @Override
    protected float[] compute() {

        if (listToBeSorted.length < Threshold){
            quickSort(listToBeSorted, lo, hi);
        }else {

            if ((hi-lo) <= 1)
                return null;
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

            MultiPivotQuick left = new MultiPivotQuick(listToBeSorted,lo,i);
            MultiPivotQuick right = new MultiPivotQuick(listToBeSorted,i+1,hi);

            left.fork();
            right.compute();
            left.join();
        }


        return null;
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
