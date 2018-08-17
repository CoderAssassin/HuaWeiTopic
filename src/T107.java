import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:23 18-8-17
 * 求最小公倍数：我的解法
 **/
public class T107 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();

            System.out.println(a*b/gcd(a,b));
        }
    }

    private static int gcd(int a,int b){
        while (a%b>0){
            int tmp=a;
            a=b;
            b=tmp%b;
        }
        return b;
    }
}
