/**
 * AntFarmRunner.java  05/10/07
 *
 * @author - Robert Glen Martin
 * @author - School for the Talented and Gifted
 * @author - Dallas ISD
 *
 * Ant Farm GridWorld project:
 * Copyright(c) 2007 Robert Glen Martin
 * (http://www.martin.apluscomputerscience.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

   import info.gridworld.actor.Actor;
   import info.gridworld.actor.ActorWorld;
   import info.gridworld.grid.Grid;
   import info.gridworld.grid.BoundedGrid;
   import info.gridworld.grid.Location;

/**
 * This class runs a world that contains Ant Farm actors.
 * A cookie, a cake, and a queen are added at specific locations
 * in a 19x19 grid.  25 worker ants are added at random locations.
 */
    public class AntFarmRunner
   {
       public static void main(String[] args)
      {
         Grid<Actor> grid = new BoundedGrid<Actor>(19, 19);
         ActorWorld world = new ActorWorld(grid);
      
         world.add(new Location(2, 2), new Cookie());
         world.add(new Location(17, 2), new Cake());
         world.add(new Location(9, 15), new QueenAnt());
      
         for (int i = 0; i < 25; i++)
            world.add(new WorkerAnt());
      
         world.show();
      }
   }
