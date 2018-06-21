import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by AliYang on 2018/3/3.
 * 删除字符串中出现次数最少的字符
 */
public class issue22 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int[] charactor=new int[26];
            String line=sc.nextLine();
            char[] c=line.toCharArray();
            for (int i=0;i<c.length;i++){
                charactor[c[i]-'a']++;
            }
            int min=Integer.MAX_VALUE;
            for (int i=0;i<26;i++){
                if (charactor[i]!=0&&charactor[i]<min){
                    min=charactor[i];
                }
            }
            Set s=new HashSet();
            for (int i=0;i<26;i++){
                if (min==charactor[i]){
                    s.add((char)('a'+i));
                }
            }
            for (int i=0;i<c.length;i++){
                if (!s.contains(c[i]))
                    System.out.print(c[i]);
            }
            System.out.println();
        }
        sc.close();
    }
}
