package org.javarush.m3fp.quiz;

import java.util.List;

public class Question {
    private final String question;
    private final List<String> answers;
    private final String correctAnswer;

    public Question(String question, List<String> answers, String correctAnswer) {
        this.question = question;
        this.answers = answers;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    public boolean checkAnswer(Question question, String userAnswer) {
        // Метод для проверки ответа пользователя на вопрос
        return userAnswer.equals(question.getCorrectAnswer());
    }
}
