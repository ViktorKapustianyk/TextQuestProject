package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;
import org.javarush.m3fp.quiz.QuestionFactory;

import java.util.Arrays;

public class QuestionThree implements QuestionFactory {
    private final String question = "You find an old boat. How do you decide to use it?";
    private final String answer = "Look for other objects on the shore";
    private final String correctAnswer = "Try to go to sea";
    @Override
    public Question createQuestion() {
        return new Question(question, Arrays.asList(answer, correctAnswer), correctAnswer);
    }
//    public boolean checkAnswer(Question question, String userAnswer) {
//        // Метод для проверки ответа пользователя на вопрос
//        return userAnswer.equals(question.getCorrectAnswer());
//    }
}
