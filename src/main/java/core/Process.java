package core;

import java.time.ZonedDateTime;

/**
 * @date 24/11/2018
 * @author mhafidi
 * @classname Process
 * @description When an object extends <code>Process</code> is used
 * to create a thread. Then it can  be added to the ThreadPoolManager
 *
 *
 *
 *
 *
 */

public class Process implements Runnable
{

    protected int id;
    protected ProcessState processState;
    protected boolean processPersistency; //peristent=true || transient=false;
    protected boolean processDependency; //dependent=true || independent=false;
    protected ZonedDateTime startTime;

    public Process(int aInId)
    {
        id = aInId;
        processState= ProcessState.CREATED;
        startTime = ZonedDateTime.now();
        processPersistency=false;
        processDependency=false;
    }
    public Process(int aInId,boolean aInProcessPersistency,boolean aInProcessDependency)
    {
        id = aInId;
        processDependency = aInProcessDependency;
        processPersistency = aInProcessPersistency;
        startTime = ZonedDateTime.now();
    }
    public void run()
    {

    }


}
