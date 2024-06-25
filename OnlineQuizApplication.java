import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    String[] options;
    char correctAnswer;
    String explanation;

    Question(String question, String[] options, char correctAnswer, String explanation) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
        this.explanation = explanation;
    }
}

public class QuizApplication {
    private static List<Question> questions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int score = 0;
    private static List<Question> wrongAnswers = new ArrayList<>();

    public static void main(String[] args) {
        initializeQuestions();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("\nWelcome " + name + " to the Java Quiz!");
        System.out.println("Rules:");
        System.out.println("1. +2 points for each correct answer.");
        System.out.println("2. -1 point for each wrong answer.\n");

        conductQuiz();
        displayResults(name);
    }

    private static void initializeQuestions() {
        questions.add(new Question("Who invented Java Programming?",
                new String[]{"a) Guido van Rossum", "b) James Gosling", "c) Dennis Ritchie", "d) Bjarne Stroustrup"},
                'b',
                "Java programming was developed by James Gosling at Sun Microsystems in 1995. James Gosling is well known as the father of Java."));

        questions.add(new Question("Which statement is true about Java?",
                new String[]{"a) Java is a sequence-dependent programming language", "b) Java is a code dependent programming language", "c) Java is a platform-dependent programming language", "d) Java is a platform-independent programming language"},
                'd',
                "Java is called ‘Platform Independent Language’ as it primarily works on the principle of ‘compile once, run everywhere’."));

        questions.add(new Question("Which component is used to compile, debug and execute the java programs?",
                new String[]{"a) JRE", "b) JIT", "c) JDK", "d) JVM"},
                'c',
                "JDK is a core component of Java Environment and provides all the tools, executables and binaries required to compile, debug and execute a Java Program."));

        questions.add(new Question("Which one of the following is not a Java feature?",
                new String[]{"a) Object-oriented", "b) Use of pointers", "c) Portable", "d) Dynamic and Extensible"},
                'b',
                "Pointers is not a Java feature. Java provides an efficient abstraction layer for developing without using a pointer in Java. Features of Java Programming are Portable, Architectural Neutral, Object-Oriented, Robust, Secure, Dynamic and Extensible, etc."));

        questions.add(new Question("Which of these cannot be used for a variable name in Java?",
                new String[]{"a) identifier & keyword", "b) identifier", "c) keyword", "d) none of the mentioned"},
                'c',
                "Keywords are specially reserved words that can not be used for naming a user-defined variable, for example: class, int, for, etc."));

        questions.add(new Question("What is the extension of java code files?",
                new String[]{"a) .js", "b) .txt", "c) .class", "d) .java"},
                'd',
                "Java files have .java extension."));

        questions.add(new Question("Which environment variable is used to set the java path?",
                new String[]{"a) MAVEN_Path", "b) JavaPATH", "c) JAVA", "d) JAVA_HOME"},
                'd',
                "JAVA_HOME is used to store a path to the java installation."));
	questions.add(new Question("Which of the following is not an OOPS concept in Java?",
                new String[]{"a) Polymorphism", "b) Inheritance", "c) Compilation", "d) Encapsulation"},
                'c',
                "There are 4 OOPS concepts in Java. Inheritance, Encapsulation, Polymorphism and Abstraction."));

        questions.add(new Question("What is not the use of “this” keyword in Java?",
                new String[]{"a) Referring to the instance variable when a local variable has the same name", "b) Passing itself to the method of the same class", "c) Passing itself to another method", "d) Calling another constructor in constructor chaining"},
                'b',
                "“this” is an important keyword in java. It helps to distinguish between local variable and variables passed in the method as parameters."));
    }

    private static void conductQuiz() {
        for (Question q : questions) {
            System.out.println(q.question);
            for (String option : q.options) {
                System.out.println(option);
            }
            System.out.print("Your answer: ");
            char answer = scanner.next().charAt(0);

            if (answer == q.correctAnswer) {
                score += 2;
            } else {
                score -= 1;
                wrongAnswers.add(q);
            }
            System.out.println();
        }
    }

    private static void displayResults(String name) {
        System.out.println("\nQuiz Over!");
        System.out.println("Name: " + name);
        System.out.println("Your Score: " + score);
        if (!wrongAnswers.isEmpty()) {
            System.out.println("\nIncorrect Answers and Explanations:");
            for (Question q : wrongAnswers) {
                System.out.println(q.question);
                System.out.println("Correct Answer: " + q.correctAnswer);
                System.out.println("Explanation: " + q.explanation);
                System.out.println();
            }
        }
    }
}