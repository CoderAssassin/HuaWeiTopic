import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/3.
 * 合唱队：我的解法
 * 思路：动态规划，从左到右记录每个位置最多的递增队列，从右到左记录每个位置最多的递减队列，然后相加减一即为该位置的最多队列人数+1，总人数减一下
 */
public class issue23 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();

        int[] heights=new int[num];//身高
        int[] dp_left=new int[num];//从左往右dp
        int[] dp_right=new int[num];//从右往左dp

        for (int i=0;i<num;i++){
            heights[i]=sc.nextInt();
            dp_left[i]=1;
            dp_right[i]=1;
        }
        int max=0;//最多留下的人数

//        从左到右更新dp
        for (int i=0;i<num;i++){
            for (int j=0;j<i;j++){
                if (heights[i]>heights[j]&&dp_left[j]+1>dp_left[i]){
                    dp_left[i]=dp_left[j]+1;
                }
            }
        }
//        从右到左更新dp
        for (int i=num-1;i>=0;i--){
            for (int j=num-1;j>i;j--){
                if (heights[i]>heights[j]&&dp_right[j]+1>dp_right[i]){
                    dp_right[i]=dp_right[j]+1;
                }
            }
        }
//        开始计算最终的踢人数
        for (int i=0;i<num;i++){
            int tick=dp_left[i]+dp_right[i];
            if (tick>max)
                max=tick;
        }

        System.out.println(num-max+1);
    }
}
