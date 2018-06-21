
import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 质数因子
 */
public class issue5 {

    private static void zhishu(long num){
        for (int i=2;i<=num;i++){
            if (num%i==0){
                if (judge(i)==true){
                    num=num/i;
                    System.out.print(i+" ");
                    i=1;
                }
            }
        }
    }
    private static boolean judge(int a){
        for (int i=2;i<Math.sqrt(a);i++){
            if (a%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long num=sc.nextLong();
        zhishu(num);
    }
}
