import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by AliYang on 2018/3/2.
 * 合并表记录
 */
public class issue7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
        String line="";
        while (t>0&&(line=br.readLine())!=null){
            String[] lines=line.split(" ");
            int key=Integer.parseInt(lines[0]);
            int value=Integer.parseInt(lines[1]);
            Set<Integer> set=map.keySet();
            if (set.contains(key))
                map.put(key,map.get(key)+value);
            else map.put(key,value);
            t--;
        }
        Set<Integer> set=map.keySet();
        for (Integer i:set){
            System.out.println(i+" "+map.get(i));
        }

        br.close();
    }
}
