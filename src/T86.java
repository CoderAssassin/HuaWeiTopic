import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:27 18-8-16
 * 密码强度等级：我的解法
 **/
public class T86 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line ="";
        while((line=br.readLine())!=null){
            GetPwdSecurityLevel(line);
        }
    }

    private static void GetPwdSecurityLevel(String line) {
        int lenGirad = 0;
        int numGirad = 0;
        int charGirad = 0;
        int otherCharGirad = 0;
        int rewardGirad = 0;

        char[] chs = line.toCharArray();
        if(chs.length<=4)
            lenGirad = 5;
        else if(chs.length >= 4 && chs.length <= 7)
            lenGirad = 10;
        else if(chs.length >= 8)
            lenGirad = 25;

        int Numbercount = 0;
        int LowerCcount = 0;
        int UpperCcount = 0;
        int otherCcount = 0;
        for(int i=0;i<chs.length;++i)
        {
            if(chs[i]>='a' && chs[i] <='z')
                ++LowerCcount;
            else if(chs[i]>='A' && chs[i] <='Z')
                ++UpperCcount;
            else if(chs[i]>='0' && chs[i] <='9')
                ++Numbercount;
            else
                ++otherCcount;
        }

        if(Numbercount==0)
            numGirad = 0;
        else if(Numbercount==1)
            numGirad = 10;
        else
            numGirad = 20;

        if(LowerCcount==0 && UpperCcount==0)
            charGirad = 0;
        else if((LowerCcount!=0&&UpperCcount==0)||(LowerCcount==0 && UpperCcount!=0))
            charGirad = 10;
        else
            charGirad = 20;

        if(otherCcount==0)
            otherCharGirad = 0;
        else if(otherCcount==1)
            otherCharGirad = 10;
        else
            otherCharGirad = 25;

        if(LowerCcount>0&&UpperCcount>0&&Numbercount>0&&otherCcount>0)
            rewardGirad = 5;
        else if((LowerCcount>0||UpperCcount>0)&&Numbercount>0&&otherCcount>0)
            rewardGirad = 3;
        else if((LowerCcount>0||UpperCcount>0)&&Numbercount>0)
            rewardGirad = 2;

        int sumGriad = lenGirad + numGirad + charGirad + otherCharGirad + rewardGirad;

        if(sumGriad>=90)
            System.out.println("VERY_SECURE");
        else if(sumGriad>=80)
            System.out.println("SECURE");
        else if(sumGriad>=70)
            System.out.println("VERY_STRONG");
        else if(sumGriad>=60)
            System.out.println("STRONG");
        else if(sumGriad>=50)
            System.out.println("AVERAGE");
        else if(sumGriad>=20)
            System.out.println("WEAK");
        else if(sumGriad>=0)
            System.out.println("VERY_WEAK");

    }
}
