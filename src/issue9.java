import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/2.
 * 字符个数统计
 */
public class issue9 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String line=sc.nextLine();
        int count=0;
        int[] judge=new int[128];
        for (int i=0;i<line.length();i++){
            int c=line.charAt(i);
            if (!(c>=0&&c<=127)) continue;
            if (judge[c]==0){
                judge[c]=1;
                count++;
            }
        }
        System.out.println(count);
    }
}
