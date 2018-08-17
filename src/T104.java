import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:00 18-8-17
 * 记负均正II：我的解法
 **/
public class T104 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int neg=0;
        int posi=0;
        int sum=0;
        while (sc.hasNext()){
            int num=sc.nextInt();
            if (num>0){
                posi++;
                sum+=num;
            }else if (num<0)
                neg++;
        }
        double average = 1.0*sum/posi;
        System.out.println(neg);
        System.out.printf("%.1f\n",average);
    }
}
