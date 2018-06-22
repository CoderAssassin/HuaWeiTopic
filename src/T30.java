import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午10:44 18-6-22
 * 【中级】单词倒排：我的解法
 * 思路：从右到左
 **/
public class T30 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            StringBuilder res=new StringBuilder();
            StringBuilder sb=new StringBuilder();

            int i=str.length()-1;
            while (i>=0&&str.charAt(i)==' ')
                continue;

            for (;i>=0;i--){
                char c=str.charAt(i);
                if (c>='a'&&c<='z'||c>='A'&&c<='Z'){
                    sb.append(str.charAt(i));
                    if (i==0)
                        res.append(sb.reverse());
                }
                else {
                    res.append(sb.reverse());
                    res.append(" ");
                    while (i>=0&&!(str.charAt(i)>='a'&&str.charAt(i)<='z'||str.charAt(i)>='A'&&str.charAt(i)<='Z'))
                        i--;
                    i++;
                    sb=new StringBuilder();
                }
            }

            i=0;
            while (i<res.length()&&!(res.charAt(i)>='a'&&res.charAt(i)<='z'||res.charAt(i)>='A'&&res.charAt(i)<='Z'))
                i++;
            int j=res.length()-1;
            while (j>=i&&!(res.charAt(j)>='a'&&res.charAt(j)<='z'||res.charAt(j)>='A'&&res.charAt(j)<='Z'))
                j--;

            System.out.println(res.subSequence(i,j+1));
        }
    }
}
