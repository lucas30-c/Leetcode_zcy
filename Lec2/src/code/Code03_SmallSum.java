package code;

//小和问题（重点）
//面对左组和右组相等，一定要拷贝右边组。
//不会重复算，不会漏算，只有合并的时候才会产生小和
public class Code03_SmallSum {

    public static int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }

        return process(arr, 0, arr.length - 1);
    }

    //arr[L..R] 既要排好序，也要求小和
    public static int process(int[] arr, int l, int r) {
        if (l == r) {
            return 0;
        }

        int mid = l + ((r - l) >> 1);
        return process(arr, l, mid)         //左侧排序求小和
                + process(arr, mid + 1, r)  //右侧排序求小和
                + merge(arr, l, mid, r);    //合并以后产生的小和
    }

    public static int merge(int[] arr, int L, int M, int R) {
        int[] helper = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        int res = 0;
        while (p1 <= M && p2 <= R) {
            //只有左组比右组小，才产生小和增加的行为。
            //右组有R - p2 + 1个数比当前左组的数大
            res += arr[p1] < arr[p2] ? (R - p2 + 1)  * arr[p1] : 0;  //算小和
            //只有在左组元素比右组小拷贝左组，否则拷贝右组
            helper[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            helper[i++] = arr[p1++];
        }
        while (p2 <= R) {
            helper[i++] = arr[p2++];
        }
        for (i = 0; i < helper.length; i++) {
            arr[L + i] = helper[i]; //拷贝，这样就完成了L~R上的排序过程
        }
        return res;
    }
}
