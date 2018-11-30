package core;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

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
    protected ZonedDateTime createdTime;
    protected Optional<ZonedDateTime> startedTime= Optional.empty();

    public Process(int aInId)
    {
        id = aInId;
        processState= ProcessState.CREATED;
        createdTime = ZonedDateTime.now();
        processPersistency=false;
        processDependency=false;
    }
    public Process(int aInId,boolean aInProcessPersistency,boolean aInProcessDependency)
    {
        id = aInId;
        processDependency = aInProcessDependency;
        processPersistency = aInProcessPersistency;
        createdTime = ZonedDateTime.now();
        processState= ProcessState.CREATED;
    }
    public void run()
    {

    }

    public ZonedDateTime getCreatedTime()
    {

        return createdTime;
    }


    @Override
    public String toString()
    {

        String str2=startedTime.isPresent()?
                "Started at ["+ startedTime.get().format(DateTimeFormatter.ISO_ZONED_DATE_TIME)+"]\n"
                :"";
        String str="Process ["+id+"]\n"+
                "Created at ["+ createdTime.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)+"]\n"+
                "Process Dependency:["+(processDependency?"Dependent":"Independent")+"]\n"+
                "Process Persistency:["+(processPersistency?"Persistent":"Transient")+"]\n"+str2;

        return str;
    }

    public ProcessState getProcessState()
    {

        return processState;
    }

    public int getId()
    {

        return id;
    }

    public boolean isProcessPersistency()
    {

        return processPersistency;
    }

    public boolean isProcessDependency()
    {

        return processDependency;
    }

    public void setProcessState(ProcessState processState)
    {

        this.processState = processState;
    }

}
