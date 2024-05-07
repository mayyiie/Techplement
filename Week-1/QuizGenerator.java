import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    private String question;
    private List<String> options;
    private String correctAnswer;

    public Question(String question, List<String> options, String correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}

class Quiz {
    private String name;
    private List<Question> questions;

    public Quiz(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void takeQuiz() {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        int totalQuestions = questions.size();

        System.out.println("Welcome to the " + name + " quiz!\n");

        for (int i = 0; i < totalQuestions; i++) {
            Question q = questions.get(i);
            System.out.println("Question " + (i + 1) + ": " + q.getQuestion());
            List<String> options = q.getOptions();
            for (int j = 0; j < options.size(); j++) {
                System.out.println((char)('A' + j) + ". " + options.get(j));
            }
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().toUpperCase();
            if (userAnswer.equals(q.getCorrectAnswer())) {
                score++;
                System.out.println("Correct!\n");
            } else {
                System.out.println("Incorrect. The correct answer is: " + q.getCorrectAnswer() + "\n");
            }
        }

        System.out.println("Quiz completed!\nYour score: " + score + "/" + totalQuestions);
        scanner.close();
    }
}

public class QuizGenerator {
    public static void main(String[] args) {
        Quiz scienceQuiz = createScienceQuiz();
        Quiz mathsQuiz = createMathsQuiz();
        Quiz generalKnowledgeQuiz = createGeneralKnowledgeQuiz();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Quiz Generator!");
        System.out.println("Select the subject you want to take a quiz on:");
        System.out.println("1. Science");
        System.out.println("2. Maths");
        System.out.println("3. General Knowledge");

        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1:
                scienceQuiz.takeQuiz();
                break;
            case 2:
                mathsQuiz.takeQuiz();
                break;
            case 3:
                generalKnowledgeQuiz.takeQuiz();
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }

    public static Quiz createScienceQuiz() {
        Quiz scienceQuiz = new Quiz("Science");
        scienceQuiz.addQuestion(new Question("What is the powerhouse of the cell?", List.of("A. Ribosome", "B. Nucleus", "C. Mitochondria"), "C"));
        scienceQuiz.addQuestion(new Question("Which gas is responsible for the greenhouse effect?", List.of("A. Oxygen", "B. Carbon Dioxide", "C. Nitrogen"), "B"));
        scienceQuiz.addQuestion(new Question("What is the chemical symbol for gold?", List.of("A. Au", "B. Ag", "C. Fe"), "A"));
        return scienceQuiz;
    }

    public static Quiz createMathsQuiz() {
        Quiz mathsQuiz = new Quiz("Maths");
        mathsQuiz.addQuestion(new Question("What is the result of 5 * 7?", List.of("A. 30", "B. 35", "C. 40"), "B"));
        mathsQuiz.addQuestion(new Question("What is the value of 2^3?", List.of("A. 6", "B. 8", "C. 10"), "B"));
        mathsQuiz.addQuestion(new Question("What is the square root of 81?", List.of("A. 7", "B. 9", "C. 11"), "B"));
        return mathsQuiz;
    }

    public static Quiz createGeneralKnowledgeQuiz() {
        Quiz generalKnowledgeQuiz = new Quiz("General Knowledge");
        generalKnowledgeQuiz.addQuestion(new Question("Who wrote 'To Kill a Mockingbird'?", List.of("A. Harper Lee", "B. J.K. Rowling", "C. Charles Dickens"), "A"));
        generalKnowledgeQuiz.addQuestion(new Question("In which year did the Titanic sink?", List.of("A. 1912", "B. 1921", "C. 1908"), "A"));
        generalKnowledgeQuiz.addQuestion(new Question("What is the world's largest ocean?", List.of("A. Atlantic Ocean", "B. Indian Ocean", "C. Pacific Ocean"), "C"));
        return generalKnowledgeQuiz;
    }
}
