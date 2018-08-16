import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:06 18-8-16
 * 统计大写字母个数：我的解法
 **/
public class T83 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            int count=0;
            for (int i=0;i<str.length();i++)
                if (str.charAt(i)>='A'&&str.charAt(i)<='Z')
                    count++;
            System.out.println(count);
        }
    }
}
