package core;

/**
 * @date 24/11/2018
 * @author mhafidi
 * @classname Processor
 * @description When an object extends <code>Processor</code> is used
 * to create a thread. Then it can  be added to the ThreadManagerPool
 *
 *
 *
 *
 *
 */

public class Processor implements Runnable
{

    private int id;

    public Processor(int aInId)
    {

        id = aInId;
    }

    public void run()
    {

    }

}
