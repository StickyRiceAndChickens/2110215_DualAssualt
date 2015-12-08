package render;

import java.applet.Applet;
import java.applet.AudioClip;

public class AudioUtility {
	private static AudioClip acSampleUse;

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
		acSampleUse = getAudio("res/sound/shoot.wav");

	}

	public static void playSound(String identifier) {
		/* to Play sound from identifier */
		switch (identifier) {
		case "sample":
			acSampleUse.play();
			break;
		default:
			break;
		}
	}
}
