import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:27 18-6-21
 * 字符串排序：我的解法
 * 思路：输入按照26个字母顺序输入，然后将空格等字符位置腾出来
 **/
public class T25 {

//    public static void main(String[] args){
//
//        Scanner sc=new Scanner(System.in);
//        String strIn=sc.nextLine();
//        char[] str=strIn.toCharArray();
//
//        int i,j;
//        for (i=1;i<str.length;i++){//插排
//            char c=str[i];//当前字符
//            int others=0;
//            if (!(c>='a'&&c<='z'||c>='A'&&c<='Z')){//如果是字符，那么退位加
//                continue;
//            }
//            for (j=i-1;j>=0;j--){
//                char now=str[j];//对比的数
//                if (!(now>='a'&&now<='z'||now>='A'&&now<='Z')){//如果是字符，那么退位加1
//                    others++;
//                    continue;
//                }else {//如果比较的不是字符
//                    if (c>='a'&&c<='z'){//c是小写
//                        if (now>='a'&&now<='z'&&now>c){//比较的数也是小写
//                            str[j+1+others]=str[j];
//                        }else if (now>='A'&&now<='Z'&&c-32<now)//比较的数是大写
//                            str[j+1+others]=str[j];
//                        else break;
//                    }else {//c是大写
//                        if (now>='a'&&now<='z'&&now>c+32){
//                            str[j+1+others]=str[j];
//                        }else if (now>='A'&&now<='Z'&&c<now)
//                            str[j+1+others]=str[j];
//                        else break;
//                    }
//                }
//            }
//            str[j+1+others]=c;
//
//        }
//        System.out.println(Arrays.toString(str));
//    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str ="";
        while((str=bf.readLine())!=null){
            StringBuffer sb= new StringBuffer();
            for(int i=0;i<26;i++){
                char cha = (char)(i+'A');
                for(int j=0;j<str.length();j++){
                    char sc =str.charAt(j);
                    if(cha==sc||cha==sc-32){
                        sb.append(sc);
                    }
                }
            }


            for(int i=0;i<str.length();i++){
                char m = str.charAt(i);
                if(!(m>='a'&&m<='z')&&!(m>='A'&&m<='Z')){
                    sb.insert(i,m);//巧妙运用insert
                }
            }

            System.out.println(sb.toString());
        }
        bf.close();
    }
}
