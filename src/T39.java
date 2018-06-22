import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:45 18-6-22
 * 输入一行字符，分别统计出包含英文字母、空格、数字和其它字符的个数
 * 返回全部题目:我的解法
 **/
public class T39 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){

            String str=sc.nextLine();
            int english=0,space=0,nums=0,others=0;
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if (c>='a'&&c<='z'||c>='A'&&c<='Z')
                    english++;
                else if (c>='0'&&c<='9')
                    nums++;
                else if (c==' ')
                    space++;
                else others++;
            }
            System.out.println(english+"\n"+space+"\n"+nums+"\n"+others;
        }

    }
}
