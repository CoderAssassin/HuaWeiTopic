import java.util.Date;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:25 18-8-17
 * Redraiment的走法：我的解法
 **/
public class T102 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int[] arr=new int[n];
            int[] dp=new int[n];//到第i个数的最大连续递增串长度
            int res=0;
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                dp[i]=1;
                for (int j=0;j<i;j++){
                    if (arr[i]>arr[j])
                        dp[i]=Math.max(dp[i],dp[j]+1);
                }
                res=Math.max(res,dp[i]);
            }
            System.out.println(res);
        }
    }
}
