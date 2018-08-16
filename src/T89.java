import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:43 18-8-16
 * 合法IP：我的解法
 **/
public class T89 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            String[] ips=str.split("\\.");
            boolean flag=false;
            for (int i=0;i<ips.length;i++){
                if (Integer.parseInt(ips[i])<0||Integer.parseInt(ips[i])>255){
                    System.out.println("NO");
                    flag=true;
                    break;
                }
            }
            if (!flag)
                System.out.println("YES");
        }
    }
}
