import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:48 18-8-17
 * 记负均正：我的解法
 **/
public class T96 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            int neg=0;
            int avg=0;
            int posi=0;
            for (int i=0;i<n;i++){
                int tmp=sc.nextInt();
                if (tmp>0){
                    avg+=tmp;
                    posi++;
                }
                else if (tmp<0)
                    neg++;
            }
            System.out.print(neg+" ");
            System.out.format("%.1f",(double)avg/posi);
            System.out.println();
        }
    }
}
