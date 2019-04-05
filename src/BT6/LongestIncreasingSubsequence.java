package BT6;

public class LongestIncreasingSubsequence {

    public static void findSubsequence(int[] arrA) {
        int[] LIS = new int[arrA.length];
        for (int i = 0; i < arrA.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                // kiem tra neu phan tu truoc > phan tu hien tai
                if (arrA[i] > arrA[j]) {
                    // cap nhat max
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                // khong co phan tu nao nho hon arrA[i]
                max = 1;
            }
            LIS[i] = max;
        }

        // tim Max trong mang LIS[]
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }


        //In ra ket
        String path = arrA[index] + " ";
        int res = result - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (LIS[i] == res) {
                path = arrA[i] + " " + path;
                res--;
            }
        }
        System.out.println("Do dai day con tang dai nhat: " + result);
        System.out.println("Cac phan tu trong day: " + path);
    }

    public static void main(String[] args) {

        int[] A = {2, 5, 4, 6, 3, 8, 9, 7};
        findSubsequence(A);
    }
}