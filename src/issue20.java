import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/3.
 * 简单密码
 */
public class issue20 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String line=sc.nextLine();
            char[] c=line.toCharArray();
            for (int i=0;i<c.length;i++){
                if (c[i]>='A'&&c[i]<='Z'){
                    c[i]=(char)(c[i]+33);
                    if (c[i]>'z')
                        c[i]='a';
                }else if (c[i]>='a'&&c[i]<='z'){
                    if (c[i]=='a'||c[i]=='b'||c[i]=='c')
                        c[i]='2';
                    else if (c[i]=='d'||c[i]=='e'||c[i]=='f')
                        c[i]='3';
                    else if (c[i]=='g'||c[i]=='h'||c[i]=='i')
                        c[i]='4';
                    else if (c[i]=='j'||c[i]=='k'||c[i]=='l')
                        c[i]='5';
                    else if (c[i]=='m'||c[i]=='n'||c[i]=='o')
                        c[i]='6';
                    else if (c[i]=='p'||c[i]=='q'||c[i]=='r'||c[i]=='s')
                        c[i]='7';
                    else if (c[i]=='t'||c[i]=='u'||c[i]=='v')
                        c[i]='8';
                    else c[i]='9';
                }
            }
            for (int i=0;i<c.length;i++)
                System.out.print(c[i]);
            System.out.println();
        }
        sc.close();
    }
}
