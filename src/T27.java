import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:02 18-6-21
 * 素数伴侣：别人解法
 * 思路：匈牙利算法，这题不知道只能一脸懵逼
 **/
public class T27 {

    private static int max=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int n=Integer.parseInt(str);

            String[] strs=sc.nextLine().split(" ");

            ArrayList<Integer> odd=new ArrayList<>();//左边奇数组
            ArrayList<Integer> even=new ArrayList<>();//右边偶数组

    //        数据输入，分成奇数组和偶数组
            int temp;
            for (int i=0;i<n;i++){
                temp=Integer.parseInt(strs[i]);
                if (temp%2!=0)
                    odd.add(temp);
                else even.add(temp);
            }

            int[] evensMatch=new int[even.size()];//与偶数匹配的奇数
            int result=0;
            for (int i=0;i<odd.size();i++){
                int[] used=new int[even.size()];//已经匹配的偶数
                if (find(odd.get(i),even,used,evensMatch)){//当前奇数能匹配，那么结果加一
                    result++;
                }
            }
            System.out.println(result);
        }
        sc.close();
    }

//    找到与当前奇数相匹配的偶数，并且使得前面的奇数都能有匹配的偶数
    private static boolean find(int x,ArrayList<Integer> evens,int[] used,int[] evensMatch){

        int j;
        for (j=0;j<evens.size();j++){//扫描每个偶数，当前的奇数和偶数(没有使用过)是否能组成素数
            if (isPrime(x+evens.get(j))&&used[j]==0){
                used[j]=1;//标记为该偶数已使用
//                若没有与该偶数匹配的奇数，或有匹配，那么找到该偶数匹配的奇数的下一个可匹配的偶数，即拆开该偶数匹配的奇数的链，将当前偶数和奇数匹配上
                if (evensMatch[j]==0||find(evensMatch[j],evens,used,evensMatch)){
                    evensMatch[j]=x;//标记与当前偶数匹配的奇数为当前奇数x
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isPrime(int num){

        if (num==1)
            return false;
        for (int i=2;i<Math.sqrt(num);i++){
            if (num%i==0)
                return false;
        }
        return true;
    }
}
