import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by allen on 2017/5/4.
 */
public class Test {

    private static CustAtomicInteger cnt = new CustAtomicInteger(10000);

    private static String[] caps = new String[]{"A","B","C","D","E","F","G","H","J","K","M","N","P","Q","R","S","T","U","V","W","X","Y","Z"};

    private static Random r = new Random();

    public static String getRandom(){
        int a = cnt.incrementAndGet(90000);
        String s = String.valueOf(a).substring(0, 2) + caps[r.nextInt(caps.length)] + String.valueOf(a).substring(2);
        return s;
    }

    public static void main(String[] args) throws InterruptedException {
        final List<String> list = new ArrayList<String>(61000);
        for (int i = 0; i < 50000; i++) {
            new Thread(new Runnable() {
                public void run() {
                    String random = getRandom();
                    list.add(random);
                    System.err.println(random);

                }
            }).start();
        }

        Thread.sleep(1000 * 5);



        System.err.println("=====begin checking=======");

        Collections.sort(list);

        String pre = list.get(0);
        for (int i = 1; i < list.size(); i++) {

            String s = list.get(i);
            if(pre.equals(s)){
                System.err.println("same data==>" + s);
            }
            else{
                pre = s;
            }

        }


        System.err.println("=======check okay!========");

    }
}
