import java.util.*;

/**
 * Created by AliYang on 2018/3/3.
 * 简单错误记录
 */
public class issue18 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Map<String,Integer> map=new LinkedHashMap<String,Integer>();
        while (sc.hasNext()){
            String line=sc.next();
            Set<String> keys=map.keySet();
            int lineNum=sc.nextInt();
            String file="";
            if (line.lastIndexOf('\\')<line.length()){
                file=line.substring(line.lastIndexOf('\\')+1,line.length());
            }else {
                file=line;
            }
            if (file.length()>16){
                file=file.substring(file.length()-16,file.length());
            }
            String saveName=file+"/"+lineNum;
            if (keys.contains(saveName)){
                map.put(saveName,map.get(saveName)+1);
            }else {
                map.put(saveName,1);
            }
        }
        sc.close();
        int mapLegth=map.size();
        Set<String> keys=map.keySet();
        int index=0;
        for (String k:keys){
            if (index>=mapLegth-8){
                System.out.println(k.split("/")[0]+" "+k.split("/")[1]+" "+map.get(k));
            }
            index++;
        }
    }
}
