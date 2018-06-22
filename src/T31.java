import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:00 18-6-22
 * 字符串运用-密码截取：我的解法
 **/
public class T31 {

//    思路一：就是找最长回文串，从每个数开始，分成奇数和偶数串，向左右两边延伸开来寻找。复杂度O(n^2)
//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//
//        while (sc.hasNext()){
//            String str=sc.nextLine();
//            int max=0;
////            遍历每个数，判断最长回文串
//            for (int i=0;i<str.length();i++){
//
////                奇数长度的情况
//                int left=i-1,right=i+1;
//                while (left>=0&&right<str.length()){
//                    if (str.charAt(left)!=str.charAt(right)){
//                        break;
//                    }
//                    left--;
//                    right++;
//                }
//                max=Math.max(max,right-left-1);
//
////                偶数长度的情况
//                left=i;
//                right=i+1;
//                while (left>=0&&right<str.length()){
//                    if (str.charAt(left)!=str.charAt(right)){
//                        break;
//                    }
//                    left--;
//                    right++;
//                }
//                max=Math.max(max,right-left-1);
//            }
//            System.out.println(max);
//        }
//    }

//    思路二：马拉车算法，复杂度O(n)。但是实测效率更低，不知为啥

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s=sc.nextLine();
            System.out.println(manacher(s));
        }
    }

    private static int manacher(String s){

//        第一步：改造字符串
        StringBuilder res=new StringBuilder();
        res.append("$#");//防止越界，头加个#
        for (int i=0;i<s.length();i++)
            res.append(s.charAt(i)+"#");
        res.append("%");

        int[] P=new int[res.length()];//记录当前字符的回文串半径（包含自身）
        int mi=0,right=0;//mi为前面最右的最大回文串的中心点，right为回文串能达到的最右端的值
        int maxLen=0;//分别为最大回文串的长度和记录的中心点

        String str=res.toString();
        for (int i=1;i<str.length()-1;i++){

            P[i]=right>i?Math.min(P[2*mi-i],right-i):1;//P[2*mi-i]是和i处对称的位置j的最大回文串的半径

            while (str.charAt(i+P[i])==str.charAt(i-P[i]))//往左右继续延伸
                P[i]++;

            if (right<i+P[i]){//如果超过了前面的最有端，那么将中心点和对应的最右端更新
                right=i+P[i];
                mi=i;
            }

            if (maxLen<P[i]){//更新最大回文半径，标记中心点
                maxLen=P[i];
            }
        }

        return maxLen-1;//P[i]-1为回文串的长度
    }
}
