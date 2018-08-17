import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:46 18-8-17
 * 字符串分割：我的解法
 **/
public class T103 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            sc.nextLine();
            for (int i=1;i<=n;i++){
                String str=sc.nextLine();
                while (str.length()/8>0){
                    System.out.println(str.substring(0,8));
                    str=str.substring(8);
                }
                if (str.length()!=0){
                    System.out.print(str);
                    for (int j=0;j<8-str.length();j++)
                        System.out.print("0");
                    System.out.println();
                }
            }
        }
    }
}
