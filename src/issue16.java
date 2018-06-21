import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by AliYang on 2018/3/3.
 * 坐标移动
 */
public class issue16 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
//        Scanner sc=new Scanner(System.in);
//        String line=sc.nextLine();
        String line="";
        while ((line=br.readLine())!=null){
        String[] lines=line.split(";");
        int x=0,y=0;//坐标
        for (int i=0;i<lines.length;i++){
            if (lines[i]=="")
                continue;
            String action=lines[i];
            if (action.length()>3||action.length()<2)
                continue;
            char move=action.charAt(0);
            String remain=action.substring(1,action.length());
            if (!(move=='A'||move=='D'||move=='W'||move=='S'))
                continue;
            boolean isNumber=true;
            for (int j=0;j<remain.length();j++){
                if (!(remain.charAt(j)>='0'&&remain.charAt(j)<='9')){
                    isNumber=false;
                    break;
                }
            }
            int step=0;
            if (isNumber==true){
                step = Integer.parseInt(remain);
                switch (move){
                    case 'A':
                        x-=step;
                        break;
                    case 'D':
                        x+=step;
                        break;
                    case 'W':
                        y+=step;
                        break;
                    case 'S':
                        y-=step;
                        break;
                }
            }
            else continue;
            }
        System.out.println(x+","+y);
        }
        br.close();
    }
}
