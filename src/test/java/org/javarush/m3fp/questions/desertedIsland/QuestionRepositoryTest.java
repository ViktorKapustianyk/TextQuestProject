package org.javarush.m3fp.questions.desertedIsland;

import org.javarush.m3fp.quiz.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class QuestionRepositoryTest {
    private QuestionRepository questionRepository;
    @BeforeEach
    void setUp() {
        questionRepository = new QuestionRepository();
    }

    @ParameterizedTest
    @CsvSource({"1, true", "2, true", "3, false"})
    @DisplayName("Check list has questions")
    void checkListHasMoreQuestions(int currentIndex, boolean expectedResult) {
        questionRepository.resetIndex();
        for (int i = 0; i < currentIndex; i++) {
            questionRepository.getNextQuestion();
        }

        assertEquals(expectedResult, questionRepository.hasMoreQuestions());
    }

    @Test
    @DisplayName("Check list has no questions")
    void testGetNextQuestionWhenNoMoreQuestions() {
        questionRepository.currentIndex = questionRepository.questionList.size();
        Question result = questionRepository.getNextQuestion();

        assertNull(result);

        assertEquals(questionRepository.questionList.size(), questionRepository.currentIndex);
    }

    @Test
    @DisplayName("Check list has next expected question")
    void testGetNextQuestionWhenHasQuestions() {
        Question questionOne = questionRepository.getNextQuestion();

        assertEquals(new QuestionOne().createQuestion(), questionOne);

        Question questionTwo = questionRepository.getNextQuestion();

        assertEquals(new QuestionTwo().createQuestion(), questionTwo);
    }

    @Test
    @DisplayName("Check list can reset index to zero")
    void checkListCanResetIndexToZero() {
        QuestionRepository questionRepository = Mockito.mock(QuestionRepository.class);
        Mockito.doNothing().when(questionRepository).resetIndex();
        when(questionRepository.getNextQuestion()).thenReturn(new QuestionOne().createQuestion());

        questionRepository.resetIndex();

        assertEquals(new QuestionOne().createQuestion(), questionRepository.getNextQuestion());
    }
}