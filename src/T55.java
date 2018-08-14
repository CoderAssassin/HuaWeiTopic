import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:33 18-8-14
 * iNOC产品部--完全数计算：我的解法
 **/
public class T55 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int count=0;
            for (int i=2;i<=n;i++){
                if (isPerfect(i))
                    count++;
            }
            System.out.println(count);
        }
    }

    private static boolean isPerfect(int num){
        int res=1;
        for (int i=2;i<=Math.sqrt(num);i++){
            if (num%i==0){
                res+=i;
                if (i*i!=num)
                    res+=num/i;
            }
        }
        if (res==num)
            return true;
        else return false;
    }
}
