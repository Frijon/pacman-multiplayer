package com.company;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;


/**
 * The Music class, generating a music object playing background music.
 */
public class Music {

    /**
     * Playing the music.
     */
    public void playMusic() {
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(Music.class.getResource("/PacMan-ThemeSong.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
