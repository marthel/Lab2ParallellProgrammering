package SkitMulti;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class SkitMergeMultiStrategy extends Sort {


    public SkitMergeMultiStrategy(float[] listToBeSorted, int poolSize) {
        super(listToBeSorted, poolSize);
    }

    @Override
    public float[] handle() {

        super.getPool().invoke(new SkitMergeSortMulti(super.getListToBeSorted(), 0, super.getListToBeSorted().length - 1));
        return null;
    }

}
