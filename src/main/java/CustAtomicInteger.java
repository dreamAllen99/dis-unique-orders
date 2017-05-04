import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by allen on 2017/5/4.
 */
public class CustAtomicInteger extends AtomicInteger {

    public  CustAtomicInteger(){
        super();
    }

    public CustAtomicInteger(int baseNumber){
        super(baseNumber);
    }


    public int incrementAndGet(int max){
        for (;;) {
            int current = get();
            if(current>=max){
                super.set(1);
                return 1;
            }
            int next = current + 1;
            if (compareAndSet(current, next)){
                return next;
            }
        }
    }

}
