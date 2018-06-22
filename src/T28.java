import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:05 18-6-22
 * 字符串加解密：我的解法
 * 思路：简单
 **/
public class T28 {

    private static void Encrypt (char aucPassword[], char aucResult[]){

        if (aucPassword==null||aucPassword.length==0)
            return;

        for (int i=0;i<aucPassword.length;i++){
            char c=aucPassword[i];
            if (c>='a'&&c<='z'){
                if (c!='z')
                    c=(char)(c+1-32);
                else c='A';
            }else if (c>='A'&&c<='Z'){
                if (c!='Z')
                    c=(char)(c+1+32);
                else c='a';
            }else {
                if (c!='9')
                    c=(char) (c+1);
                else c='0';
            }
            aucResult[i]=c;
        }
    }

    private static void unEncrypt (char result[], char password[]){

        if (result==null||result.length==0)
            return;

        for (int i=0;i<result.length;i++){
            char c=result[i];
            if (c>='a'&&c<='z'){
                if (c!='a')
                    c=(char)(c-1-32);
                else c='Z';
            }else if (c>='A'&&c<='Z'){
                if (c!='A')
                    c=(char)(c-1+32);
                else c='z';
            }else {
                if (c!='0')
                    c=(char) (c-1);
                else c='9';
            }
            password[i]=c;
        }

    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String unEncode=sc.nextLine();
            String Encode=sc.nextLine();
            char[] result=new char[unEncode.length()];
            Encrypt(unEncode.toCharArray(),result);
            System.out.println(String.valueOf(result));
            result=new char[Encode.length()];
            unEncrypt(Encode.toCharArray(),result);
            System.out.println(String.valueOf(result));
        }
    }
}
