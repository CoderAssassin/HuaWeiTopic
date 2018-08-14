import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午9:27 18-8-14
 * （练习用）挑7：我的解法
 **/
public class T54 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int N=sc.nextInt();
            int res=0;
            String str="";
            for (int i=7;i<=N;i++){
                str=String.valueOf(i);
                if (str.contains("7")||i%7==0)
                    res++;
            }
            System.out.println(res);
        }
    }
}
