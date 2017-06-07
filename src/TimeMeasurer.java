import Stratagy.Sort;

/**
 * Created by waleedhassan on 14/03/17.
 */
public class TimeMeasurer {

    private Sort sort;

    public TimeMeasurer(Sort someSort) {
        this.sort = someSort;
    }

    public void run() throws InterruptedException {

        if (sort == null){
            return;
        }

        System.gc();
        Thread.sleep(1000);
        sort.warmUp();
        System.gc();
        Thread.sleep(1000);

        long start = System.nanoTime();
        sort.handle();
        long end = System.nanoTime() - start;

        System.out.println(sort.getClass().getCanonicalName() + ":  " + end/1000000000.0 + " s" + " Sorted: " + sort.checkIfSorted());

    }

    public void setSort(Sort sort) {
        this.sort = sort;
    }
}
