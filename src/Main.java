import ArraySort.ArrayParallelSortStrategy;
import ArraySort.ArraySortStrategy;
import MergeMulti.OutOfPlaceMergeMultiThreadStrategy;
import MergeSingle.InPlaceMergeSingleStrategy;
import QuickMulti.MultiPivotQuickStrategy;
import QuickSingle.SinglePivotQuickStrategy;
import MergeSingle.OutOfplaceMergeSingleStrategy;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Scalman on 29/02/16.
 */
public class Main {


    public static void main(String[] args) throws InterruptedException {
        Random r = new Random(System.currentTimeMillis());
        float[] unsortedArray = new float[100000000];
        for (int i=0; i<unsortedArray.length; i++) unsortedArray[i] = r.nextFloat()*4;



//        new TimeMeasurer(new ArraySortStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length))).run();
//
//        new TimeMeasurer(new SinglePivotQuickStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length))).run();
//        new TimeMeasurer(new OutOfplaceMergeSingleStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length))).run();
//        new TimeMeasurer(new InPlaceMergeSingleStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length))).run();
//
        new TimeMeasurer(new MultiPivotQuickStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length),4)).run();
//        new TimeMeasurer(new OutOfPlaceMergeMultiThreadStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length),8)).run();
        new TimeMeasurer(new ArrayParallelSortStrategy(Arrays.copyOf(unsortedArray, unsortedArray.length))).run();
    }

}

