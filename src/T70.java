import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午4:05 18-8-15
 * 字符串通配符：我的解法
 **/
public class T70 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String pattern=sc.nextLine();
            String str=sc.nextLine();

            if (judge(str,pattern,0,0))
                System.out.println("true");
            else System.out.println("false");
        }
    }

    private static boolean judge(String str,String pattern,int sIndex,int pIndex){

        if (sIndex==str.length()&&pIndex==pattern.length())
            return true;
        if (sIndex==str.length()||pIndex==pattern.length())
            return false;
        if (pattern.charAt(pIndex)=='*'){
//            while (pIndex<pattern.length()&&pattern.charAt(pIndex)=='*')
//                pIndex++;
            return judge(str,pattern,sIndex,pIndex+1)||judge(str,pattern,sIndex+1,pIndex+1);
        }else if (Character.toLowerCase(str.charAt(sIndex))==Character.toLowerCase(pattern.charAt(pIndex))||
                pattern.charAt(pIndex)=='?'){
            return judge(str,pattern,sIndex+1,pIndex+1);
        }
        return false;
    }
}
