import java.util.Scanner;

/**
 * @Author:Aliyang
 * @Data: Created in 下午12:45 18-6-22
 * 蛇形矩阵：我的解法
 * 思路：找规律
 **/
public class T34 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int num=sc.nextInt();
            int row_incre=2;//每一行的增量
            int col_incre=0;//第一列的增量
            int first=1;
            for (int i=0;i<num;i++){//总共趟数
                String res="";
                first=first+col_incre;
                int row_num=first;
                int row_increNow=row_incre;
                for (int j=0;j<num-i;j++){//遍历每一行的数
                    res+=row_num;
                    res+=" ";
                    row_num+=row_increNow;
                    row_increNow++;
                }
                System.out.println(res.substring(0,res.length()-1));//去掉最后的空格
//                修改增量
                row_incre++;
                col_incre++;
            }
        }
    }
}
