public class PalindromeChecker {
    public boolean isPalindrome(String input) {
        String cleaned = input.replaceAll(" ", "").toLowerCase(); // remove spaces and convert to lowercase for fair comparison
        return checkPalindrome(cleaned, 0, cleaned.length() -1); // recursive check
    }

    private boolean checkPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;  // if left has passed right, all characters matched → it's a palindrome
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false; // If the characters at both ends don't match → not a palindrome
        }
        return checkPalindrome(s, left + 1, right - 1); // move both pointers inward and check the next pair
    }

    public static void main(String[] args) {
        PalindromeChecker checker = new PalindromeChecker();

        System.out.println(checker.isPalindrome("Race car")); // true
        System.out.println(checker.isPalindrome("Hello")); // false
        System.out.println(checker.isPalindrome("Uosm msou"));
    }
}