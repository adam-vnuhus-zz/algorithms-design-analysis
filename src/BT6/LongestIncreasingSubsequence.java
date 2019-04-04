package BT6;

public class LongestIncreasingSubsequence {

    static int a[] = {2, 5, 4, 6, 3, 8, 9, 7};
    static int L[] = new int[a.length + 1];

    static int max() {
        int max = 0;

        for (int i = 0; i < a.length; i++) {
            L[i] = 1;
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = 0; j < i; j++) {
                if (a[i] > a[j] && L[i] < L[j] + 1)
                    L[i] = L[j] + 1;
            }
        }

        for (int i = 0; i < a.length; i++) {
            if (max < L[i])
                max = L[i];
        }

        return max;
    }

    static void truyVet() {
        //Bang phuong an
        L[0] = 0;
        for (int i = 1; i < a.length + 1; i++) {
            L[i] = 1;
            for (int j = 1; j < i + 1; j++) {
                if (a[j - 1] < a[i - 1] && j < i && L[i] < L[j] + 1) {
                    L[i] = L[j] + 1;
                }
            }
        }
        for (int i = 0; i < a.length + 1; i++) {
            System.out.print(L[i] + "  ");
        }
        System.out.println();

        //Day con tang dai nhat
        int Max = max();
        int result[] = new int[a.length];
        for (int i = a.length; i >= 0; i--) {
            if (L[i] == Max) {
                result[i] = a[i];
                Max--;
            }
        }
        for (int x : result) {
            System.out.print("  " + x);
        }
    }

    public static void main(String[] args) {
        System.out.println(max());
        truyVet();
    }

}
