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
		menuSong = getAudio("res/sound/Main_Menu.mp3");
		gunShot = getAudio("res/sound/Pistol_Shot.mp3");
		gameSong=getAudio("res/sound/gameSoundtack.mp3");
		reload=getAudio("res/sound/Reloading.mp3");
		killSound=getAudio("res/sound/Kill Bonus DM .mp3");
		winSound=getAudio("res/sound/CS_Win.mp3");
		enemy_winSound=getAudio("res/sound/Terrorists_win.mp3");

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
		System.out.println(identifier);
	}
}
