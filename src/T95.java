import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午1:38 18-8-17
 * 表示数字：我的解法
 **/
public class T95 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            StringBuilder sb=new StringBuilder();

            for (int i=0;i<str.length();i++){
                if (!(str.charAt(i)>='0'&&str.charAt(i)<='9'))
                    sb.append(str.charAt(i));
                else{
                    sb.append("*");
                    while (i<str.length()&&str.charAt(i)>='0'&&str.charAt(i)<='9'){
                        sb.append(str.charAt(i));
                        i++;
                    }
                    sb.append("*");
                    i--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
