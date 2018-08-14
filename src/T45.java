import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:26 18-8-14
 * 按字节截取字符串：我的解法
 **/
public class T45 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str=bf.readLine())!=null){
            String[] tmp=str.split(" ");
            String chars=tmp[0];
            int len=Integer.parseInt(tmp[1]);

            int count=0,i=0;
            for (;i<chars.length();i++){
                char c=chars.charAt(i);
                if (c>='a'&&c<='z'||c>='A'&&c<='Z')
                    count+=1;
                else count+=2;
                if (count>len) {
                    break;
                }
            }
            System.out.println(chars.substring(0,i));
        }
        bf.close();
    }
}
