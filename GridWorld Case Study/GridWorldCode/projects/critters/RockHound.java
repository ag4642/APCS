   import info.gridworld.actor.Actor;
   import info.gridworld.actor.Rock;
   import info.gridworld.actor.Critter;
   import info.gridworld.grid.Location;
   import java.util.ArrayList;
   public class RockHound extends Critter
   {
      public void processActors(ArrayList<Actor> actors)
      {
         for(Actor e : actors)
         {
            if(e instanceof Rock)
               e.removeSelfFromGrid();
         }
      }
   }