package info.aptech_uyo.anagram;

import info.aptech_uyo.anagram.service.AnagramCheckClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AnagramApplication {
	public static void main(String[] args) {
		SpringApplication.run(AnagramApplication.class, args);
	}
	@Autowired
private AnagramCheckClass anagramCheckClass;
	@GetMapping("/detect")
	public String detect(
		@RequestParam(value = "word", defaultValue = "foefet") String word,
		@RequestParam(value = "testWord", defaultValue = "toffee") String testWord) {


		return word + " is" + (anagramCheckClass.checkAnagram(word,testWord) ? "" : " not") + " an anagram of " + testWord;
	}


}
