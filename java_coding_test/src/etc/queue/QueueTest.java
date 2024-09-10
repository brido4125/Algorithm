package etc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class QueueTest {

    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MINUTES, new ArrayBlockingQueue<>(5));

        for (int i = 0; i < 10; i++) {
            threadPool.execute(() -> {
                try {
                    System.out.println("threadPool.getPoolSize() = " + threadPool.getPoolSize());
                    System.out.println("threadPool.getQueue().size() = " + threadPool.getQueue().size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        System.out.println("execute done.");
        threadPool.shutdown();
    }
}
