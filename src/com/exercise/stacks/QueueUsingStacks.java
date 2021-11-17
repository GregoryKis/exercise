package com.exercise.stacks;

import java.util.Stack;

public class QueueUsingStacks {

    private Stack<Integer> sIn;
    private Stack<Integer> sOut;

    private void reverseOrder() {
        while (!sIn.empty()) {
            sOut.push(sIn.pop());
        }
    }

    public QueueUsingStacks() {
        sIn = new Stack<>();
        sOut = new Stack<>();
    }

    public void push(int x) {
        sIn.push(x);
    }

    public int pop() {
        if (sOut.empty())
            reverseOrder();
        return sOut.pop();
    }

    public int peek() {
        if (sOut.empty())
            reverseOrder();
        return sOut.peek();
    }

    public boolean empty() {
        return sIn.empty() && sOut.empty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.push(1);
        if (!(queue.peek() == 1))
            System.out.println("Failed push 1");
        if (!(queue.pop() == 1))
            System.out.println("Failed pop 1");
        if (!queue.empty())
            System.out.println("Failed isEmpty 1");

        queue.push(1);
        if (queue.empty())
            System.out.println("Failed isEmpty 2");
        queue.push(2);
        if (queue.empty())
            System.out.println("Failed isEmpty 3");
        queue.push(3);
        if (!(queue.peek() == 1))
            System.out.println("Failed push 2");
        queue.pop();
        if (queue.empty())
            System.out.println("Failed isEmpty 4");
        if (!(queue.peek() == 2))
            System.out.println("Failed push 3");
        queue.pop();
        if (!(queue.peek() == 3))
            System.out.println("Failed push 4");
        if (queue.empty())
            System.out.println("Failed isEmpty 5");
        queue.pop();
        if (!queue.empty())
            System.out.println("Failed isEmpty 6");

    }
}
