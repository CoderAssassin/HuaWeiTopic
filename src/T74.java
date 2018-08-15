import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:45 18-8-15
 * 公共字串计算：我的解法
 **/
public class T74 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();

            if (str1.length()<str2.length())
                cal(str1,str2);
            else cal(str2,str1);
        }
    }

    private static void cal(String str1,String str2){

        int max=0;
        int[][] dp=new int[str1.length()+1][str2.length()+1];//str1前i和str2前i的最长公共子串
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if (Character.toLowerCase(str1.charAt(i-1))==Character.toLowerCase(str2.charAt(j-1))){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (dp[i][j]>max){
                        max=dp[i][j];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
