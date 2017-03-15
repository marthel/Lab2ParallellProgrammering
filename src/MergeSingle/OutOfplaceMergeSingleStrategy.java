package MergeSingle;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class OutOfplaceMergeSingleStrategy extends Sort {


    public OutOfplaceMergeSingleStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        new OutOfPlaceMergeSingle().mergeSort(super.getListToBeSorted());
        return null;
    }
}
