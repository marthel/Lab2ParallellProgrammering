package ArraySort;

import Stratagy.Sort;

import java.util.Arrays;

/**
 * Created by martin on 15/03/2017
 */
public class ArraySortStrategy extends Sort {


    public ArraySortStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        Arrays.sort(super.getListToBeSorted());
        return super.getListToBeSorted();
    }




}