import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:09 18-8-17
 * 求解立方根：别人解法
 **/
public class T106 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            double num=sc.nextDouble();
            System.out.format("%.1f",newton(num));
            System.out.println();
        }

    }

    private static double newton(double y){
        double x;
        for (x=1.0;Math.abs(x*x*x-y)>1e-7;x=(2*x+y/x/x)/3);
        return x;
    }
}
