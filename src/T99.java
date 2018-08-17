import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:09 18-8-17
 * 等差数列：我的解法
 **/
public class T99 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            if (n<1){
                System.out.println("-1");
                continue;
            }
            int first=2;
            int last=2+3*(n-1);
            System.out.println(n*first+3*n*(n-1)/2);
        }
    }
}
