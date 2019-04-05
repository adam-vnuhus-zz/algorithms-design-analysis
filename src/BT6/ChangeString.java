package BT6;

public class ChangeString {
    public static void change(String A, String B, int lengthA, int lengthB, int[][] L) {

        // Xay dung bang
        for (int i = 0; i <= lengthA; i++) {
            for (int j = 0; j <= lengthB; j++) {
                if (i == 0)
                    L[i][j] = j;

                else if (j == 0)
                    L[i][j] = i;

                else if (A.charAt(i - 1) == B.charAt(j - 1))
                    L[i][j] = L[i - 1][j - 1];

                else
                    L[i][j] = 1 + min(L[i][j - 1], // Chen
                            L[i - 1][j], // Xoa
                            L[i - 1][j - 1]); // Thay the
            }
        }

        for (int i = 0; i < lengthA; i++) {
            for (int j = 0; j < lengthB; j++) {
                System.out.print(L[i][j] + " ");
            }
            System.out.println();
        }

        // ket qua
        System.out.println("So cach doi it nhat la: " + L[lengthA - 1][lengthB - 1]);

        //truy vet
        int i = lengthA - 1;
        int j = lengthB - 1;
        while (i > 0 || j > 0) {
            if (A.charAt(i) == B.charAt(j)) {
                i--;
                j--;
            } else if (L[i][j] == L[i][j - 1] + 1) {
                System.out.println("Chen " + B.charAt(j) + " vao sau vi tri " + i);
                j--;
            } else if (L[i][j] == L[i - 1][j - 1] + 1) {
                System.out.println("Thay the " + B.charAt(j) + " vao vi tri " + i);
                i--;
                j--;
            } else if (L[i][j] == L[i - 1][j] + 1) {
                System.out.println("Xoa " + A.charAt(i) + " tai vi tri " + i);
                i--;
            }
        }
    }

    public static int min(int a, int b, int c) {
        int k = Math.min(a, b);
        return Math.min(k, c);
    }

    public static void main(String[] args) {
        //Xau ban dau:
        String A = "thiet";
        // Xau can bien doi
        String B = "thietke";
        // Do dai xau ban dau
        int lengthA = A.length();
        // Do dai xau bien doi
        int lengthB = B.length();
        // Bang luu ket qua bai toan con
        int L[][] = new int[lengthA + 1][lengthB + 1];
        // Co so
        for (int i = 0; i < lengthA + 1; i++) {
            L[i][0] = i;
        }
        for (int i = 0; i < lengthB + 1; i++) {
            L[0][i] = i;
        }
        change(A, B, lengthA, lengthB, L);
    }
}
