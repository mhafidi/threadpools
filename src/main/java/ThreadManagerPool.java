
/**
 * @date 25/11/2018
 * @author mhafidi
 * @classname ThreadPoolManager
 * @description <p>ThreadPoolManager</p> is used to queue the potential processes that were created
 * and if a thread is available within the reserved 10 threads it will be processed
 *
 *
 *
 */
import core.Process;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManagerPool implements Runnable
{
    final static int MAX_THREADS=100; //max threads to be queued
    final static int MAX_THREADS_IN_THREADS_POOL=10; //max threads to be submitted in the the threadpool

    static ExecutorService executorService= Executors.newFixedThreadPool(MAX_THREADS_IN_THREADS_POOL);
    BlockingQueue<Process> processes = new ArrayBlockingQueue<Process>(MAX_THREADS);

    private static ThreadManagerPool instance;

    private ThreadManagerPool()
    {

    }

    public static ThreadManagerPool get()
    {
        return instance==null?new ThreadManagerPool():instance;
    }
    public void run()
    {

    }


}
