/**
 * Lab 4 - Intermediate exercise: why 'class Dog extends Animal' can fail to compile.
 *
 * Animal only has the constructor Animal(String name), so there is NO no-argument constructor.
 */
class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }
}

/*
 * THIS VERSION DOES NOT COMPILE:
 *
 *     class Dog extends Animal { }
 *
 * javac reports:
 *     constructor Animal in class Animal cannot be applied to given types;
 *     required: String   found: no arguments
 *
 * WHY: if a subclass does not call super(...), Java secretly inserts super().
 * Animal has no Animal() constructor, so that hidden call fails.
 * (Java only gives you a free no-argument constructor when you write NO constructor at all.
 *  Animal wrote one, so the free one disappeared.)
 */

// FIX 1: call the parent constructor explicitly with super(name)
class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
}

// FIX 2 (alternative): give Animal a no-argument constructor too

public class AnimalErrorDemo {
    public static void main(String[] args) {
        Dog d = new Dog("Rex");
        System.out.println("Dog created, name = " + d.name);
    }
}
