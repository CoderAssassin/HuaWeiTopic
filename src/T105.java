import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:05 18-8-17
 * 字符逆序：我的解法
 **/
public class T105 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] strs=str.split(" ");
            for (int i=strs.length-1;i>=0;i--){
                if (i!=strs.length-1)
                    System.out.print(" ");
                String a=strs[i];
                for (int j=a.length()-1;j>=0;j--)
                    System.out.print(a.charAt(j));
            }
            System.out.println();
        }
    }
}
