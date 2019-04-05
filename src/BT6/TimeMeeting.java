package BT6;

public class TimeMeeting {

    public static void setupMeeting(Meeting meetings[]) {
        int[] LIS = new int[meetings.length];
        for (int i = 0; i < meetings.length; i++) {
            int max = -1;
            for (int j = 0; j < i; j++) {
                //Kiem tra
                if ((meetings[i].getBegin() >= meetings[j].getEnd())) {
                    if (max == -1 || max < LIS[j] + 1) {
                        max = 1 + LIS[j];
                    }
                }
            }
            if (max == -1) {
                max = 1;
            }
            LIS[i] = max;
        }
        // tim
        int result = -1;
        int index = -1;
        for (int i = 0; i < LIS.length; i++) {
            if (result < LIS[i]) {
                result = LIS[i];
                index = i;
            }
        }

        // truy vet
        Meeting re[] = new Meeting[result];
        int k = 0;
        for (int i = 0; i < re.length; i++) {
            re[i] = new Meeting();
        }

        re[0].setBegin(meetings[index].getBegin());
        re[0].setEnd(meetings[index].getEnd());

        int res = result - 1;
        for (int i = index - 1; i >= 0; i--) {
            if (LIS[i] == res) {
                k++;
                re[k].setBegin(meetings[i].getBegin());
                re[k].setEnd(meetings[i].getEnd());
                res--;
            }
        }
        System.out.println("So luong cuoc hop nhieu nhat duoc bo tri: " + result);
        System.out.println("Thong tin cac cuoc hop duoc len lich: ");


        for (int i = re.length - 1; i >= 0; i--) {
            System.out.println(re[i].toString());
        }
    }

    public static void main(String[] args) {
        Meeting meetings[] = {new Meeting(1, 3), new Meeting(2, 5), new Meeting(4, 7), new Meeting(1, 8),
                new Meeting(5, 9), new Meeting(8, 10), new Meeting(9, 11), new Meeting(11, 14), new Meeting(13, 16)};
        setupMeeting(meetings);
    }
}
