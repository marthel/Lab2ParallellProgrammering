package old.MergeMulti;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class MultiMergeStrategy extends Sort {

    int threshold;
    public MultiMergeStrategy(float[] listToBeSorted, int poolSize,int threshold) {
        super(listToBeSorted, poolSize);
        this.threshold = threshold;
    }

    @Override
    public float[] handle() {
        getPool().submit(new MultiMerge(getListToBeSorted(), 0, getListToBeSorted().length,threshold)).join();
        return null;
    }

}
