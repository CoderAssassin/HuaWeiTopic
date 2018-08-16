import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:45 18-8-16
 * 整形数组合并：我的解法
 **/
public class T79 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            TreeSet<Integer> set=new TreeSet<>();
            int len1=sc.nextInt();
            for (int i=0;i<len1;i++)
                set.add(sc.nextInt());
            int len2=sc.nextInt();
            for (int i=0;i<len2;i++)
                set.add(sc.nextInt());

            String res="";
            for (Integer num:set)
                res+=num;
            System.out.println(res);
        }
    }
}
