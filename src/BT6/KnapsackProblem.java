package BT6;

public class KnapsackProblem {

    static int n = 4;    //so luong do vat
    static int m = 4;    //trong luong toi da
    static int[][] temp = new int[50][50];
    static int[] power = {2, 1, 2, 1};    //khoi luong
    static int[] worth = {3, 2, 2, 1};    //gia tri

    //Tao bang phuong an
    public static void createTable() {
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (power[i - 1] <= j) {
                    temp[i][j] = Math.max(temp[i - 1][j - power[i - 1]] + worth[i - 1], temp[i - 1][j]);
                } else temp[i][j] = temp[i - 1][j];
            }
        }
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void truyvet() {
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (temp[i][j] == temp[i - 1][j - power[i - 1]] + worth[i - 1]) {
                System.out.println(i);
                j -= power[i - 1];
            }
            i--;
        }
    }

    public static void main(String[] args) {
        System.out.println("Bang phuong an: ");
        createTable();
        System.out.println("Nghiem cua bai toan: ");
        truyvet();
    }
}
