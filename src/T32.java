import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:58 18-6-22
 * 整数与IP地址间的转换：我的解法
 * 思路：字符串转整形，每8位为一个串，然后转成整数；整形转字符串，先转换成二进制的字符串(这里模拟二进制的运算顺序)，然后转成整形
 * 注意点：要用long，否则溢出
 **/
public class T32 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String ip=sc.nextLine();//输入字符串的ip地址
            String ip1=sc.nextLine();//输入十进制的ip地址
            long ip_ten=Long.valueOf(ip1);

            System.out.println(string2Long(ip));
            System.out.println(long2String(ip_ten));
        }
    }

//    字符串转长整形
    private static Long string2Long(String ip){
        String[] ips=ip.split("\\.");
        StringBuilder sb=new StringBuilder(32);
        for (int i=0;i<ips.length;i++){
            String tmp=Integer.toBinaryString(Integer.valueOf(ips[i]));
            for (int j=0;j<8-tmp.length();j++)//补0
                sb.append("0");
            sb.append(tmp);
        }

        return Long.valueOf(sb.toString(),2);
    }

//    长整形转字符串ip地址
    private static String long2String(Long ip){
        StringBuilder sb=new StringBuilder();
        while (ip!=0){
            sb.append(ip%2);
            ip/=2;
        }
        int len=32-sb.length();
        for (int i=0;i<len;i++)
            sb.append("0");
        sb.reverse();
        String str=sb.toString();
        int index=0;
        StringBuilder res=new StringBuilder();
        while (str.length()>=8){
            String tmp=str.substring(0,8);
            res.append(Integer.parseInt(tmp,2));
            res.append(".");
            index++;
            str=str.substring(8,str.length());
        }
        return res.toString().substring(0,res.length()-1);
    }
}
