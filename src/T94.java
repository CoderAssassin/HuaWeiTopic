import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 上午11:27 18-8-17
 * 人民币转换：别人解法
 **/
public class T94 {

    static char[] digit = {'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    static char[] unitLast = {'角', '分'};
    static char[] unit = {' ','拾','佰','仟'};
    static char[] lastfix = {'万','亿'};

    /**
     * 处理小数点前边的转换
     * @param pre
     * @return
     */
    public static String processPre(char[] pre) {
        StringBuilder str = new StringBuilder();
        str.append('元');
        int count = 0;
        boolean flag = false;
        boolean zero = false;
        boolean first = false;//到当前位置是否都是连续的0
        boolean input = false;
        if(pre[pre.length-1] == '0')
            first = true;
        for(int i = pre.length-1; i >= 0; i--) {
            count++;
            if(count % 4 == 1 && count != 1) {//4位成万，8位成亿
                str.append(lastfix[count/4-1]);
            }
            if(pre[i] != '0') {
                flag = true;
                first = false;
                input = true;
            } else {
                zero = true;
            }
            if(first && pre[i] == '0') {//连续的0并且当前的也是0
                zero = false;
            }
            if(flag && unit[(pre.length-1-i) % 4] != ' '){//添加单位
                str.append(unit[(pre.length-1-i) % 4]);
            }
            if(count != pre.length || count % 4 != 2) {
                if(flag) {
                    str.append(digit[pre[i]-'0']);
                    flag = false;
                }
                if(zero && input) {
                    str.append('零') ;
                    input = false;
                    zero = false;
                }
                if(!input && zero)
                    zero = false;

            }
            if(count % 4 == 2 && pre[i] != '0')
                flag = false;

        }
        return str.reverse().toString();
    }
    public static String processLast(char[] last) {
        String str = "";
        for(int i = 0; i < last.length; i++) {
            if(last[i] != '0') {
                str += digit[last[i] - '0'];
                str += unitLast[i];
            }
        }
        return str;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()) {
            String[] money = cin.next().split("\\.");
            String rmb = "人民币";
            char[] pre = money[0].toCharArray();
            boolean flagLast = true;//用来标记小数点后边是否都是0
            boolean flagPre = true;
            char[] last = null;
            if(money.length == 1)//判断小数点后边是否有数字
                flagLast = true;
            else {
                last = money[1].toCharArray();
                for(int i = 0; i < last.length; i++) {
                    if(last[i] != '0')
                        flagLast = false;
                }
            }
            for(int i = 0; i < pre.length; i++) {
                if(pre[i] != '0')
                    flagPre = false;
            }
            if(flagPre && flagLast) {//如果小数点前边和小数点后边都是0的话
                System.out.println("零元零角零分");
            }
            if(flagLast && !flagPre) {//如果小数点后边都是0
                rmb += processPre(pre);
                rmb += '整';
            }
            if(flagPre && !flagLast) {//如果小数点前边都是0
                rmb += processLast(last);
            }
            if(!flagLast && !flagPre){//如果两边都不是0
                rmb += processPre(pre);
                rmb += processLast(last);
            }
            System.out.println(rmb);

        }
    }
}
