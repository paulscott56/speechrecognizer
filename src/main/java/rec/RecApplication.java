package rec;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.sound.sampled.UnsupportedAudioFileException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RecApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecApplication.class, args);
	}

	@Bean
	public void getRecced() throws UnsupportedAudioFileException, IOException {
		// Create a new recognizer instance defining the audio sample rate to be
		// used
		Recognizer<String> recognizer = new Recognizer<>(16000.0f);

		VoicePrint print = recognizer.createVoicePrint("Elvis", new File("OldInterview.wav"));

		// handle persistence the way you want, e.g.:
		// myUser.setVocalPrint(print);
		// userDao.saveOrUpdate(myUser);

		// Now check if the King is back
		List<MatchResult<String>> matches = recognizer.identify(new File("SomeFatGuy.wav"));
		MatchResult<String> match = matches.get(0);

		if (match.getKey().equals("Elvis")) {
			System.out.println("Elvis is back !!! " + match.getLikelihoodRatio() + "% positive about it...");
		}
	}
}
