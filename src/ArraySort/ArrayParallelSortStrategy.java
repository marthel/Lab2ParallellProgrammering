package ArraySort;

import Stratagy.Sort;

import java.util.Arrays;

/**
 * Created by martin on 15/03/2017
 */
public class ArrayParallelSortStrategy extends Sort {


    public ArrayParallelSortStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        Arrays.parallelSort(super.getListToBeSorted());
        return super.getListToBeSorted();
    }




}