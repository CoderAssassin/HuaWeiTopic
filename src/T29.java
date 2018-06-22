import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:19 18-6-22
 * 字符串合并处理：我的解法
 * 思路：排序用的希尔
 **/
public class T29 {

    private static String ProcessString(String str1,String str2) {

        int len1=str1.length();
        int len2=str2.length();

        char[] strOutput=(str1+str2).toCharArray();

//        类似希尔排序
        for (int i=2;i<len1+len2;i+=2){
            int tmpI=i-2;
            char swap=strOutput[i];
            while (tmpI>=0){//偶数排序
                if (strOutput[tmpI]>swap){
                    strOutput[tmpI+2]=strOutput[tmpI];
                }else break;
                tmpI-=2;
            }
            strOutput[tmpI+2]=swap;
        }

        for (int i=3;i<len1+len2;i+=2){
            int tmpI=i-2;
            char swap=strOutput[i];
            while (tmpI>=1){//偶数排序
                if (strOutput[tmpI]>swap){
                    strOutput[tmpI+2]=strOutput[tmpI];
                }else break;
                tmpI-=2;
            }
            strOutput[tmpI+2]=swap;
        }

//        接下来进行转换
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<strOutput.length;i++){
            char c=strOutput[i];
            if (c>='0'&&c<='9'||c>='A'&&c<='F'||c>='a'&&c<='f'){
                String bStr = "0000" + Integer.toBinaryString(Integer.valueOf(c + "", 16));//转成8位二进制
                bStr = bStr.substring(bStr.length() - 4);//取后4位
                String oxStr = "";
                for (int j = bStr.length() - 1; j >= 0; j--)//倒一下
                    oxStr += bStr.charAt(j);
                String res = Integer.toHexString(Integer.parseInt(oxStr, 2)).toUpperCase();//先根据基数为二进制转成正数再转成16进制再转成大写
                sb.append(res);
            }else sb.append(c);
        }
        return sb.toString();
    }

//    字符转换
    private static char change(char c){
        int value=-1;
        if (c>='0'&&c<='9')
            value=c-'0';
        else if (c>='A'&&c<='F')
            value=c-'A'+10;
        else value=c-'a'+10;

        int res=0;
        while (value!=0){
            int mod=value%2;
            res=res*2+mod;
            value/=2;
        }
        if (res>=10&&res<=15)
            return (char)(res-10+'A');
        else return (char)(res+'0');
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str1=sc.next();
            String str2=sc.next();

            System.out.println(ProcessString(str1,str2));
        }

    }
}
