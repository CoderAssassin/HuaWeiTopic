import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午9:58 18-8-15
 * 找出字符串中第一个只出现一次的字符(题面已经更新)：我的解法
 **/
public class T58 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String str=sc.nextLine();
            Map<Character,Integer> map=new LinkedHashMap<>();
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if (!map.containsKey(c))
                    map.put(c,1);
                else map.put(c,map.get(c)+1);
            }

            boolean flag=false;
            for (Map.Entry e:map.entrySet()){
                if ((int)e.getValue()==1){
                    System.out.println(e.getKey());
                    flag=true;
                    break;
                }
            }
            if (!flag)
                System.out.println(-1);
        }
    }
}
