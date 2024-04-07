import org.junit.Test;

public class Palindrome {
    public Deque<Character> wordToDeque(String word){
        Deque<Character> deque=new ArrayDeque<Character>();
        for (int i=0;i<word.length();i++){
            char c = word.charAt(i);
            deque.addLast(c);
        }
        return deque;

    }
    public boolean isPalindrome(String word){
        if (word==null ||word.length()<=1 ){
            return true;
        }
        else {
            Deque<Character> deque=wordToDeque(word);
            while (deque.size()>1){
                if (deque.removeFirst()!=deque.removeLast()){
                    return false;
                }

            }
            return true;
        }
    }
    public boolean isPalindrome(String word, CharacterComparator cc){
        Deque<Character> deque=wordToDeque(word);
        while (deque.size()>1){
            char a=deque.removeFirst();
            char b=deque.removeLast();
            if (!cc.equalChars(a,b)){
                return false;
            }
        }
        return true;

    }
}
