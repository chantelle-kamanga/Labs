/**
 * Lab 4 - Basic exercises
 *  1. Person (name, age) and Student extends Person (adds course). Print both using an inherited display().
 *  2. Add a Teacher subclass and show that Student and Teacher share the Person code.
 */
class Person {
    protected String name;
    protected int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Written ONCE here, used by every subclass
    void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// EXPLAIN: Student IS-A Person, so it gets name, age and display() for free
class Student extends Person {
    private String course;

    Student(String name, int age, String course) {
        super(name, age);   // run the Person constructor first
        this.course = course;
    }

    void showCourse() {
        System.out.println(name + " studies " + course);
    }
}

// Teacher is also a Person, so it reuses exactly the same Person code
class Teacher extends Person {
    private String subject;

    Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }

    void showSubject() {
        System.out.println(name + " teaches " + subject);
    }
}

public class InheritanceDemo {
    public static void main(String[] args) {
        Person p = new Person("Mr Moyo", 45);
        Student s = new Student("Anesu", 20, "Software Engineering");
        Teacher t = new Teacher("Mrs Dube", 38, "Databases");

        // All three use the SAME display() method, written once in Person
        p.display();
        s.display();
        t.display();

        // Each subclass adds its own extra behaviour
        s.showCourse();
        t.showSubject();
    }
}
