import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:22 18-8-16
 * 求最大连续bit数：我的解法
 **/
public class T85 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            boolean flag=false;
            int max=0,count=0;

            while (n>0){
                if (n%2==1){
                    flag=true;
                    count++;
                    if (count>max)
                        max=count;
                }else {
                    count=0;
                    flag=false;
                }
                n/=2;
            }
            System.out.println(max);
        }
    }
}
