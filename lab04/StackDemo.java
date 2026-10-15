import java.util.ArrayList;

/**
 * Lab 4 - Challenge exercise: composition instead of inheritance.
 *
 * BAD DESIGN: InheritedStack extends ArrayList.
 * It "is-a" ArrayList, so it wrongly exposes ALL list methods:
 * add(index, item), remove(index), get(index), set(...), clear()...
 * Anyone can then break the last-in-first-out rule of a stack.
 *
 * GOOD DESIGN: Stack HAS-A private ArrayList.
 * It only offers push, pop, peek, isEmpty and size. Nothing else is reachable.
 */

// ---------- Bad: inheritance ----------
class InheritedStack extends ArrayList<Integer> {
    void push(int value) { add(value); }
    int pop() { return remove(size() - 1); }
}

// ---------- Good: composition ----------
class Stack {
    private final ArrayList<Integer> items = new ArrayList<>();   // hidden inside

    void push(int value) {
        items.add(value);
    }

    int pop() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.remove(items.size() - 1);
    }

    int peek() {
        if (items.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return items.get(items.size() - 1);
    }

    boolean isEmpty() { return items.isEmpty(); }
    int size()        { return items.size(); }
}

public class StackDemo {
    public static void main(String[] args) {
        // The inherited version lets us cheat
        InheritedStack bad = new InheritedStack();
        bad.push(1);
        bad.push(2);
        bad.push(3);
        bad.add(0, 99);   // inserts at the BOTTOM: not allowed for a real stack!
        System.out.println("Inherited stack after bad.add(0, 99): " + bad);
        System.out.println("It also exposes bad.get(1) = " + bad.get(1));

        // The composed version only allows stack operations
        Stack good = new Stack();
        good.push(1);
        good.push(2);
        good.push(3);
        System.out.println("Top is " + good.peek());
        System.out.println("Pop gives " + good.pop());
        System.out.println("Pop gives " + good.pop());
        System.out.println("Size is now " + good.size());
        // good.add(0, 99);   // ERROR: Stack has no add() method
    }
}
