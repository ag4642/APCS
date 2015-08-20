/**
 * Processable.java  05/10/07
 *
 * @author - Jane Doe
 * @author - Period n
 * @author - Id nnnnnnn
 *
 * @author - I received help from ...
 *
 */

import info.gridworld.actor.Actor;

import java.awt.Color;

/**
 * A <code>QueenAnt</code> sits around and waits for a
 * <code>WorkerAnt</code> to bring it food.
 * It does not act.
 */
public class QueenAnt extends Actor implements Processable
{
	/** Total amount of food that the queen has received. */


    /**
     * Constructs a <code>QueenAnt</code> actor.
     * The queen is colored magenta.
     */
    public QueenAnt()
    {

    }

	/**
	 * Gets food from and gives current location to <code>ant</code>.
	 * @param ant the calling <code>WorkerAnt</code>
	 */
	public void process(WorkerAnt ant)
	{

	}

    /**
     * "Do nothing" act method.  This is provided for the Ant Farm
     * <code>Cake, Cookie, and QueenAnt</code> classes which do not act.
     */
    @Override
    public void act()
    {
    }

    /**
     * Creates a string that describes this actor.
     * @return a string with the <code>Actor</code> information
     * plus the amount of food given to this <code>QueenAnt</code>
     */
    @Override
	public String toString()
	{
		return null;	// Replace with appropriate implementation !
	}
}
