class Solution {
    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
    }

    public long countOfSubstrings(String word, int k) {
        long res = 0;
        int start = 0, end = 0;
        HashMap<Character, Integer> vowels = new HashMap<>();
        int consonants = 0;
        int nextConsonant[] = new int[word.length()];
        int nextcindex = word.length();
        for (int i = word.length() - 1; i >= 0; i--) {
            nextConsonant[i] = nextcindex;
            if (!isVowel(word.charAt(i)))
                nextcindex = i;
        }
        while (end < word.length()) {
            char newLetter = word.charAt(end);
            if (isVowel(newLetter))
                vowels.put(newLetter, vowels.getOrDefault(newLetter, 0) + 1);
            else
                consonants++;
            while (consonants > k) {
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowels.put(startLetter, vowels.getOrDefault(startLetter, 0) - 1);
                    if (vowels.get(startLetter) == 0) {
                        vowels.remove(startLetter);
                    }
                } else {
                    consonants--;
                }
                start++;
            }
            while (start < word.length() && vowels.keySet().size() == 5 && consonants == k) {
                res += nextConsonant[end] - end;
                char startLetter = word.charAt(start);
                if (isVowel(startLetter)) {
                    vowels.put(startLetter,vowels.get(startLetter) - 1);
                    if (vowels.get(startLetter) == 0)
                        vowels.remove(startLetter);
                } else
                    consonants--;
                start++;
            }
            end++;
        }
        return res;
    }
}