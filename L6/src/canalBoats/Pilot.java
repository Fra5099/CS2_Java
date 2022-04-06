package canalBoats;

import java.util.List;

import canalBoats.util.CanalSim;

/**
 * Each Boat has a Pilot.
 * The Pilot's {@link #run()} method executes in a separate thread.
 * Its job is to drive its Boat through FlatStretches, enqueue it at
 * each Lock, and wait for the Boat to come out of the Lock.
 */
public class Pilot implements Runnable {

    private static int counter = 0;
    private final int id = counter++;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + this.id;
    }

    private List< Segment > route;
    private Boat boat;

    /**
     * Create a new Pilot for an already-created Boat.
     * Pilots don't have assigned names; they are
     * just assigned sequential IDs, starting at 0.<br>
     * Format: <code>Pilot<i>n</i></code>
     * @param route the sequence of FlatStretches and Locks through which
     *              the Boat must be piloted.
     * @param boat this Pilot's Boat
     */
    public Pilot( List< Segment > route, Boat boat ) {
        this.route=route;
        this.boat=boat;
        CanalSim.println( "New " + this + " has " + boat );

    }

    /**
     * Repeatedly do the following.
     * <ol>
     *     <li>Look up the next Segment of the route.</li>
     *     <li>
     *         Arrive at the Segment, noting whether or not it must
     *         give up its Boat to a LockMaster.
     *         <ul>
     *             <li>
     *                 If so, wait until the Boat says it's out.
     *                 {@link Boat#waitUntilOut()}
     *             </li>
     *             <li>
     *                 If not, simulate moving over water with a
     *                 call to {@link CanalSim#sleep(float)},
     *                 taking into account the Boat length and speed
     *                 and the length of the stretch of water.
     *             </li>
     *         </ul>
     *     </li>
     * </ol>
     * This method returns when the entire route has been traveled.
     */
    public void run() {
        CanalSim.println( this + " is ready to travel. ");
        for (Segment segment: route){
            CanalSim.println( this + " is arriving at " + segment );
            boolean canal=segment.arrive(boat);
            if (canal){
                boat.enteringLock();
                boat.waitUntilOut();
                CanalSim.println( this + " has " + boat + " back." );
            }
            else {
                float sleep= (segment.getLength()-boat.getLength())/CanalSim.BOAT_SPEED;
                CanalSim.sleep(sleep);
                CanalSim.println(
                        this + ": " + boat + " is through the stretch."
                );
            }


        }

        // TODO
        /*
          Here are some print statements you should use within your code.

          When the pilot's boat first gets to a lock or flat stretch:
          CanalSim.println( this + " is arriving at " + seg );

          When the pilot gets their boat back after it's been through the lock:
          CanalSim.println( this + " has " + --my boat-- + " back." );

          When the pilot finishes traveling through a flat stretch:
          CanalSim.println(
                  this + ": " + --my-boat-- + " is through the stretch."
          );

          (Please delete these comments when done.)
         */
    }
}
