import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:54 18-8-15
 * 百钱买百鸡问题：我的解法
 **/
public class T71 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            sc.nextInt();
            for (int x=0;x<=20;x++){
                double y=(200-14*x)/8.0;
                double z=100-y-x;
                if (y==(int)(y)&&y>=0&&z>=0)
                    System.out.print(x+" "+(int) y+" "+(int) z+"\n");
            }
        }
    }
}
