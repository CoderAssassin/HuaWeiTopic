import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/3.
 * 汽水瓶
 */
public class issue21 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int res=0;
            if (n==0) break;
            int a,b;
            res=0;
            while (n>2){
                a=n/3;
                b=n%3;
                res+=a;
                n=a+b;
                }
            if (n==2) res++;
            System.out.println(res);
        }
        sc.close();
    }
}
