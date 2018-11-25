package core;

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

    private int id;

    public Process(int aInId)
    {

        id = aInId;
    }

    public void run()
    {

    }

}
