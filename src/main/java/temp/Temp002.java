package temp;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * 递归
 */
@Slf4j
public class Temp002 {

    public static void demoMain1() {
        int arg = 1;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            System.out.println();
            int result;
            try {
                arg = arg << 1;
                result = f(arg);
                log.info("when arg is " + arg + ", result is " + result);
            } catch (StackOverflowError ignored) {
                System.err.println("stack over flow while arg is " + arg);
                return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        demoMain1();
        // demoMain2();
    }

    private static void demoMain2() {
        int[] cache = new int[1024];
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 10; i++) {
            log.info("i: " + i);
            log.info("cache[" + i + "]: " + cache[i]);
            log.info("---------------------------------------------");
        }
    }

    public static Map<Integer, Integer> cache = new HashMap<>();
    static{
        cache.put(1, 1);
        cache.put(2, 2);
    }

    public static int f(int n) {
        Integer cacheResult = cache.get(n);
        if(null != cacheResult){
            return cacheResult;
        }

        int result =  f(n - 1) + f(n - 2);

        cache.put(n, result);

        return result;
    }
}
