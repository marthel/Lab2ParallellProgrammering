package QuickSingle;

import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class SinglePivotQuickStrategy extends Sort {


    public SinglePivotQuickStrategy(float[] listToBeSorted) {
        super(listToBeSorted);
    }

    @Override
    public float[] handle() {
        new SinglePivotQuick().quckSort(super.getListToBeSorted());
        return super.getListToBeSorted();
    }




}
