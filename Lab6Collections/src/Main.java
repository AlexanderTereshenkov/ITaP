public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(16);
        System.out.println(stack.peek());
    }
}