
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

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadManagerPool implements Runnable
{
    final static int MAX_THREADS=100; //max threads to be queued
    final static int MAX_THREADS_IN_THREADS_POOL=10; //max threads to be submitted in the the threadpool

    List<Future<?>> futures = new ArrayList<>(); //processes that are ongoing
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

    public boolean pushNewProcess(Process aInProcess)
    {
        if(shouldBeImmediatlyProcceed(aInProcess))
        {
            flushUnsedFutures(futures);
            Future<?> future = executorService.submit(aInProcess);
            futures.add(future);
        }
        return true;
    }

    private void flushUnsedFutures(List<Future<?>> futures)
    {
        for(Future<?> future:futures)
        {
            if(future.isDone() || future.isCancelled())
                futures.remove(future);
        }
    }

    private boolean shouldBeImmediatlyProcceed(Process aInProcess)
    {
        return true;
    }


}
