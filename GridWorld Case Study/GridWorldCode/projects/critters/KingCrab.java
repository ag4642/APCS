   import info.gridworld.actor.Actor;
   import info.gridworld.actor.Critter;
   import info.gridworld.grid.Grid;
   import info.gridworld.grid.Location;
   import java.awt.Color;
   import java.util.ArrayList;

   public class KingCrab extends CrabCritter
   {
      public KingCrab()
      {
         setColor(Color.PINK);
      }
      public int distanceFrom(Location loc1, Location loc2)
      {
         int x1 = loc1.getRow();
         int y1 = loc1.getCol();
         int x2 = loc2.getRow();
         int y2 = loc2.getCol();
         double dist = Math.sqrt((x1 - x2)*(x1 - x2) + (y1 - y2)*(y1 - y2)) + .5;
         return (int)Math.floor(dist);
      }
      private boolean moveOneMoreAway(Actor a)
      {
         ArrayList<Location> locs =
            getGrid().getEmptyAdjacentLocations(a.getLocation());
         for(Location loc:locs)
         {
            if(distanceFrom(getLocation(), loc) > 1)
            {
               a.moveTo(loc);
               return true;
            }
         }
         return false;
      }
   /*
   * Each actor in the list actors is told to move one location further
   * away from this KingCrab. If that is not possible, the actor is
   * removed from the grid.
   */
      public void processActors(ArrayList<Actor> actors)
      {
         for (Actor a : actors)
         {
            if (!moveOneMoreAway(a))
            {
               a.removeSelfFromGrid();
            }
         }
      }
   }