package com.dond.application;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoundHandler {

    public static void runMusic(String path){
        try {
            AudioInputStream inputStream  = AudioSystem.getAudioInputStream(new File(path));
            Clip clip = AudioSystem.getClip();
            clip.open(inputStream);
            clip.start();

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e ) {
            System.out.println("***Music File Unavailable***");
        }

    }
}
