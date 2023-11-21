package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;

import java.util.LinkedList;
import java.util.Queue;

public class QuestionRepository {
    private Queue<Question> questionQueue;

    public QuestionRepository() {
        this.questionQueue = new LinkedList<>();
        initializeQuestions(); // Метод для создания и добавления вопросов
    }

    public boolean hasMoreQuestions() {
        return !questionQueue.isEmpty();
    }

    public Question getNextQuestion() {
        if (hasMoreQuestions()) {
            return questionQueue.poll();
        }
        return null;
    }

    private void initializeQuestions() {
        // Создаем вопросы и добавляем их в очередь
        questionQueue.add(new QuestionOne().createQuestion());
        questionQueue.add(new QuestionTwo().createQuestion());
        questionQueue.add(new QuestionThree().createQuestion());
        // Добавьте другие вопросы по мере необходимости
    }
}
