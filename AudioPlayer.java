package accuracycontroller;

import java.io.File; 
import java.io.IOException; 
  
import javax.sound.sampled.AudioInputStream; 
import javax.sound.sampled.AudioSystem; 
import javax.sound.sampled.Clip; 
import javax.sound.sampled.LineUnavailableException; 
import javax.sound.sampled.UnsupportedAudioFileException; 
  
public class AudioPlayer  
{ 
    Clip clip; 
    String status; 
      
    AudioInputStream audioInputStream; 
    static String filePath; 
  
    // constructor to initialize streams and clip 
    public AudioPlayer() 
        throws UnsupportedAudioFileException, 
        IOException, LineUnavailableException  
    { 
        // create AudioInputStream object 
        audioInputStream =  
                AudioSystem.getAudioInputStream(new File("src/accuracycontroller/Recording (1).wav").getAbsoluteFile()); 
          
        // create clip reference 
        clip = AudioSystem.getClip(); 
          
        // open audioInputStream to the clip 
        clip.open(audioInputStream); 
    } 
  
    public static void main(String[] args)  
    { 
        try
        { 
            filePath = "src/accuracycontroller/Recording (1).wav"; 
            AudioPlayer audioPlayer =  
                            new AudioPlayer(); 
              
            audioPlayer.play();
        }
          
        catch (Exception ex)  
        { 
            System.out.println("Error with playing sound."); 
            ex.printStackTrace(); 
          
          } 
    } 
      
    // Method to play the audio 
    public void play()  
    { 
        //start the clip 
        clip.start(); 
          
        status = "play"; 
    } 
      
      
    // Method to stop the audio 
    public void stop() throws UnsupportedAudioFileException, 
    IOException, LineUnavailableException  
    { 
        clip.stop(); 
        clip.close(); 
    } 

      
    // Method to reset audio stream 
    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, 
                                            LineUnavailableException  
    { 
        audioInputStream = AudioSystem.getAudioInputStream( 
        new File(filePath).getAbsoluteFile()); 
        clip.open(audioInputStream); 
    } 
  
} 