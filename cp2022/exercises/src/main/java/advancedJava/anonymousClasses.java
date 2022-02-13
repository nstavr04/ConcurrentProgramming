package advancedJava;

// We use anonymous classes if we want to use a local class only once

public class anonymousClasses {
    public static void main(String[] args) {
        
    }

    interface HelloWorld {
        public void greet();
        public void greetSomeone(String someone);
    }

    // frenchGreeting is an anonymous class. It is like an expression.
    // Here the anonymous class is implementing the interface hello. It can use a class to extend as well.
    // You cannot declare constructors in an anonymous class
    HelloWorld frenchGreeting = new HelloWorld() {
        String name = "tout le monde";
        public void greet() {
            greetSomeone("tout le monde");
        }
        public void greetSomeone(String someone) {
            name = someone;
            System.out.println("Salut " + name);
        }
    };
}
