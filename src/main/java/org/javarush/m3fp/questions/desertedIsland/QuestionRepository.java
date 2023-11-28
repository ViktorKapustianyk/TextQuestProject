package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;

import java.util.*;

public class QuestionRepository {
    protected List<Question> questionList;
    protected int currentIndex;

    public QuestionRepository() {
        this.questionList = new ArrayList<>();
        initializeQuestions();
        this.currentIndex = 0;
    }

    public boolean hasMoreQuestions() {
        return currentIndex < questionList.size();
    }

    public Question getNextQuestion() {
        if (hasMoreQuestions()) {
            return questionList.get(currentIndex++);
        }
        return null;
    }

    public void resetIndex() {
        this.currentIndex = 0;
    }

    private void initializeQuestions() {
        questionList.add(new QuestionOne().createQuestion());
        questionList.add(new QuestionTwo().createQuestion());
        questionList.add(new QuestionThree().createQuestion());
    }
}
