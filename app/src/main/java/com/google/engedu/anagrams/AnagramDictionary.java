/*
 *  Copyright 2016 Google Inc. All Rights Reserved.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.google.engedu.anagrams;

import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class AnagramDictionary {

    private static final int MIN_NUM_ANAGRAMS = 5;
    private static final int DEFAULT_WORD_LENGTH = 3;
    private static final int MAX_WORD_LENGTH = 7;
    private Random random = new Random();

    private HashMap<String, ArrayList<String>> lettersToWord = new HashMap<>();
    private List<String> dictionary = new ArrayList<>();

    public AnagramDictionary(InputStream wordListStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(wordListStream));
        String line;
        while((line = in.readLine()) != null) {
            String word = line.trim();
            dictionary.add(word);
        }
    }

    // true when word is base's anagram but word is not base
    public boolean isGoodWord(String word, String base) {
        return isAnagram(word.toUpperCase(), base.toUpperCase()) && !word.equals(base);
    }

    public List<String> getAnagrams(String targetWord) {
        ArrayList<String> result = new ArrayList<String>();
        for (String word: dictionary) {
            if (isAnagram(word, targetWord)) {
                result.add(word);
            }
        }
        return result;
    }

    @VisibleForTesting
    static boolean isAnagram(String first, String second) {
        return sortLetters(first).equals(sortLetters(second));
    }

    @VisibleForTesting
    static String sortLetters(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    public List<String> getAnagramsWithOneMoreLetter(String word) {
        ArrayList<String> result = new ArrayList<String>();
        //
        // Your code here
        //
        return getAnagrams(word);
    }

    public String pickGoodStarterWord() {
        //
        // Your code here
        //
        return "stop";
    }
}
