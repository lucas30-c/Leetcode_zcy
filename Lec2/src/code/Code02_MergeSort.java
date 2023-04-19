package code;

public class Code02_MergeSort {

    public static void process(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        process(arr, L, mid);
        process(arr, mid + 1, R);
        merge(arr, L, mid, R);

    }

    public static void merge(int[] arr, int L, int M, int R) {
        int[] helper = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = M + 1;
        while (p1 <= M && p2 <= R) {
            helper[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
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
    }

}
