package stacktests;

/**
 *
 * @author juha
 */
import java.lang.reflect.Array;


public class SimpleStack2<E> {

    private int size;
    private E[] stack;
    private int top; // topmost element in the stack is returned

    public SimpleStack2(Class<E> c, int s) {
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
        if (top == -1) {
            throw new RuntimeException("Stack is empty!");
        }
        return stack[top--];
    }

    public E peek() {
        if (top == -1) {
            throw new RuntimeException("Stack is empty!");
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

        SimpleStack2<Integer> intStack = new SimpleStack2(Integer.class, (10));

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
            int value = intStack.pop();
            System.out.print(value + " ");
        }
        System.out.println();

        int value = intStack.pop(); // exception not handled!
    }
}
