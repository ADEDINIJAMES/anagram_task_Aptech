package info.aptech_uyo.anagram;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class AnagramApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	void contextLoads() {
	}

	@ParameterizedTest
	@CsvSource({
		"foefet,toffee,foefet is an anagram of toffee",
		"Buckethead,DeathCubeK,Buckethead is an anagram of DeathCubeK",
		"Twoo,WooT,Twoo is an anagram of WooT",
		"dumble,bumble,dumble is not an anagram of bumble",
		"ound,round,ound is not an anagram of round",
		"apple,pale,apple is not an anagram of pale"
	})
	public void givenWords_whenDetect_thenCheckIfTheyAreAnagrams(
		String word,
		String testWord,
		String response) throws Exception {
		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
		params.add("word", word);
		params.add("testWord", testWord);

		mvc.perform(get("/detect").params(params))
			.andExpect(status().isOk())
			.andExpect(content().string(response));
	}

}
