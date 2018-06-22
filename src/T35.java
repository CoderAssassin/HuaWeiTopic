import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:59 18-6-22
 * 字符串加密：我的解法
 * 思路：先去重，再生成对照表，这里是小写，然后一一对照
 **/
public class T35 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String key=sc.nextLine();
            String str=sc.nextLine();

            key=key.toLowerCase();//先统一转换成小写
//            key去重
            Set<Character> set=new HashSet<>();
            String realKey="";
            for (int i=0;i<key.length();i++){
                char c=key.charAt(i);
                if (!set.contains(c)){
                    realKey+=c;
                    set.add(c);
                }
            }
//            生成对照密文，都是小写
            for (int i=0;i<26;i++){
                char c=(char)('a'+i);
                if (!set.contains((char)('a'+i)))
                    realKey+=c;
            }
//            加密
            String res="";
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if (c>='a'&&c<='z'){
                    res+=realKey.charAt(c-'a');
                }else {
                    res+=(char)(realKey.charAt(c-'A')+32);
                }
            }
            System.out.println(res);
        }
    }
}
