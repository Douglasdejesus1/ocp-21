package chapter09;

import java.util.*;

public class DequeClass {
    public static void main(String[] args) {

        final Deque<Integer> deque = new ArrayDeque<>(4);
        deque.add(1);
        deque.add(2);
        deque.add(3);
        deque.add(4);
        System.out.println(deque);
        deque.remove();//adicionado mais antigo head, exception
        System.out.println(deque);
        deque.poll();//adicionado mais antigo, null
        System.out.println(deque);
        deque.offer(7);//null
        deque.addFirst(6);
        deque.add(5);//exception
        Integer element = deque.element();//exception
        Integer peek = deque.peek();//null
        System.out.println(element);//recupera sem remover recente
        System.out.println(peek);//recupera sem remover recente
        System.out.println(deque);

    }

}

class DequeStack {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("A");      // [A]
        System.out.println(queue);
        queue.add("B");      // [A, B]
        System.out.println(queue);
        queue.add("C");      // [A, B, C]
        System.out.println(queue);
        System.out.println(queue.peek()); // [B, C]
        queue.remove(); // [B, C]
        System.out.println(queue);
        queue.poll();   // [C]
        System.out.println(queue);

        Stack<String> stack1 = new Stack<>();
        final Deque<String> stack = new ArrayDeque<>();
        stack.push("a"); //[a]
        System.out.println(stack);
        stack.push("b");//[b,a]
        System.out.println(stack);
        stack.push("c");//[c,b,a]
        System.out.println(stack);
        stack.pop();//[b,a]
        System.out.println(stack.peek());//[b,a]
        System.out.println(stack);
        stack.pop();//[a]
        System.out.println(stack);
    }
}