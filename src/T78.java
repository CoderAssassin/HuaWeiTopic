import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:30 18-8-16
 * 计算字符串的相似度：我的解法
 **/
public class T78 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();
            int len1=str1.length();
            int len2=str2.length();

            int[][] dp=new int[len1+1][len2+1];

            for (int i=1;i<=len2;i++)
                dp[0][i]=i;
            for (int i=1;i<=len1;i++)
                dp[i][0]=i;

            for (int i=1;i<=len1;i++){
                for (int j=1;j<=len2;j++){
                    if (str1.charAt(i-1)==str2.charAt(j-1))
                        dp[i][j]=Math.min(dp[i-1][j-1],Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                    else dp[i][j]=Math.min(dp[i-1][j-1]+1,Math.min(dp[i-1][j]+1,dp[i][j-1]+1));
                }
            }
            System.out.println("1/"+(dp[len1][len2]+1));
        }
    }
}
