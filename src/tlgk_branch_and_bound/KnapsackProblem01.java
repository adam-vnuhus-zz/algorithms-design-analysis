package tlgk_branch_and_bound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class KnapsackProblem01 {

    static int n;
    static double M;
    static double[] W = new double[100];    //weight
    static double[] V = new double[100]; //value

    static int[] a = new int[100];
    static int[] x = new int[100];

    static double weight, value, vmax;

    static void init() {
        try {
            Scanner scanner = new Scanner(new File("/Users/anhtd/Documents/JavaPrograms/AlgorithmDesgin&Analysis/src/tlgk_branch_and_bound/input.txt"));
            while (scanner.hasNext()) {
                n = scanner.nextInt();
                M = scanner.nextInt();
                for (int i = 1; i <= n; i++) {
                    V[i] = scanner.nextInt();
                }
                for (int i = 1; i <= n; i++) {
                    W[i] = scanner.nextInt();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        vmax = -1;
        weight = 0;
        value = 0;
    }

    static void update() {
        if (weight <= M) {
            if (value > vmax) {
                vmax = value;
                for (int i = 1; i <= n; i++) {
                    x[i] = a[i];
                }
            }
        }
    }

    static void trySolution(int i) {
        for (int j = 0; j <= 1; j++) {
            a[i] = j;
            if (j == 1) {
                weight = weight + W[i];
                value = value + V[i];
            }
            if (weight <= M) {
                if (i == n) {
                    update();
                } else {
                    trySolution(i + 1);
                }
            }
            if (j == 1) {
                weight = weight - W[i];
                value = value - V[i];
            }
        }
    }

    static void printResult(){
        System.out.println("Tong gia tri lon nhat: " + vmax);
        System.out.println("Chon cac do vat sau: ");
        for (int i = 1; i <= n; i++) {
            if(x[i] == 1){
                System.out.print(i + "\t");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        init();
        trySolution(1);
        printResult();
    }
}
