package MergeSingle;

import Stratagy.Sort;

/**
 * Created by martin on 15/03/2017.
 */
public class InPlaceMergeSingleStrategy extends Sort {
    public InPlaceMergeSingleStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        new InPlaceMergeSingle().skitMergeSort(super.getListToBeSorted(),0,super.getListToBeSorted().length-1);
        return null;
    }
}
