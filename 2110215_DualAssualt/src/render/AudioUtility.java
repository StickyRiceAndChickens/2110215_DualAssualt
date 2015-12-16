package render;

import java.applet.Applet;
import java.applet.AudioClip;

public class AudioUtility {
	

	public static AudioClip menuSong;
	private static AudioClip gunShot;
	public static AudioClip gameSong;
	private static AudioClip reload;
	private static AudioClip killSound;
	private static AudioClip winSound;
	private static AudioClip enemy_winSound;

	private static AudioClip getAudio(String directory) {
		/* try to load sound from directory */
		AudioClip audioClip;
		try {

			audioClip = Applet.newAudioClip(AudioUtility.class.getClassLoader().getResource(directory));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail load sound from " + directory);
			audioClip = null;
		}
		return audioClip;

	}

	static {
		/* install where to load sound */
		menuSong = getAudio("res/sound/Main_Menu.wav");
		gunShot = getAudio("res/sound/shoot.wav");
		gameSong=getAudio("res/sound/gameSoundtack.wav");
		reload=getAudio("res/sound/Reloading.wav");
		killSound=getAudio("res/sound/Kill_Bonus_DM_.wav");
		winSound=getAudio("res/sound/CS_Win.wav");
		enemy_winSound=getAudio("res/sound/Terrorists_win.wav");

	}

	public static void playSound(String identifier) {
		/* to Play sound from identifier */
		switch (identifier) {
		case "menu":
			menuSong.play();
			break;
		case "shot":
			gunShot.play();
			break;
		case "reload":
			reload.play();
			break;
		case "kill":
			killSound.play();
			break;
		case "win":
			winSound.play();
			break;
		case "lose":
			enemy_winSound.play();
			break;
		case "game":
			gameSong.play();
			break;
		default:
			break;
			
		}
		
	}
}
