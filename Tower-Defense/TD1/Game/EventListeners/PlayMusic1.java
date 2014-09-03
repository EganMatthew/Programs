package EventListeners;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;

public class PlayMusic1 {
	
	Clip clip;
	String loc;
	
	public PlayMusic1(double volume, String loc){
		try
	      {	
			  this.loc = loc;
	          clip = AudioSystem.getClip();
	          AudioInputStream ais = AudioSystem.getAudioInputStream(new File(loc));
	          clip.open(ais);
	          
	          FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	          double gain = volume;    //between 0 and 1
	          float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
	          gainControl.setValue(dB);
	          
	          clip.loop(Clip.LOOP_CONTINUOUSLY);
	      }
	      catch (Exception exc)
	      {
	    	  return;
	      }
	}
	
	public void stop(){
		if(clip == null)
			return;
		
		clip.stop();
		clip.close();
		clip = null;
	}
	
	public void changeVolume(double volume){
		
		if(clip == null)
			return;
				
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        double gain = volume;    //between 0 and 1
        float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
        gainControl.setValue(dB);
		
        clip.loop(clip.LOOP_CONTINUOUSLY);
	}
}
