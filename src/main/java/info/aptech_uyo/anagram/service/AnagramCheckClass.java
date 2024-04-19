package info.aptech_uyo.anagram.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Objects;

@Service
public class AnagramCheckClass {

    public Boolean checkAnagram (String word, String testWord){
        String wordLowercase= word.toLowerCase();
        String testWordLowerCase = testWord.toLowerCase();

char[]wordA = wordLowercase.toCharArray();
char[]testWordA = testWordLowerCase.toCharArray();
        Arrays.sort(wordA);
        Arrays.sort(testWordA);

return Arrays.equals(wordA, testWordA);

    }
}
