   import info.gridworld.actor.Actor;
   import info.gridworld.actor.Critter;
   import info.gridworld.actor.Flower;
   import info.gridworld.grid.Location;
   import info.gridworld.grid.Grid;
   import java.util.ArrayList;
   import java.awt.Color;

/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
   public class ChameleonKid extends ChameleonCritter
   {
      private static final double DARKENING_FACTOR = 0.05;
     /**
     * Randomly selects a neighbor and changes this critter's color to be the
     * same as that neighbor's. If there are no neighbors, no action is taken.
     */
      public ArrayList<Actor> getActors()
      {
         ArrayList<Actor> actors = new ArrayList<Actor>();
         int[] dirs =
            { Location.AHEAD, Location.HALF_CIRCLE };
         for (Location loc : getLocationsInDirections(dirs))
         {
            Actor a = getGrid().get(loc);
            if (a != null)
               actors.add(a);
         }
         return actors;
      }
      
      public ArrayList<Location> getLocationsInDirections(int[] directions)
      {
         ArrayList<Location> locs = new ArrayList<Location>();
         Grid gr = getGrid();
         Location loc = getLocation();
         for (int d : directions)
         {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(neighborLoc))
               locs.add(neighborLoc);
         }
         return locs;
      }
   }
