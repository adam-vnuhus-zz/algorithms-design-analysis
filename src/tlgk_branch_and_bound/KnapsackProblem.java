package tlgk_branch_and_bound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackProblem {

    static int n; //so luong vat
    static int m;   //can nang cua balo
    static int[] value = new int[100];
    static int[] weight = new int[100];
    static int[] x = new int[100]; //luu nhung do vat duoc chon
    static int[] y = new int[100];  //luu phuong an toi uu 0 & 1

    static int vmax; //gia tri lon nhat
    static int vsel;    //gia tri da duoc chon
    static int wrem;    //trong luong con lai

    static float b;

    static void init() {
        try {
            Scanner scanner = new Scanner(new File("C:\\Users\\ANHTDAM\\IdeaProjects\\algorithms-design-analysis\\src\\input.txt"));
            while (scanner.hasNext()){
                n = scanner.nextInt();
                m = scanner.nextInt();
                for (int i = 1; i <= n; i++) {
                    value[i] = scanner.nextInt();
                }
                for (int i = 1; i <= n; i++) {
                    weight[i] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        value[n + 1] = 0;
        weight[n + 1] = 1;
        vmax = 0;
        wrem = m;
        vsel = 0;
        b = m * value[1] / (float) weight[1];

    }

    static void attempt(int i) {
        for (int j = 0; j <= 1; j++) {
            if (j == 1) {
                b = vsel + value[i] + wrem * value[i + 1] / (float) weight[i + 1];
                if (b >= vmax) {
                    x[i] = j;
                    vsel = vsel + value[i];
                    wrem = wrem - weight[i];
                }
            }
            if (i == n || wrem <= 0) {
                ghiNhan();
            } else {
                attempt(i + 1);
            }
            if (j == 1) {
                b = vsel + value[i] + wrem * value[i + 1] / (float) weight[i + 1];
                if (b >= vmax) {
                    x[i] = j;
                    vsel = vsel - value[i];
                    wrem = wrem + weight[i];
                }
            }
        }
    }

    static void ghiNhan() {
        if (vmax <= vsel && wrem >= 0) {
            vmax = vsel;

            for (int i = 1; i <= n; i++) {
                y[i] = x[i];
            }
        }
    }

    static void outPut() {
        int i;
        System.out.println("Gia tri toi uu: \n" + vmax);
        System.out.println("Chon cac do vat sau: ");
        for (i = 1; i <= n; i++) {
            if (y[i] != 0) {
                System.out.print(i + "\t");
            }
        }
//        for (i = 1; i <= n; i++) {
//            if (y[i] != 0) {
//                System.out.print(y[i] + "\t");
//            }
//        }
    }

    public static void main(String[] args) {
        init();
        attempt(1);
        outPut();
    }
}
