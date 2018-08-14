import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午8:02 18-8-14
 * 计算字符串的距离：我的解法
 * 思路：dp[i][j]表示str1的前i个字符和str2的前j个字符的最少操作次数，总的情况分成，当str1的第i个字符和str2的第j个字符相同的时候；以及
 * 当str1的第i个字符和str2的第j个字符不相同的时候，区别在于不相同的时候默认最后要加1
 **/
public class T51 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();
            int len1=str1.length(),len2=str2.length();

            int[][] dp=new int[len1+1][len2+1];//str1的前i个字符和str2的前j个字符的最少操作次数
            for (int i=1;i<=len2;i++)//当str1有0个字符的时候，转变成str2的前j个字符需要j次操作
                dp[0][i]=i;
            for (int i=1;i<=len1;i++)
                dp[i][0]=i;

            for (int i=1;i<=len1;i++){
                char c1=str1.charAt(i-1);
                for (int j=1;j<=len2;j++){
                    char c2=str2.charAt(j-1);
                    if (c1==c2){
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                    }else {
                        dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                    }
                }
            }
            System.out.println(dp[len1][len2]);
        }
    }
}
