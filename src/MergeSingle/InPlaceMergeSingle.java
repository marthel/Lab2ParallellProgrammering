package MergeSingle;

/**
 * Created by martin on 15/03/2017.
 */
public class InPlaceMergeSingle {

    public void skitMerge(float[] unsortedArr, int left, int mid, int right)
    {
        float [] temp = new float[unsortedArr.length];
        int i, left_end, num_elements, tmp_pos;

        left_end = (mid - 1);
        tmp_pos = left;
        num_elements = (right - left + 1);

        while ((left <= left_end) && (mid <= right))
        {
            if (unsortedArr[left] <= unsortedArr[mid])
                temp[tmp_pos++] = unsortedArr[left++];
            else
                temp[tmp_pos++] = unsortedArr[mid++];
        }

        while (left <= left_end)
            temp[tmp_pos++] = unsortedArr[left++];

        while (mid <= right)
            temp[tmp_pos++] = unsortedArr[mid++];

        for (i = 0; i < num_elements; i++)
        {
            unsortedArr[right] = temp[right];
            right--;
        }
    }

    public void skitMergeSort(float[] unsortedArr, int left, int right)
    {
        int mid;

        if (right > left)
        {
            mid = (right + left) / 2;
            skitMergeSort(unsortedArr, left, mid);
            skitMergeSort(unsortedArr, (mid + 1), right);

            skitMerge(unsortedArr, left, (mid+1), right);
        }
    }
}
