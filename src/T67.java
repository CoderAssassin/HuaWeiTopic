import java.util.*;

/**
 * @Author:Aliyang
 * @Data: Created in 下午3:00 18-8-15
 * 成绩排序：我的解法
 **/
public class T67 {

    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=Integer.parseInt(sc.nextLine());
            int flag=Integer.parseInt(sc.nextLine());
            Student[]st=new Student[n];
            for(int i=0;i<n;i++){
                String str=sc.nextLine();
                int index=str.indexOf(" ");
                st[i]=new Student();
                st[i].name=str.substring(0,index);
                st[i].grade=Integer.parseInt(str.substring(index+1));
            }


            if(flag==0){//从大到小
                for(int i=0;i<n;i++){
                    for(int j=0;j<n-i-1;j++){
                        if(st[j].grade<st[j+1].grade){
                            swap(st,j,j+1);
                        }
                    }
                }
            }else{
                for(int i=0;i<n;i++){
                    for(int j=0;j<n-i-1;j++){
                        if(st[j].grade>st[j+1].grade){
                            swap(st,j,j+1);
                        }
                    }
                }
            }

            for(int i=0;i<n;i++){
                System.out.println(st[i].name+" "+st[i].grade);
            }
        }
    }


    public static void swap(Student []st,int m,int n){
        Student stud=new Student();
        stud=st[m];
        st[m]=st[n];
        st[n]=stud;
    }

}

class Student{
    String name;
    int grade;

    public Student(){
        this.name=null;
        this.grade=0;
    }
}
