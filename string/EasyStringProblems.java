package string;

public class EasyStringProblems {

    // EASY QUESTIONS (1-30)

    /**
     * Question 1: String Length
     * Difficulty: Easy
     * 
     * Given a string str, return the length of the string.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: 5
     * 
     * Example 2:
     * Input: str = "Java Programming"
     * Output: 16
     */
    static public int stringLength(String str) {
        int length = 0;
        for (int i = 0; i < str.length(); i++) {
            length++;
        }
        return length;
    }

    /**
     * Question 2: Convert to Uppercase
     * Difficulty: Easy
     * 
     * Given a string str, convert all characters to uppercase and return it.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: "HELLO"
     * 
     * Example 2:
     * Input: str = "Java"
     * Output: "JAVA"
     */
    static public String toUpperCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                ch = (char) (ch - ('a' - 'A'));
            }
            sb.append(ch);

        }
        return sb.toString();
    }

    /**
     * Question 3: Convert to Lowercase
     * Difficulty: Easy
     * 
     * Given a string str, convert all characters to lowercase and return it.
     * 
     * Example 1:
     * Input: str = "HELLO"
     * Output: "hello"
     * 
     * Example 2:
     * Input: str = "WORLD"
     * Output: "world"
     */
    static public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch - ('A' - 'a'));
            }
            sb.append(ch);

        }
        return sb.toString();
    }

    /**
     * Question 4: Reverse a String
     * Difficulty: Easy
     * 
     * Given a string str, reverse it and return the reversed string.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: "olleh"
     * 
     * Example 2:
     * Input: str = "Java"
     * Output: "avaJ"
     */
    static public String reverseString(String str) {
        char[] a = str.toCharArray();
        int i = 0, j = a.length - 1;

        while (i < j) {
            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return new String(a);
    }

    /**
     * Question 5: Check if Palindrome
     * Difficulty: Easy
     * 
     * Given a string str, return true if it reads the same forwards and backwards,
     * otherwise return false.
     * 
     * Example 1:
     * Input: str = "racecar"
     * Output: true
     * 
     * Example 2:
     * Input: str = "hello"
     * Output: false
     */
    static public boolean isPalindrome(String str) {
        return str.equals(reverseString(str));
    }

    /**
     * Question 6: Count Vowels
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of vowels (a, e, i, o, u).
     * Consider both uppercase and lowercase.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: 2
     * Explanation: 'e' and 'o' are vowels
     * 
     * Example 2:
     * Input: str = "Programming"
     * Output: 3
     * Explanation: 'o', 'a', 'i' are vowels
     */
    static public int countVowels(String str) {
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) != -1)
                count++;
        }
        return count;
    }

    /**
     * Question 7: Count Consonants
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of consonants.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: 3
     * Explanation: 'h', 'l', 'l' are consonants
     * 
     * Example 2:
     * Input: str = "aeiou"
     * Output: 0
     */
    static public int countConsonants(String str) {
        String vowels = "aeiou";
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (vowels.indexOf(ch) == -1)
                count++;
        }
        return count;
    }

    /**
     * Question 8: Count Words
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of words.
     * Words are separated by spaces.
     * 
     * Example 1:
     * Input: str = "Hello World"
     * Output: 2
     * 
     * Example 2:
     * Input: str = "I love Java programming"
     * Output: 4
     */
    static public int countWords(String str) {
        int count = 0;
        str = str.trim();
        boolean inWord = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                if (!inWord) {
                    count++;
                    inWord = true;
                }
            } else {
                inWord = false;
            }
        }
        return count;
    }

    /**
     * Question 9: Count Spaces
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of spaces.
     * 
     * Example 1:
     * Input: str = "Hello World"
     * Output: 1
     * 
     * Example 2:
     * Input: str = "I love Java"
     * Output: 2
     */
    static public int countSpaces(String str) {
        int spaces = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                spaces++;
            }
        }
        return spaces;
    }

    /**
     * Question 10: Count Digits
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of digit characters.
     * 
     * Example 1:
     * Input: str = "hello123"
     * Output: 3
     * 
     * Example 2:int
     * Input: str = "abc"
     * Output: 0
     */
    static public int countDigits(String str) {
        int digitCount = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '0' && ch <= '9')
                digitCount++;
        }
        return digitCount;
    }

    /**
     * Question 11: First Character
     * Difficulty: Easy
     * 
     * Given a string str, return the first character.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: 'h'
     * 
     * Example 2:
     * Input: str = "Java"
     * Output: 'J'
     */
    static public char firstCharacter(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != ' ') {
                return ch;
            }
        }
        return '\0';
    }

    /**
     * Question 12: Last Character
     * Difficulty: Easy
     * 
     * Given a string str, return the last character.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: 'o'
     * 
     * Example 2:
     * Input: str = "Java"
     * Output: 'a'
     */
    static public char lastCharacter(String str) {
        int s = str.length();
        for (int i = s - 1; i >= 0; i--) {
            char ch = str.charAt(i);
            if (ch != ' ')
                return ch;
        }
        return '\0';
    }

    /**
     * Question 13: Character at Index
     * Difficulty: Easy
     * 
     * Given a string str and an integer index, return the character at that index.
     * 
     * Example 1:
     * Input: str = "hello", index = 2
     * Output: 'l'
     * 
     * Example 2:
     * Input: str = "Java", index = 0
     * Output: 'J'
     */
    static public char charAt(String str, int index) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (i == index)
                return ch;
        }
        return '\0';
    }

    /**
     * Question 14: String Concatenation
     * Difficulty: Easy
     * 
     * Given two strings str1 and str2, concatenate them and return the result.
     * 
     * Example 1:
     * Input: str1 = "Hello", str2 = "World"
     * Output: "HelloWorld"
     * 
     * Example 2:
     * Input: str1 = "Java", str2 = "Programming"
     * Output: "JavaProgramming"
     */
    static public String concatenate(String str1, String str2) {
        return str1.concat(str2);
    }

    /**
     * Question 15: String Comparison
     * Difficulty: Easy
     * 
     * Given two strings str1 and str2, return true if they are equal,
     * otherwise return false.
     * 
     * Example 1:
     * Input: str1 = "hello", str2 = "hello"
     * Output: true
     * 
     * Example 2:
     * Input: str1 = "hello", str2 = "world"
     * Output: false
     */
    static public boolean areEqual(String str1, String str2) {
        int s1 = str1.length();
        int s2 = str2.length();

        if (s1 != s2)
            return false;

        for (int i = 0; i < s1; i++) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(i);
            if (ch1 != ch2)
                return false;
        }
        return true;
    }

    /**
     * Question 16: String Contains Substring
     * Difficulty: Easy
     * 
     * Given a string str and a substring sub, return true if str contains sub,
     * otherwise return false.
     * 
     * Example 1:
     * Input: str = "hello world", sub = "world"
     * Output: true
     * 
     * Example 2:
     * Input: str = "Java Programming", sub = "Python"
     * Output: false
     */
    static public boolean containsSubstring(String str, String sub) {
        // Your code here
        return false;
    }

    /**
     * Question 17: Index of Substring
     * Difficulty: Easy
     * 
     * Given a string str and a substring sub, return the first index where
     * sub starts in str. Return -1 if not found.
     * 
     * Example 1:
     * Input: str = "hello world", sub = "world"
     * Output: 6
     * 
     * Example 2:
     * Input: str = "Java Programming", sub = "Python"
     * Output: -1
     */
    static public int indexOfSubstring(String str, String sub) {
        // Your code here
        return -1;
    }

    /**
     * Question 18: Replace Character
     * Difficulty: Easy
     * 
     * Given a string str, a character oldChar, and a character newChar,
     * replace all occurrences of oldChar with newChar.
     * 
     * Example 1:
     * Input: str = "hello", oldChar = 'l', newChar = 'x'
     * Output: "hexxo"
     * 
     * Example 2:
     * Input: str = "Java", oldChar = 'a', newChar = 'o'
     * Output: "Jovo"
     */
    static public String replaceChar(String str, char oldChar, char newChar) {
        // Your code here
        return "";
    }

    /**
     * Question 19: Remove Spaces
     * Difficulty: Easy
     * 
     * Given a string str, remove all spaces and return the result.
     * 
     * Example 1:
     * Input: str = "Hello World"
     * Output: "HelloWorld"
     * 
     * Example 2:
     * Input: str = "I love Java"
     * Output: "IloveJava"
     */
    static public String removeSpaces(String str) {
        // Your code here
        return "";
    }

    /**
     * Question 20: Count Character Occurrences
     * Difficulty: Easy
     * 
     * Given a string str and a character ch, count how many times ch appears.
     * 
     * Example 1:
     * Input: str = "hello", ch = 'l'
     * Output: 2
     * 
     * Example 2:
     * Input: str = "programming", ch = 'm'
     * Output: 2
     */
    static public int countCharOccurrences(String str, char ch) {
        // Your code here
        return 0;
    }

    /**
     * Question 21: String Starts With
     * Difficulty: Easy
     * 
     * Given a string str and a prefix, return true if str starts with prefix.
     * 
     * Example 1:
     * Input: str = "hello world", prefix = "hello"
     * Output: true
     * 
     * Example 2:
     * Input: str = "Java Programming", prefix = "Python"
     * Output: false
     */
    static public boolean startsWith(String str, String prefix) {
        // Your code here
        return false;
    }

    /**
     * Question 22: String Ends With
     * Difficulty: Easy
     * 
     * Given a string str and a suffix, return true if str ends with suffix.
     * 
     * Example 1:
     * Input: str = "hello world", suffix = "world"
     * Output: true
     * 
     * Example 2:
     * Input: str = "Java Programming", suffix = "Java"
     * Output: false
     */
    static public boolean endsWith(String str, String suffix) {
        // Your code here
        return false;
    }

    /**
     * Question 23: Trim String
     * Difficulty: Easy
     * 
     * Given a string str, remove leading and trailing spaces.
     * 
     * Example 1:
     * Input: str = " hello "
     * Output: "hello"
     * 
     * Example 2:
     * Input: str = " Java "
     * Output: "Java"
     */
    static public String trimString(String str) {
        // Your code here
        return "";
    }

    /**
     * Question 24: Substring Extraction
     * Difficulty: Easy
     * 
     * Given a string str, a start index and an end index, extract and return
     * the substring from start to end (exclusive).
     * 
     * Example 1:
     * Input: str = "hello world", start = 0, end = 5
     * Output: "hello"
     * 
     * Example 2:
     * Input: str = "Java Programming", start = 5, end = 16
     * Output: "Programming"
     */
    static public String substring(String str, int start, int end) {
        // Your code here
        return "";
    }

    /**
     * Question 25: String to Character Array
     * Difficulty: Easy
     * 
     * Given a string str, convert it to a character array and return it.
     * 
     * Example 1:
     * Input: str = "hello"
     * Output: ['h', 'e', 'l', 'l', 'o']
     * 
     * Example 2:
     * Input: str = "Java"
     * Output: ['J', 'a', 'v', 'a']
     */
    static public char[] toCharArray(String str) {
        // Your code here
        return new char[] {};
    }

    /**
     * Question 26: Toggle Case
     * Difficulty: Easy
     * 
     * Given a string str, toggle the case of each character
     * (uppercase to lowercase and vice versa).
     * 
     * Example 1:
     * Input: str = "Hello"
     * Output: "hELLO"
     * 
     * Example 2:
     * Input: str = "JaVa"
     * Output: "jAvA"
     */
    static public String toggleCase(String str) {
        // Your code here
        return "";
    }

    /**
     * Question 27: Count Uppercase Letters
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of uppercase letters.
     * 
     * Example 1:
     * Input: str = "Hello World"
     * Output: 2
     * Explanation: 'H' and 'W' are uppercase
     * 
     * Example 2:
     * Input: str = "JAVA"
     * Output: 4
     */
    static public int countUppercase(String str) {
        // Your code here
        return 0;
    }

    /**
     * Question 28: Count Lowercase Letters
     * Difficulty: Easy
     * 
     * Given a string str, count and return the number of lowercase letters.
     * 
     * Example 1:
     * Input: str = "Hello World"
     * Output: 8
     * Explanation: All letters except 'H' and 'W' are lowercase
     * 
     * Example 2:
     * Input: str = "java"
     * Output: 4
     */
    static public int countLowercase(String str) {
        // Your code here
        return 0;
    }

    /**
     * Question 29: Repeat String
     * Difficulty: Easy
     * 
     * Given a string str and an integer n, repeat the string n times.
     * 
     * Example 1:
     * Input: str = "ha", n = 3
     * Output: "hahaha"
     * 
     * Example 2:
     * Input: str = "Java", n = 2
     * Output: "JavaJava"
     */
    static public String repeatString(String str, int n) {
        // Your code here
        return "";
    }

    /**
     * Question 30: Is Empty or Null
     * Difficulty: Easy
     * 
     * Given a string str, return true if it is null or empty, otherwise false.
     * 
     * Example 1:
     * Input: str = ""
     * Output: true
     * 
     * Example 2:
     * Input: str = "hello"
     * Output: false
     */
    static public boolean isEmptyOrNull(String str) {
        // Your code here
        return false;
    }

    // Main method for testing
    public static void main(String[] args) {

        System.out.println();
        String str1 = "Java DSA";
        System.out.println("Q1 --> " + stringLength(str1));

        String str2 = "Java DSA";
        System.out.println("Q2 --> " + toUpperCase(str2));

        String str3 = "JAVA DSA";
        System.out.println("Q3 --> " + toLowerCase(str3));

        String str4 = "Java DSA";
        System.out.println("Q4 --> " + reverseString(str4));

        String str5 = "abcba";
        System.out.println("Q5 --> " + isPalindrome(str5));

        String str6 = "ibcba";
        System.out.println("Q6 --> " + countVowels(str6));

        String str7 = "aeiog";
        System.out.println("Q7 --> " + countConsonants(str7));

        String str8 = "Hello world";
        System.out.println("Q8 --> " + countWords(str8));

        String str9 = "Hello world";
        System.out.println("Q9 --> " + countSpaces(str9));

        String str10 = "Hello world";
        System.out.println("Q10 --> " + countDigits(str10));

        String str11 = "Hello";
        System.out.println("Q11 --> " + firstCharacter(str11));

        String str12 = "vamos";
        System.out.println("Q12 --> " + lastCharacter(str12));

        String str13 = "vamos";
        System.out.println("Q13 --> " + charAt(str13, 2));

        System.out.println("Q14 --> " + concatenate("visca", " barca"));

        System.out.println("Q15 --> " + areEqual("acc", "abc"));
    }
}