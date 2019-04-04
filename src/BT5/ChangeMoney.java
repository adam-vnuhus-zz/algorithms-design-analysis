package BT5;

import java.util.Arrays;

public class ChangeMoney {
    public static void main(String args[]) {
        int[] input = {1, 50, 10, 5};
        int[] temp1 = Arrays.copyOf(input, input.length);
        int[] res = new int[input.length];
        int m = 78;
        int[] l = new int[input.length];
        for (int i = 0; i < input.length; i++)
            l[i] = i;
        for (int i = 0; i < input.length - 1; i++)
            for (int j = i + 1; j < input.length; j++)
                if (temp1[i] < temp1[j]) {
                    int temp = l[i];
                    l[i] = l[j];
                    l[j] = temp;
                    temp = temp1[i];
                    temp1[i] = temp1[j];
                    temp1[j] = temp;
                }
        for (int i = 0; i < l.length; i++) {
            res[l[i]] = (m / input[l[i]]);
            m %= input[l[i]];
        }
        if (m == 0)
            for (int i = 0; i < input.length; i++)
                System.out.println(res[i]);
        else System.out.println("Khong co ket qua");
    }

}
