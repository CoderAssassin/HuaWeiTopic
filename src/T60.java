import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:13 18-8-15
 * 放苹果：别人解法
 * 思路：分为将m个苹果放到所有的盘子里和至少有一个盘子为空，当放到所有的盘子里，那么递归调用剩下的apple(m-n,n)；如果至少有一个盘子为空，那么调用
 * apple(m,n-1)，表示逐个减少盘子数
 **/
public class T60 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int m=sc.nextInt();
            int n=sc.nextInt();
            System.out.println(apple(m,n));
        }
    }

    private static int apple(int m,int n){
        if (m<0)
            return 0;
        if (m==1||n==1)
            return 1;
        return apple(m,n-1)+apple(m-n,n);
    }
}
