package huawei;


/**
 * @Author:Aliyang
 * @Data: Created in 上午8:18 18-8-23
 **/
public class SynchronizedTest {

    public synchronized void Synchronized_method(){
        System.out.println("方法同步");
    }

    public void Synchronized_block(){
        synchronized (this){
            System.out.println("代码块同步");
        }
    }

    public static synchronized void Synchronized_static(){
        System.out.println("类方法同步");
    }
}
