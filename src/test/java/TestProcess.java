import core.ProcessState;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestProcess
{
    ProcessSleeper processSleeper;
    ThreadManagerPool threadManagerPool;

    @Before
    public void init()
    {
        threadManagerPool=ThreadManagerPool.get();
        processSleeper= new ProcessSleeper(1);
    }
    @Test
    public void testProcessStateCreated()
    {
        assertEquals(processSleeper.getProcessState(), ProcessState.CREATED);
        System.out.println(processSleeper);
    }
    @Test
    public void testProcessStateStarted()
    {
        threadManagerPool.pushNewProcess(processSleeper);
        try
        {
            Thread.sleep(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println("ProcessSleeper is pushed To The ThreadManager");
        assertEquals(processSleeper.getProcessState(),ProcessState.STARTED);
        System.out.println(processSleeper);
    }
}
