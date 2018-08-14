import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:40 18-8-14
 * 线性插值：我的解法
 * 坑点：输入的m是说明下面的数的组数，n没屁用，对于每一组数，第一个是key，第二个说明值，上面说的区间是key之间的区间，然后插值的话是针对的值插值的，
 * 重复的话是指的key不能重复
 **/
public class T46 {
    public static String process(int[][] values) {
        int len = values.length;
        List<String> toFill = new ArrayList<String>();
        int curNo = values[0][0], curV = values[0][1];
        for (int i = 1; i <= len - 1; i++) {
            if (values[i][0] - curNo > 1) {
                cal(curNo, curV, values[i][0], values[i][1], toFill);
                curNo = values[i][0];
                curV = values[i][1];
                continue;
            } else if (values[i][0] - curNo == 1 || values[i][0] - curNo < 0) {
                toFill.add(curNo + " " + curV);
                curNo = values[i][0];
                curV = values[i][1];
                continue;
            } else if (values[i][0] - curNo == 0) {// 编号相等
                continue;
            }
        }
        toFill.add(curNo + " " + curV);
        StringBuilder res = new StringBuilder();
        for (String str : toFill) {
            res.append(str + "\r\n");
        }
        return res.substring(0, res.length() - 1);
    }

    public static void cal(int smallNo, int smallV, int bigNo, int bigV, List<String> toFill) {
        toFill.add(smallNo + " " + smallV);
        int nums = bigNo - smallNo - 1;
        for (int i = 1; i <= nums; i++) {
            int curNo = smallNo + i;
            int curV = smallV + ((bigV - smallV) / (bigNo - smallNo)) * i;
            toFill.add(curNo + " " + curV);
        }
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int M = in.nextInt();
            int N = in.nextInt();
            int[][] values = new int[M][2];
            for (int i = 0; i < M; i++) {
                values[i][0] = in.nextInt();
                values[i][1] = in.nextInt();
            }
            System.out.println(process(values));
        }
        in.close();
    }
}
