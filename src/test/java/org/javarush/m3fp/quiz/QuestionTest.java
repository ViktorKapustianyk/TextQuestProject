package org.javarush.m3fp.quiz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    @Test
    @DisplayName("Check first parameter is null")
    void constructor_NullQuestionParamPassed_ThrowIllegalArgumentException() {
        String question = null;
        List<String> answers = new ArrayList<>();
        String correctAnswer = "correct";
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals(IllegalArgumentException.class, actualException.getClass());
    }

    @Test
    @DisplayName("Check message if parameter is null")
    void constructor_NullQuestionParamPassed_Message() {
        String question = null;
        List<String> answers = new ArrayList<>();
        String correctAnswer = "correct";
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals("Question cannot be null.", actualException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t \t"})
    @DisplayName("Check Exception if first parameter is empty string")
    void constructor_EmptyQuestionParamPassed_ThrowIllegalArgumentException(String question) {
        List<String> answers = new ArrayList<>();
        String correctAnswer = "correct";
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals(IllegalArgumentException.class, actualException.getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t \t"})
    @DisplayName("Check Message if first parameter is empty string")
    void constructor_EmptyQuestionParamPassed_Message(String question) {
        List<String> answers = new ArrayList<>();
        String correctAnswer = "correct";
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals("Question cannot be blank.", actualException.getMessage());
    }

    @Test
    @DisplayName("Check answers parameter is null")
    void constructor_NullAnswersParamPassed_ThrowIllegalArgumentException() {
        String question = "Test question";
        List<String> answers = null;
        String correctAnswer = "correct";
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals(IllegalArgumentException.class, actualException.getClass());
    }
    @Test
    @DisplayName("Check answers contain null elements")
    void constructor_NullElementInAnswers_ThrowIllegalArgumentException() {
        String question = "Test question";
        List<String> answersWithNull = Arrays.asList("option1", null, "option3");
        String correctAnswer = "correct";

        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answersWithNull, correctAnswer);
                }
        );

        assertEquals("Answers cannot contain null elements.", actualException.getMessage());
    }

    @Test
    @DisplayName("Check correct answer parameter is null")
    void constructor_NullCorrectAnswerParamPassed_ThrowIllegalArgumentException() {
        String question = "question";
        List<String> answers = new ArrayList<>();
        String correctAnswer = null;
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals(IllegalArgumentException.class, actualException.getClass());
    }

    @Test
    @DisplayName("Check message if correct answer is null")
    void constructor_NullCorrectAnswerParamPassed_Message() {
        String question = "question";
        List<String> answers = new ArrayList<>();
        String correctAnswer = null;
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals("CorrectAnswer cannot be null.", actualException.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t \t"})
    @DisplayName("Check Exception if first parameter is empty string")
    void constructor_EmptyCorrectAnswerParamPassed_ThrowIllegalArgumentException(String correctAnswer) {
        String question = "question";
        List<String> answers = new ArrayList<>();
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals(IllegalArgumentException.class, actualException.getClass());
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "  ", "\n", "\n\n", "\t", "\t \t"})
    @DisplayName("Check Message if first parameter is empty string")
    void constructor_EmptyCorrectAnswerParamPassed_Message(String correctAnswer) {
        String question = "question";
        List<String> answers = new ArrayList<>();
        Throwable actualException = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    new Question(question, answers, correctAnswer);
                }
        );
        assertEquals("CorrectAnswer cannot be blank.", actualException.getMessage());
    }


    @Test
    @DisplayName("Check method getQuestion")
    void getQuestion_ReturnsCorrectQuestion() {
        String questionTest = "Test question";
        List<String> answers = Arrays.asList("Option1", "Option2");
        String correctAnswer = "correct";
        Question question = new Question(questionTest, answers, correctAnswer);

        String expectedQuestion = "Test question";
        String actualQuestion = question.getQuestion();
        assertEquals(expectedQuestion, actualQuestion, "The return value is not the expected Question");
    }

    @Test
    @DisplayName("Check method getAnswers")
    void getAnswers_ReturnsCorrectListOfAnswers() {
        String questionTest = "Test question";
        List<String> answers = Arrays.asList("Option1", "Option2");
        String correctAnswer = "correct";
        Question question = new Question(questionTest, answers, correctAnswer);

        List<String> expectedAnswers = Arrays.asList("Option1", "Option2");
        List<String> actualAnswers = question.getAnswers();
        assertEquals(expectedAnswers, actualAnswers, "The return value is not the expected List of Answers");
    }

    @Test
    void getCorrectAnswer_ReturnsCorrectAnswer() {
        String questionTest = "Test question";
        List<String> answers = Arrays.asList("Option1", "Option2");
        String correctAnswer = "Option2";
        Question question = new Question(questionTest, answers, correctAnswer);

        String expectedAnswer = "Option2";
        String actualAnswer = question.getCorrectAnswer();
        assertEquals(expectedAnswer, actualAnswer, "The return value is not the expected CorrectAnswer");
    }
    @ParameterizedTest
    @CsvSource({
            "Correct answer, true",
            "Wrong answer, false"
    })
    public void testCheckAnswer_ReturnsExceptedAnswer(String userAnswer, boolean expected) {
        Question question = new Question("Test question", Arrays.asList("Wrong answer", "Correct answer"), "Correct answer");

        boolean actual = question.checkAnswer(question, userAnswer);

        assertEquals(expected, actual);
    }
}