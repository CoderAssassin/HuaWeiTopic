import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:09 18-8-16
 * 字符串运用-密码截取：我的解法
 **/
public class T84 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int max=0,curLen=0,len=str.length();
            int start=0,end=0,beginIndex=0;
            for (int i=0;i<len;i++){
//                奇数情况
                int left=i-1,right=i+1;
                while (left>=0&&right<len&&str.charAt(left)==str.charAt(right)){
                    curLen=right-left;
                    if (curLen>max)
                        max=curLen;
                    left--;
                    right++;
                }

//                偶数
                left=i;
                right=i+1;
                while (left>=0&&right<len&&str.charAt(left)==str.charAt(right)){
                    curLen=right-left;
                    if (curLen>max)
                        max=curLen;
                    left--;
                    right++;
                }
            }
            System.out.println(max+1);
        }
    }
}
