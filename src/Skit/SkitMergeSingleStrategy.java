package Skit;

import MergeSingle.OutOfPlaceMergeSingle;
import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class SkitMergeSingleStrategy extends Sort {


    public SkitMergeSingleStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        new SkitMergeSort().sort(super.getListToBeSorted());
        return null;
    }
}
