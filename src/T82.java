import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:50 18-8-16
 * 二维数组操作：我的解法
 * 坑点：根本不知道题目在说啥
 **/
public class T82 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int h=sc.nextInt(),l=sc.nextInt();
            if (h>9||l>9)
                System.out.println("-1");
            else System.out.println("0");
            int c1h,c1l,c2h,c2l;
            c1h=sc.nextInt();
            c1l=sc.nextInt();
            c2h=sc.nextInt();
            c2l=sc.nextInt();
            if(c1h>=0 && c1h<h && c1l>=0 && c1l<l && c2h>=0 && c2h<h &&c2l>=0 && c2l<l )
                System.out.println("0");
            else System.out.println("-1");
            int d,e;
            d=sc.nextInt();
            e=sc.nextInt();
            if (d>=0&&d<h)
                System.out.println("0");
            else System.out.println("-1");
            if (e>=0&&e<l)
                System.out.println("0");
            else System.out.println(-1);
            int m,n;
            m=sc.nextInt();
            n=sc.nextInt();
            if(m>=0 &&m<h && n>=0 && n<l)
                System.out.println("0");
            else System.out.println("-1");
        }
    }
}
