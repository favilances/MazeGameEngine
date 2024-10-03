package soundengine;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

public class SoundEngine {

    public void playSound(String soundFile) {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(soundFile)));
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
