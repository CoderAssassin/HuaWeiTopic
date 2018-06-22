import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:53 18-6-22
 * 求小球落地5次后所经历的路程和第5次反弹的高度：我的解法
 * 思路：除了第一次，后边都是
 * 注意：题目测试数据很有问题，废弃该题
 **/
public class T37 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            double height=sc.nextDouble();
            double res=0;
            for (int i=0;i<5;i++){
                res+=height+(height/=2);
            }
            res-=height;
            System.out.println(res);
            System.out.println(height);
        }
    }
}
