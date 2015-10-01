package stacktests;

/**
 *
 * @author juha
 */
import java.lang.reflect.Array;


public class SimpleStack<E> {

    private int size;
    private E[] stack;
    private int top; // topmost element in the stack is returned

    public SimpleStack(Class<E> c, int s) {
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

    public E pop() {
        return stack[top--];
    }

    public E peek() {
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    public static void main(String[] args) {
        
        SimpleStack<Integer> intStack = new SimpleStack(Integer.class, (10));
        
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
        intStack.peek();
        intStack.peek();

        while (!intStack.isEmpty()) {
            int value = intStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();
        
        int value = intStack.pop(); // exception not handled!
    }
}
