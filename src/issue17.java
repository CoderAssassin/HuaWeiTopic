import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by AliYang on 2018/3/3.
 * 识别有效的IP地址和掩码并进行分类统计
 */
public class issue17 {

//    判断格式是否正确
    private static boolean isFormatValid(String s){
        Pattern pattern=Pattern.compile("^(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)$");
        Matcher matcher=pattern.matcher(s);

        if(matcher.matches()){
            String[] nums=s.split("\\.");
            for (int i=0;i<nums.length;i++) {
                int number = Integer.parseInt(nums[i]);
                if (number < 0 || number > 255) {
                    return false;
                }
            }
        }else return false;
        return true;
    }
//    判断子网掩码是否正确
    private static boolean isMaskValid(String s){
        String[] tmp=s.split("\\.");
        StringBuilder sb=new StringBuilder();

        for (int i=0;i<4;i++){
            int n=Integer.parseInt(tmp[i]);
            sb.append(converseToBinary(n));
        }
        int first=sb.indexOf("0");
        int last=sb.lastIndexOf("1");
        if(first<last)
            return false;
        return true;
    }

//    将整数转换成对应的二进制字符串
    private static String converseToBinary(int num){
        StringBuilder sb=new StringBuilder();
        int flag=1<<7;//每次检验第一位
        for (int i=0;i<8;i++){
            int val=(flag&num)==0?0:1;
            sb.append(val);
            num<<=1;
        }
        return sb.toString();
    }
    public static void main(String[] args) throws IOException {
//        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        String line="";
        int A=0,B=0,C=0,D=0,E=0,erro=0,pri=0;
//        while ((line=br.readLine())!=null){
        while (sc.hasNext()){
            line=sc.nextLine();
            String ip=line.split("~")[0],
                    mask=line.split("~")[1];
//            如果格式不对，直接输出错误
            if (isFormatValid(ip)==false||isFormatValid(mask)==false){
                erro++;
                continue;
            }
//            若掩码地址正确，接下来对ip进行分类
            if (isMaskValid(mask)==true){
                String[] ips=ip.split("\\.");
                int first=Integer.parseInt(ips[0]);
                int second=Integer.parseInt(ips[1]);
                if (first!=0&&first!=127){
                    if (first>=1&&first<=126){
                        A++;
                        if(first==10)
                            pri++;
                    }
                    else if (first>=128&&first<=191){
                        B++;
                        if (first==172&&second>=16&&second<=31)
                            pri++;
                    }
                    else if (first>=192&&first<=223){
                        C++;
                        if (first==192&&second==168)
                            pri++;
                    }
                    else if (first>=224&&first<=239)
                        D++;
                    else if (first>=240&&first<=255)
                        E++;
                }
            }else {
                erro++;
            }
        }
        sc.close();
        System.out.println(A+" "+B+" "+C+" "+D+" "+E+" "+erro+" "+pri);
    }
}
