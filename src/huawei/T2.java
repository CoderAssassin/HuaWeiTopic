package huawei;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:44 18-8-22
 **/
public class T2 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int start=0;
            int res=0;
            int[] dp=new int[str.length()];
            for (int i=1;i<str.length();i++){
                if (str.charAt(i)==')'){
                    start=i-dp[i-1]-1;
                    if (start>=0&&str.charAt(start)=='('){
                        if (start>0)
                            dp[i]=dp[i-1]+2+dp[start-1];
                        else dp[i]=dp[i-1]+2;
                    }
                }
                res=Math.max(res,dp[i]);
            }
            System.out.println(res);
        }
    }
}
