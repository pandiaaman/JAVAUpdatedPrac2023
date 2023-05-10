package com.java.aman.audioplayer;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class AudioPlayer {

	public static void main(String[] args) {
		
		/*
		 * file => audioStream => clip
		 */
		Scanner sc = new Scanner(System.in);
		
		File file1 = null;
		File file2 = null;
		
		AudioInputStream audioStream = null;
		Clip clip = null;
		
		try {
			file1 = new File("Calm Cam - TrackTribe.wav");
			file2 = new File("On The Rocks - TrackTribe.wav");
			
			audioStream  = AudioSystem.getAudioInputStream(file1);
			clip = AudioSystem.getClip();
			
			clip.open(audioStream);
//			clip.start();
			
		}catch(IOException | UnsupportedAudioFileException e) {
			System.out.println("file not found");
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String response = "";
				
		while(!response.equalsIgnoreCase("Q")) {
			System.out.println("P: play S: pause R: reset Q: quit");
			System.out.println("please enter your choice");
			response  = sc.next();
			
			switch(response.toUpperCase()) {
			case "P":
				clip.start();
				break;
			case "S":
				clip.stop();
				break;
			case "R":
				clip.setMicrosecondPosition(0);
				break;
			case "Q":
				clip.close();
				break;
			default:
			}
		}
		System.out.println("you have quit the audio player");
		sc.close();
	}

}
