package advancedJava;

// Lambda expressions are basically functions that are not within a class. They are treated as values

public class lambdaExpressions {

    interface Sayable{
        public String say(String name);
    }

    public static void main(String[] args) {
        
        // Here the lambda expression takes the interface type and has a value of a function. () is the function parameters , -> shows we got a lambda and in {} we have
        // the function contents
        Sayable lambdaExpression = (name)->{
            return "Hello " + name;
        };
        System.out.println(lambdaExpression.say("Nick"));

    }

}


