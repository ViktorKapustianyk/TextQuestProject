package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;
import org.javarush.m3fp.quiz.QuestionFactory;

import java.util.Arrays;

public class QuestionTwo implements QuestionFactory {
    private final String question = "You decide to explore a deep cave entrance. How will you proceed?";
    private final String answer = "Enter the cave and explore deeper";
    private final String correctAnswer = "Go around the cave and continue the search in other directions";
    @Override
    public Question createQuestion() {
        return new Question(question, Arrays.asList(answer, correctAnswer), correctAnswer);
    }
}
