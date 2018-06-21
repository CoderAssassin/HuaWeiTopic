import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 进制转换
 */
public class issue4 {

    private static int exchange(String number){
        int res=0;
        for (int i=0;i<number.length();i++){
            int base;
            char c=number.charAt(i);
            if (c>='0'&&c<='9')
                base=c-'0';
            else base=c-'A'+10;
            res+=base*cifang(number.length()-i-1);
        }
        return res;
    }
    private static int cifang(int n){
        int res=1;
        while (n>0){
            res*=16;
            n--;
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String line=sc.nextLine();
            line=line.substring(2,line.length());
            System.out.println(exchange(line));
        }
    }
}
