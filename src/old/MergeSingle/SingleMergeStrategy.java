package old.MergeSingle;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class SingleMergeStrategy extends Sort {


    public SingleMergeStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        new SingleMerge().sort(getListToBeSorted(),0,getListToBeSorted().length);
        return null;
    }

}
