import java.io.IOException;
import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/3.
 * 密码验证合格程序
 */
public class issue19 {

//    其实就是计算KMP的next[length-1]是否大于2
//    private static boolean nextOfKMP(String str){
//        char[] c=str.toCharArray();
//        int[] next=new int[100];
//        int k=-1;
//        next[0]=-1;
//        for (int i=1;i<c.length;i++){
//            while (k>-1&&c[k+1]!=c[i]){//回溯
//                next[i]=next[k];
//            }
//            if (c[k+1]==c[i]){
//                k=k+1;
//            }
//            next[i]=k;
//            if (k>=2) return true;
//        }
//        return false;
//    }
    public static boolean nextOfKMP(String str){
        char[] c=str.toCharArray();
        for (int i=0;i<=str.length()-6;i++){
            for (int j=i+3;j<=str.length()-3;j++){
                if (c[i] == c[j] && c[i+1] == c[j+1] &&c[i+2] == c[j+2])
                    return true;
                }
            }
        return false;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String line=sc.nextLine();
            if (line.length()<9||line==null){//如果长度小于8位则不合格
                System.out.println("NG" );
                continue;
            }
            int[] type=new int[4];//记录符号种类数，分别是大写、小写、数字、其他符号
            char[] c=line.toCharArray();
            for (int i=0;i<line.length();i++){
                if (c[i] >= '0' && c[i] <= '9')
                    type[2]=1;
                else if (c[i]>='a'&&c[i]<='z')
                    type[1]=1;
                else if (c[i]>='A'&&c[i]<='Z')
                    type[0]=1;
                else type[3]=1;
            }
            int typeCount=0;
            for (int i=0;i<4;i++){//如果出现的符号种类小于3，那么直接排除掉
                if (type[i]==1)
                    typeCount++;
            }
            if (typeCount<3){
                System.out.println("NG");
                continue;
            }

//            利用KMP的next数组来判断，不同的是这里需要每个子串进行判断一下
            while (line.length()>2){
                if (nextOfKMP(line)==true){
                    System.out.println("NG");
                    break;
                }
                line=line.substring(1,line.length());
            }
            if (line.length()<=2) System.out.println("OK");
        }
        sc.close();
    }
}
