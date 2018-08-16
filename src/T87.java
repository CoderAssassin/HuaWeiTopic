import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:30 18-8-16
 * 扑克牌大小：我的解法
 **/
public class T87 {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            String str=scanner.nextLine();
            String[] split = str.split("-");
            String str1=split[0];
            String str2=split[1];
            System.out.println(getResult(str1,str2));
        }

    }
    private static String getResult(String str1, String str2) {
        String[] split1 = str1.split(" ");
        String[] split2 = str2.split(" ");
        if (split1.length!=split2.length&&isBoom(split1)==false&&isBoom(split2)==false) {
            return "ERROR";
        }
        boolean isFirLargest = false;
        //单张
        if (split1.length==1&&split2.length==1) {
            //true代表第一个大，false代表第二个大
            isFirLargest = Ismatch(split1[0],split2[0]);
        }else if (split1.length==2&&split2.length==2) {
            isFirLargest = Ismatch(split1[0],split2[0]);
        }else if (split1.length==3&&split2.length==3) {
            isFirLargest = Ismatch(split1[0],split2[0]);
        }else if (split1.length==5&&split2.length==5) {
            isFirLargest = Ismatch(split1[0],split2[0]);
        }else if (isBoom(split1)==false&&isBoom(split2)==true) {
            isFirLargest=false;
        }else if (isBoom(split2)==false&&isBoom(split1)==true) {
            isFirLargest=true;
        }else if (isBoom(split1)==true&&isBoom(split2)==true) {
            isFirLargest = Ismatch(split1[0],split2[0]);
        }
        String result="";
        if (isFirLargest) {
            result=str1;
        }else {
            result=str2;
        }
        return result;
    }
    private static boolean Ismatch(String str1, String str2) {
        String [] strings=new String[]{
                "3","4","5", "6", "7" ,"8" ,"9","10","J","Q","K","A","2","joker","JOKER"
        };
        int index1=0;
        int index2=0;
        for (int i = 0; i < strings.length; i++) {
            if (str1.equals(strings[i])) {
                index1=i;
            }
        }
        for (int i = 0; i < strings.length; i++) {
            if (str2.equals(strings[i])) {
                index2=i;
            }
        }
        if (index1>=index2) {
            return true;
        }else {
            return false;
        }
    }
    private static boolean isBoom(String[] split) {
        if (split.length==4) {
            if (split[0].equals(split[1])&&split[1].equals(split[2])&&split[2].equals(split[3])) {
                return true;
            }
        }else if (split.length==2) {
            if (split[0].equals("joker")&&split[1].equals("JOKER")) {
                return true;
            }
        }else {
            return false;
        }
        return false;
    }
}
