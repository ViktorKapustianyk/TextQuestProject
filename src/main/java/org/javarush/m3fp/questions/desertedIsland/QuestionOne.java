package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;
import org.javarush.m3fp.quiz.QuestionFactory;

import java.util.Arrays;

public class QuestionOne implements QuestionFactory {
    private final String question = "Where do you decide to try to find a way out?";
    private final String answer = "Go to the dense forest";
    private final String correctAnswer = "Explore the coastline";

    @Override
    public Question createQuestion() {
        return new Question(question, Arrays.asList(correctAnswer, answer), correctAnswer);
    }
}
