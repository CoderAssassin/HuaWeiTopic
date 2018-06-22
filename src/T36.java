import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:19 18-6-22
 * 统计每个月兔子的总数：我的解法
 * 思路：找规律，每个月的增量为0,0,1,1,2,3，。。。也就是incre[i]=incre[i-1]+incre[i-2]，类似斐波那契
 **/
public class T36 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int month=sc.nextInt();
            if (month<=2){
                System.out.println(1);
                continue;
            }
            int rabbit=1;
            int res=1;
            int[] incre=new int[month+2];
            incre[3]=1;
            for (int i=3;i<=month;i++){
                res+=incre[i];
                incre[i+1]=incre[i-1]+incre[i];
            }
            System.out.println(res);
        }
    }
}
