import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 提取不重复的整数
 */
public class issue8 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int num[]=new int[10];
        int count=0;
        for (int i=line.length()-1;i>=0;i--){
            int a=line.charAt(i)-'0';
            if (num[a]!=1){
                System.out.print(a);
                num[a]=1;
                count++;
                if (count==10)
                    break;
            }
        }
    }
}
