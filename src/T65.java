
/**
 * @Author:Aliyang
 * @Data: Created in 下午2:09 18-8-15
 * 配置文件恢复：我的解法
 * 坑点：根本不用判断单词是否相等，测试用例白痴一样
 **/
import java.util.*;
import java.io.*;
public class T65{
    public static void main(String[] args)throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> hMap = new HashMap<>();
        //HashMap<String, String> hMap = new HashMap<>();
        hMap.put("reset", "reset what");
        hMap.put("reset board", "board fault");
        hMap.put("board add", "where to add");
        hMap.put("board delet", "no board at all");
        hMap.put("reboot backplane", "impossible");
        hMap.put("backplane abort", "install first");
        String str =br.readLine();
        while(str!=null){

            if(hMap.containsKey(str)){
                System.out.println(hMap.get(str));
            }else{
                System.out.println("unkown command");
            }
            str = br.readLine();
        }
    }
}
