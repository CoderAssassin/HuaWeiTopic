import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:40 18-8-15
 * 查找输入整数二进制中1的个数：我的解法
 **/
public class T61 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
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
}
