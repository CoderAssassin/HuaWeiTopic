
import java.util.*;
/**
 * @Author:Aliyang
 * @Data: Created in 下午2:17 18-6-21
 * 数据分类处理：我的解法
 * 思路：题目贼长，跳过
 **/

public class T24 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int sum;
        String r1,r2;
        while(sc.hasNextLine()){
            sum = 0;
            String result = "";
            r1 = sc.nextLine();
            r2 = sc.nextLine();
            String[] r1t = r1.split(" ");
            String[] r2t = r2.split(" ");
            ArrayList<Integer> R = new ArrayList<Integer>();
            for(int i=1;i<r2t.length;i++){
                if(!R.contains(Integer.parseInt(r2t[i]))){
                    R.add(Integer.parseInt(r2t[i]));
                }
            }
            sort(R);
            String tmp;
            boolean flag = false;
            int num = 0;
            for(int i=0;i<R.size();i++){
                tmp = ""+R.get(i);
                flag = true;
                num = 0;
                String res = "";
                for(int j=1;j<r1t.length;j++){
                    if(r1t[j].contains(tmp)){
                        if(flag){
                            flag = false;
                            res += R.get(i)+" "+(j-1)+" "+r1t[j]+" ";
                            sum = sum +3;
                        }
                        else{
                            res += (j-1)+" "+r1t[j]+" ";
                            sum = sum +2;
                        }
                        num++;
                    }
                }
                if(!flag){
                    sum++;
                    result += res.substring(0,res.indexOf(" "))+" "+num+res.substring(res.indexOf(" "));
                }
            }
            result = sum+" "+result;
            System.out.println(result.substring(0,result.length()-1));
        }
        sc.close();
    }
    public static void sort (ArrayList<Integer> R){
        int tmp;
        for(int i=1;i<R.size();i++){
            tmp = R.get(i);
            int j=i-1;
            for(;j>=0 && R.get(j)>tmp;j--){
                R.set(j+1, R.get(j));
            }
            R.set(j+1, tmp);
        }
    }
}
