import ArraySort.ArrayParallelSortStrategy;
import ArraySort.ArraySortStrategy;
import MergeMulti.OutOfPlaceMergeMultiThreadStrategy;
import QuickMulti.MultiPivotQuickStrategy;
import QuickSingle.SinglePivotQuickStrategy;
import MergeSingle.OutOfplaceMergeSingleStrategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by Scalman on 29/02/16.
 */
public class Main {



    private static int SIZE = 100000000;


    public static void main(String[] args) throws InterruptedException {



        ArrayList<TimeMeasurer> tm = CreateStrategies();

        for (TimeMeasurer t:tm ) {
            t.run();
        }

    }


    private static ArrayList<TimeMeasurer> CreateStrategies(){
        ArrayList<TimeMeasurer> tm = new ArrayList<>();
        for(int i=0; i<20; i++) {
            tm.add(new TimeMeasurer(new ArraySortStrategy(randomGenerator())));
            tm.add(new TimeMeasurer(new ArrayParallelSortStrategy(randomGenerator())));
            tm.add(new TimeMeasurer(new OutOfplaceMergeSingleStrategy(randomGenerator())));
            tm.add(new TimeMeasurer(new SinglePivotQuickStrategy(randomGenerator())));
        }

        for (int j=2; j<5; j++) {
            for (int i = 1; i < 20; i++) {
                tm.add(new TimeMeasurer(new OutOfPlaceMergeMultiThreadStrategy(randomGenerator(), j)));
                tm.add(new TimeMeasurer(new MultiPivotQuickStrategy(randomGenerator(), j)));
            }
        }

        return tm;
    }

    private static float[] randomGenerator(){
        Random r = new Random(System.currentTimeMillis());
        float[] unsortedArray = new float[100000000];
        for (int i=0; i<unsortedArray.length; i++) unsortedArray[i] = r.nextFloat()*4;
        return  unsortedArray;
    }

}

