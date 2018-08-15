import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午5:42 18-8-15
 * 计算日期到天数转换：我的解法
 **/
public class T72 {

    private static final int[] days={31,28,31,30,31,30,31,31,30,31,30,31};
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int year=sc.nextInt();
            int month=sc.nextInt();
            int day=sc.nextInt();

            boolean isRun=false;
            if ((year%4==0)&&((year%100!=0)||(year%400!=0)))
                isRun=true;

            int res=0;
            for (int i=1;i<month;i++)
                res+=days[i-1];
            res+=day;
            if (isRun)
                System.out.println(res+1);
            else System.out.println(res);
        }
    }
}
