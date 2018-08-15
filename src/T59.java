import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:07 18-8-15
 * 查找组成一个偶数最接近的两个素数：我的解法
 **/
public class T59 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            int left=num/2,right=num/2;

            while (left>=2&&right<=num){

                while (!isSushu(left))
                    left--;
                while (!isSushu(right))
                    right++;
                if (left+right==num){
                    System.out.println(left+"\n"+right);
                    break;
                }
                if (left+right>num)
                    left--;
                if (left+right<num)
                    right++;
            }
        }
    }

    private static boolean isSushu(int num){

        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0)
                return false;
        }
        return true;
    }
}
