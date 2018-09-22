package huawei;

import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:43 18-8-22
 * BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
 **/
public class T1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            double yuanjia=sc.nextDouble();

            double sum_1=0;
            double sum_2=0;

            sum_1+=num*yuanjia;
            if (num>=3){
                sum_1*=0.7;
                sum_1+=10;
                if (sum_1>=50)
                    sum_1-=10;
            }else {
                sum_1+=10;
                if (sum_1>=50)
                    sum_1-=10;
            }

            sum_2=num*yuanjia;
            int count=(int)sum_2/10;
            sum_2=sum_2+6;
            sum_2-=2*count;

            if (sum_2>=99)
                sum_2-=6;


            if (sum_1>sum_2){
                System.out.println(2);
            }else if (sum_1<sum_2){
                System.out.println(1);
            }else System.out.println(0);
        }
    }
}
