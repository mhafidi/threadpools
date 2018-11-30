import core.Process;
import core.ProcessState;

import java.time.ZonedDateTime;

public class ProcessSleeper extends Process
{

    public ProcessSleeper(int aInId)
    {

        super(aInId);
    }

    @Override
    public void run()
    {
        processState = ProcessState.STARTED;

        startedTime = java.util.Optional.of(ZonedDateTime.now());
        try
        {
            Thread.sleep(100000);
        }
        catch (InterruptedException e)
        {
            System.err.println("An Error Occurred while Processing the Process["+id+"]");
        }
        processState = ProcessState.FINISHED;
    }

}
