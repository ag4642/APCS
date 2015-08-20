/* Intro to Game Programming Lecture 3
 *
 * Playing MP3 files for music.
 *
 * Since Java doesn't have built-in libraries for playing mp3s, we use an external library:
 * http://www.javazoom.net/javalayer/javalayer.html
 * Download and unzip the file so that the folder "javazoom" is in your project folder.
 *
 * A little bit of code is necessary to get it to work:
 */
	
//Import mp3 library
   import javazoom.jl.player.*;
   import java.io.*;
    public class MusicTest {
   
      public InputStream gamemusic; // the file which the music streams from
      public Player player; // the object that plays the music
      public PlayerThread pt; // a separate thread so music doesn't interfere with the main game
   
       public void playMusic(InputStream in) { // takes an argument of the InputStream to use
         try {
            player = new Player(in); // a new player object to play the music
            pt = new PlayerThread(); // new player thread
            pt.start(); // starts the thread (think timer.start())
         }
             catch (Exception e) {
               System.out.println("Music failed to play");
            } // prints error if it fails
      }
       public void initMusic() {
         try {
            gamemusic = new FileInputStream("path/to/file.mp3");
         } 
         // makes sure the specified file path is good and sets that to be where the music streams from
             catch (Exception e) {
               System.out.println(e);
               System.out.println("Music failed to load");
            } // otherwise prints an error
      }
       public class PlayerThread extends Thread {
          public void run() {
            try {
               player.play();
            } // plays the music
                catch (Exception e) {
                  System.out.println("PlayerThread error");
               } // error if it fails
         }
      } // extends thread 
      
   	
   	
       public static void main(String[] args) {
         MusicTest mt = new MusicTest();
         mt.initMusic();
         mt.playMusic(gamemusic);
      }
   }
