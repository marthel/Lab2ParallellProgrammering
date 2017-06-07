package Stratagy;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by waleedhassan on 14/03/17.
 */
public abstract class Sort{


    private float[] listToBeSorted;
    private ForkJoinPool pool;

    public Sort(float[] listToBeSorted,int poolSize) {
        this.pool = new ForkJoinPool(poolSize);
        this.listToBeSorted = listToBeSorted;
    }

    public Sort(float[] listToBeSorted) {
        this.listToBeSorted = listToBeSorted;
    }
    public void warmUp(){
        float[] tmp = Arrays.copyOf(listToBeSorted,listToBeSorted.length);
        handle();
        listToBeSorted = tmp;
    }
    public abstract float[] handle();

    public String checkIfSorted(){
        for (int i=0; i<listToBeSorted.length-1; i++){

            if (listToBeSorted[i] > (listToBeSorted[i+1])){
                return "Failed";
            }
        }
        return "Succeeded";
    }

    public ForkJoinPool getPool() {
        return pool;
    }
    public float[] getListToBeSorted() {
        return listToBeSorted;
    }
}
