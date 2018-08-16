import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:49 18-8-16
 * 字符串匹配：我的解法
 **/
public class T80 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.nextLine();
            String str2=sc.nextLine();

            int[] chars=new int[128];

            if (str1.length()<=str2.length()){
                if (judge(str1,str2,chars))
                    System.out.println("true");
                else System.out.println("false");
            }else {
                if (judge(str2,str1,chars))
                    System.out.println("true");
                else System.out.println("false");
            }
        }

    }

    private static boolean judge(String str1,String str2,int[] chars){

        for (int i=0;i<str2.length();i++)
            chars[str2.charAt(i)]++;

        for (int i=0;i<str1.length();i++)
            if (chars[str1.charAt(i)]==0)
                return false;

        return true;
    }
}
