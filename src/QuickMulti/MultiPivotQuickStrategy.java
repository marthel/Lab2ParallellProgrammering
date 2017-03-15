package QuickMulti;


import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class MultiPivotQuickStrategy extends Sort {


    public MultiPivotQuickStrategy(float[] listToBeSorted, int poolSize) {
        super(listToBeSorted, poolSize);
    }

    @Override
    public float[] handle() {

        super.getPool().invoke(new MultiPivotQuick(super.getListToBeSorted(),0,super.getListToBeSorted().length));

        return null;
    }
}
