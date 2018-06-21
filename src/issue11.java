import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 数字颠倒
 */
public class issue11 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        for (int i=line.length()-1;i>=0;i--){
            System.out.print(line.charAt(i));
        }
    }
}
