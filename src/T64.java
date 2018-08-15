import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:46 18-8-15
 * 查找两个字符串a,b中的最长公共子串：我的解法
 **/
public class T64 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();
            int len1=str1.length();
            int len2=str2.length();

            if (len1>len2)
                cal(str2,str1);
            else cal(str1,str2);
        }
    }

    private static void cal(String str1,String str2){

        int index=0,max=0;
        int[][] dp=new int[str1.length()+1][str2.length()+1];//str1前i和str2前i的最长公共子串
        for (int i=1;i<=str1.length();i++){
            for (int j=1;j<=str2.length();j++){
                if (str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                    if (dp[i][j]>max){
                        max=dp[i][j];
                        index=i-max;
                    }
                }
            }
        }
        System.out.println(str1.substring(index,index+max));
    }
}
