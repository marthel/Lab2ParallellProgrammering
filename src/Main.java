import old.MergeMulti.MultiMergeStrategy;

import java.util.Random;

/**
 * Created by Scalman on 29/02/16.
 */
public class Main {


    private static int SIZE = 100000000;


    public static void main(String[] args) throws InterruptedException {
        System.out.println("merge");

        for (int j=2; j<5; j++) {
            for (int i = 0; i < 20; i++) {
                new TimeMeasurer(new MultiMergeStrategy(randomGenerator(),j,10000000)).run();
            }
        }

    }

    private static float[] randomGenerator(){
        Random r = new Random(System.currentTimeMillis());
        float[] unsortedArray = new float[SIZE];

        for (int i=0; i<unsortedArray.length; i++)
            unsortedArray[i] = r.nextFloat()*4;


        return  unsortedArray;
    }

}

