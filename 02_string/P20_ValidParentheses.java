import java.util.Stack;

public class P20_ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String[] probs = {
            "()",
            "()[]{}",
            "(]",
            "([)]",
            "{[]}"
        };
        for (String s: probs) {
            System.out.println(isValid(s));
        }
    }
}