package MergeMulti;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class OutOfPlaceMergeMultiThreadStrategy extends Sort {

    int threshold;
    public OutOfPlaceMergeMultiThreadStrategy(float[] listToBeSorted, int poolSize, int threshold) {
        super(listToBeSorted, poolSize);
        this.threshold = threshold;
    }

    @Override
    public float[] handle() {

        super.getPool().invoke(new OutOfPlaceMergeMulti(super.getListToBeSorted(),threshold));

        return null;
    }


}