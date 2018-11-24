import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadManagerPool
{
    final static int MAX_THREADS=100;
    static ExecutorService executorService;

    public static void main(String[]args)
    {
        executorService = Executors.newFixedThreadPool(MAX_THREADS);
    }

}
