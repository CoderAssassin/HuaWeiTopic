import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:39 18-8-14
 * 无线OSS－高精度整数加法：我的解法
 **/
public class T56 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.next();
            String str2=sc.next();
            BigInteger num1=new BigInteger(str1);
            BigInteger num2=new BigInteger(str2);
            System.out.println(num1.add(num2));
        }
    }
}
