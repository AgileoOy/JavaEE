package stacktests;

/**
 *
 * @author juha
 */
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SimpleStack4<E> {

    private int size;
    private E[] stack;
    private int top; // topmost element in the stack is returned

    public SimpleStack4(Class<E> c, int s) {
        // Use Array native method to create array of a type only known at run time
        @SuppressWarnings("unchecked")
        E[] tempArr = (E[]) Array.newInstance(c, s);
        assert s > 0;
        size = s;
        this.stack = tempArr;
        top = -1;
    }

    public void push(E j) {
        if (top+1 >= stack.length) {
            ensureCapacity();
        }
        assert top <= size;
        stack[++top] = j;
        
        System.out.println("top index: " + top);
    }

    public E pop() {
        assert top >= 0;
        return stack[top--];
    }

    public E peek() {
        assert top >= 0;
        return stack[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == size - 1);
    }

    /**
     * to reserve more capacity of array
     */
    private void ensureCapacity() {
        System.out.println("current len: " + stack.length);
        int currentLen = stack.length;
        size = currentLen * 2;
        stack = Arrays.copyOf(stack, size);
        // Assertion to test that the capacity*2 is ensured
    }

    public static void main(String[] args) {

        SimpleStack4<Integer> intStack = new SimpleStack4(Integer.class, (10));

        // push some elements in to the stack
            intStack.push(1);
            intStack.push(2);
            intStack.push(3);
            intStack.push(4);
            intStack.push(5);
            intStack.push(6);
            intStack.push(7);
            intStack.push(8);
            intStack.push(9);
            intStack.push(10);
            intStack.push(11);
            intStack.push(12);
        // peek couple of times
        System.out.println("topmost element: " + intStack.peek());
        System.out.println("topmost element: " + intStack.peek());

        while (!intStack.isEmpty()) {
            int value = -1;
            value = intStack.pop();
            System.out.print(value + " ");
            System.out.println();
        }

        // Now it is mandatory to handle checked Exception
        int value2 = intStack.peek();
        int value3 = intStack.pop();
    }
}
