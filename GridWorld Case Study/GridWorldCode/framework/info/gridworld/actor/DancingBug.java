   import info.gridworld.actor.Bug; 
   public class DancingBug extends Bug 
   { 
      private int[] turn; 
      private int currentStep; 
   
      public DancingBug(int[] turns) 
      { 
         turn = turns; 
         currentStep = 0; 
      } 
      public void turn(int times) 
      { 
         for(int j = 1; j <= times; j++) 
         { 
            turn(); 
         } 
      } 
   
      public void act() 
      { 
         if(currentStep == turn.length) 
         {
            currentStep = 0; 
         }
         turn(turn[currentStep]); 
         currentStep++; 
         super.act(); 
      } 
   }