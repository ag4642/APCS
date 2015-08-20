import sun.audio.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;


public class VTSound2 extends Frame {

 Button playButton = new Button("Play turkey sound");
 File theFile = null;
 AudioData theData = null;
 InputStream nowPlaying = null;
 private BufferedImage myImage;
     public void paintComponent(Graphics g);


  public VTSound2() {
    super("VT Sound Player");
    resize(300, 200);
    Panel north = new Panel();
    north.setLayout(new FlowLayout(FlowLayout.LEFT));
	    ImageIcon i = new ImageIcon("turkey.jpg");
         g.drawImage(i.getImage(), 150, 75, 110, 150, null);

    add("North", north);
    Panel south = new Panel();
    south.add(playButton);
    add("South", south);
  }

  public static void main(String[] args) {
    VTSound2 sp = new VTSound2();
    sp.show();
  }

  public void open() {
    try {
      theFile = new File("turkey.wav");
      if (theFile != null) {
       FileInputStream fis = new FileInputStream(theFile);
        AudioStream as = new AudioStream(fis);
        theData = as.getData();
      }
    }
    catch (IOException e) {
      System.err.println(e);
    }
  }

  public void play() {
   if (theData == null) open();
    if (theData != null) {
      AudioDataStream ads = new AudioDataStream(theData);
      AudioPlayer.player.start(ads);
      nowPlaying = ads;
    }
  }

  public boolean action(Event e, Object what) {

    if (e.target == playButton) {
      play();
      return true;
    }
    return false;

  }

}

