package huawei;

import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午6:45 18-8-22
 **/
public class T3 {

//    public static void main(String[] args){
//        Scanner sc=new Scanner(System.in);
//        while (sc.hasNext()) {
//            String str = sc.nextLine();
//            if (str==null)
//                System.out.println(" 0");
//
//            int maxLen=0;
//            int start=0;
//            String result="";
//            for (int i=1;i<str.length();i++){
//                for (int j=0,tmpLen=0;j<str.length()-i;j++){
//                    if (str.charAt(j)==str.charAt(i+j))
//                        tmpLen++;
//                    else tmpLen=0;
//                    if (tmpLen>maxLen){
//                        maxLen=tmpLen;
//                        start=j-tmpLen+1;
//                    }
//                }
//                if (maxLen>=0)
//                    result=str.substring(start,start+maxLen);
//            }
//            if (maxLen<=3){
//                System.out.println(" "+0);
//            }else System.out.println(result+" "+result.length());
//        }
//    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            int len=str.length();
            List<String> arr=new ArrayList<>();
            for (int i=0;i<len;i++)
                arr.add(str.substring(i));

            Collections.sort(arr);

            int maxLen=0;
            int index=0;
            for (int i=0;i<arr.size()-1;i++){
                String s1=arr.get(i);
                String s2=arr.get(i+1);

                int count=0;
                for (int j=0;j<s1.length()&&j<s2.length();j++){
                    if (s1.charAt(j)==s2.charAt(j)){
                        count++;
                        if (count>maxLen){
                            maxLen=count;
                            index=i;
                        }
                    }else
                        break;
                }
            }

            if (maxLen==0)
                System.out.println(" 0");
            else {
                String res=arr.get(index).substring(0,maxLen);
                System.out.println(res+" "+res.length());
            }
        }
    }
}
