import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:40 18-8-14
 * 名字的漂亮度：我的解法
 **/
public class T44 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){//可能有多组数据，必须加上这个while，不然不通过
            int N=sc.nextInt();
            for (int j=0;j<N;j++){
                String str=sc.next();
                int[] a=new int[26];//对应26个字母
                for (int i=0;i<str.length();i++){
                    char c=str.charAt(i);
                    if (c>='a'&&c<='z')
                        a[c-'a']++;
                    else if (c>='A'&&c<='Z')
                        a[c-'A']++;
                }
                Arrays.sort(a);
                int score=26;
                int res=0;
                for (int i=25;i>=0;i--)
                    res+=a[i]*score--;
                System.out.println(res);
            }
        }
    }
}
