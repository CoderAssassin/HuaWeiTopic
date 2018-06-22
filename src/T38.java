import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午2:13 18-6-22
 * 判断两个IP是否属于同一子网：我的解法
 * 注意：sb一样的题，测试样例有问题没通过
 **/
public class T38 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        cont:
        while (sc.hasNext()){
            String[] mask=sc.next().split("\\.");
            String[] ip1=sc.next().split("\\.");
            String[] ip2=sc.next().split("\\.");

            if (ip1.length!=4||ip2.length!=4){
                System.out.println(1);
                continue cont;
            }
//            先判断地址都是否正确
            if (!judge(mask)||!judge(ip1)||!judge(ip2)){
                System.out.println(1);
                continue cont;
            }

            long mask_int=string2Long(mask);
            long ip1_int=string2Long(ip1);
            long ip2_int=string2Long(ip2);

            if ((mask_int&ip1_int)==(mask_int&ip2_int))
                System.out.println(0);
            else System.out.println(2);
        }
    }

    private static boolean judge(String[] ip){
        for (int i=0;i<ip.length;i++){
            int num=Integer.parseInt(ip[i]);
            if (num<0||num>255)
                return false;
        }
        return true;
    }

    //    字符串转长整形
    private static Long string2Long(String[] ips){
        StringBuilder sb=new StringBuilder(32);
        for (int i=0;i<ips.length;i++){
            String tmp=Integer.toBinaryString(Integer.valueOf(ips[i]));
            for (int j=0;j<8-tmp.length();j++)//补0
                sb.append("0");
            sb.append(tmp);
        }

        return Long.valueOf(sb.toString(),2);
    }
}
