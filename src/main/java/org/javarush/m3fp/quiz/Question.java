package org.javarush.m3fp.quiz;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.isNull;

public class Question {
    private final String question;
    private final List<String> answers;
    private final String correctAnswer;

    public Question(String question, List<String> answers, String correctAnswer) {
        if (isNull(question)) {
            throw new IllegalArgumentException("Question cannot be null.");
        } else if (question.isBlank()) {
            throw new IllegalArgumentException("Question cannot be blank.");
        }
        if (isNull(answers)) {
            throw new IllegalArgumentException("Answers cannot be null.");
        } else if (answers.stream().anyMatch(Objects::isNull)) {
            throw new IllegalArgumentException("Answers cannot contain null elements.");
        }
        if (isNull(correctAnswer)) {
            throw new IllegalArgumentException("CorrectAnswer cannot be null.");
        } else if (correctAnswer.isBlank()) {
            throw new IllegalArgumentException("CorrectAnswer cannot be blank.");
        }

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
        return userAnswer.equals(question.getCorrectAnswer());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(question, question1.question) && Objects.equals(answers, question1.answers) && Objects.equals(correctAnswer, question1.correctAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, answers, correctAnswer);
    }
}
