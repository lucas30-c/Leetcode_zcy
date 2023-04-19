package test;

import code.Code02_MergeSort;
import code.Code03_SmallSum;
import org.junit.Test;

import java.util.Arrays;

public class Test_Lec2 {

    @Test
    public void testMergeSort() {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        Code02_MergeSort.process(arr, 0, arr.length - 1);
        //System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));
        //Arrays.toString(arr)才能输出内容
    }

    @Test
    public void testSmallSum() {
        int[] arr1 = {2, 4, 5, 1, 7, 3};
        int[] arr2 = {1, 3, 4, 2, 5};
        System.out.println(Code03_SmallSum.smallSum(arr2));
    }
}
