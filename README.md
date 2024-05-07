# Techplement
Quiz Generator

Introduction:
The Quiz Generator is a command-line application written in Java that allows users to take quizzes on various subjects including Science, Maths, and General Knowledge. Users can select a subject, take a quiz, and receive immediate feedback on their answers.

Features:
Quiz Creation: Quizzes for different subjects are predefined with multiple-choice questions.
User Interaction: Users can select a subject and take a quiz by providing their answers through the command line.
Immediate Feedback: Users receive immediate feedback on their answers during the quiz.
Score Display: At the end of the quiz, users are shown their score and the total number of questions answered correctly.
Classes:
Question
Represents a single quiz question with the question statement, multiple-choice options, and the correct answer.

Attributes:
question: String - The question statement.
options: List<String> - List of multiple-choice options.
correctAnswer: String - The correct answer to the question.
Methods:
getQuestion(): String - Returns the question statement.
getOptions(): List<String> - Returns the list of multiple-choice options.
getCorrectAnswer(): String - Returns the correct answer.
Quiz:
Represents a quiz for a specific subject, containing a list of questions.

Attributes:
name: String - The name of the quiz (e.g., "Science", "Maths", "General Knowledge").
questions: List<Question> - List of questions in the quiz.
Methods:
addQuestion(Question question): Adds a question to the quiz.
takeQuiz(): Allows the user to take the quiz, providing immediate feedback on answers.
QuizGenerator
Main class containing the entry point of the application.

Methods:
main(String[] args): Entry point of the application. Prompts the user to select a subject and initiates the corresponding quiz.
