import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 求int型正整数在内存中存储时1的个数
 */
public class issue14 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int num=sc.nextInt();
        int count=0;
        while (num>0){
            if (num%2==1)
                count++;
            num/=2;
        }
        System.out.println(count);
    }
}
