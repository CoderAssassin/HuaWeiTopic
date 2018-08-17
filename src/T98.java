import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:02 18-8-17
 * 自守数：我的解法
 **/
public class T98 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int count=0;
            for (int i=0;i<=n;i++){
                String num=String.valueOf(i);
                long res=i*i;
                String num1=String.valueOf(res);
                int len=num.length(),len1=num1.length();
                if (num.equals(num1.substring(len1-len,len1)))
                    count++;
            }
            System.out.println(count);
        }
    }
}
