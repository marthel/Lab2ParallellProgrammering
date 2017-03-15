package MergeMulti;

import MergeSingle.OutOfPlaceMergeSingle;
import QuickMulti.MultiPivotQuick;
import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class OutOfPlaceMergeMultiThreadStrategy extends Sort {


    public OutOfPlaceMergeMultiThreadStrategy(float[] listToBeSorted, int poolSize) {
        super(listToBeSorted, poolSize);
    }

    @Override
    public float[] handle() {

        super.getPool().invoke(new OutOfPlaceMergeMulti(super.getListToBeSorted()));

        return null;
    }


}