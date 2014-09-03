package EventListeners;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class PlaySound1 {
	
	Clip clip;
	
	public PlaySound1(double volume){
		try
	      {
	          clip = AudioSystem.getClip();
	          AudioInputStream ais = AudioSystem.getAudioInputStream(new File("Sounds\\ButtonSound.wav"));
	          clip.open(ais);
	          
	          FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	          double gain = volume;    //between 0 and 1
	          float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
	          gainControl.setValue(dB);
	          
	          long time = System.currentTimeMillis();
	          clip.start();
	          while(System.currentTimeMillis() - time < 10);
	          clip.close();
	      }
	      catch (Exception exc)
	      {
	      }
	}
	
	public PlaySound1(double volume, boolean temp){
		try
	      {
	          clip = AudioSystem.getClip();
	          AudioInputStream ais = AudioSystem.getAudioInputStream(new File("Sounds\\ButtonSound.wav"));
	          clip.open(ais);
	          
	          FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
	          double gain = volume;    //between 0 and 1
	          float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
	          gainControl.setValue(dB);
	          
	          long time = System.currentTimeMillis();
	          clip.start();
	          while(System.currentTimeMillis() - time < 1);
	          clip.close();
	      }
	      catch (Exception exc)
	      {
	      }
	}
}
