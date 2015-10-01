package stacktests;

/**
 *
 * @author juha
 */

import java.lang.reflect.Array;
import java.util.logging.Level;
import java.util.logging.Logger;


class StackEmptyException extends Exception {

    public StackEmptyException(String msg) {
        super(msg);
    }
    
}

public class SimpleStack3<E> {

    private int size;
    private E[] stack;
    private int top; // topmost element in the stack is returned

    public SimpleStack3(Class<E> c, int s) {
        // Use Array native method to create array of a type only known at run time
        @SuppressWarnings("unchecked")
        E[] tempArr = (E[]) Array.newInstance(c, s);
        size = s;
        this.stack = tempArr;
        top = -1;
    }

    public void push(E j) {
        stack[++top] = j;
    }

    public E pop() throws StackEmptyException {
        if (top == -1) {
            throw new StackEmptyException("Stack is empty!");
        }
        return stack[top--];
    }

    public E peek() {
        if (top == -1) {
            try {
                throw new StackEmptyException("Stack is empty!");
            } catch (StackEmptyException ex) {
                Logger.getLogger(SimpleStack3.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public static void main(String[] args) {

        SimpleStack3<Integer> intStack = new SimpleStack3(Integer.class, (10));

        // push some elements in to the stack
        if (!intStack.isFull()) {
            intStack.push(1);
        }
        if (!intStack.isFull()) {
            intStack.push(2);
        }
        if (!intStack.isFull()) {
            intStack.push(3);
        }
        if (!intStack.isFull()) {
            intStack.push(4);
        } else {
            System.out.println("Stack is full!");
        }
        // peek couple of times
        System.out.println("topmost element: " + intStack.peek());
        System.out.println("topmost element: " + intStack.peek());
        

        while (!intStack.isEmpty()) {
            int value=-1;
            try {
                value = intStack.pop();
            } catch (StackEmptyException ex) {
                Logger.getLogger(SimpleStack3.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.print(value + " ");
        }
        System.out.println();

        // Now it is mandatory to handle checked Exception
        try {
            int value2 = intStack.peek();
            int value = intStack.pop(); 
        } catch (StackEmptyException ex) {
            Logger.getLogger(SimpleStack3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
