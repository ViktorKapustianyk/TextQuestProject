package org.javarush.m3fp;

import org.javarush.m3fp.questions.desertedIsland.QuestionRepository;
import org.javarush.m3fp.quiz.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LogicQuestServlet", value = "/nextQuestion")
public class LogicQuestServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);

        QuestionRepository questionRepository = (QuestionRepository) session.getAttribute("questionRepository");
        String userAnswer = request.getParameter("answer");

        // Получаем текущий вопрос из сессии
        Question currentQuestion = (Question) session.getAttribute("currentQuestion");

        // Проверяем правильность ответа
        boolean isCorrect = currentQuestion.checkAnswer(currentQuestion, userAnswer);

        if (isCorrect) {
            // Если ответ правильный, переходим к следующей фабрике (следующему вопросу)
            switchToNextQuestion(session, questionRepository, request, response);
        } else {
            // Отримуємо поточні дані гравця та кількість зіграних ігор з сесії
            String playerName = (String) session.getAttribute("playerName");
            int gamesPlayed = (int) session.getAttribute("gamesPlayed");
            // Оновлюємо кількість зіграних ігор
            gamesPlayed++;
            // Оновлюємо інформацію про гравця та кількість зіграних ігор в сесії
            session.setAttribute("playerName", playerName);
            session.setAttribute("gamesPlayed", gamesPlayed);

            // Если ответ неверный, перенаправляем на страницу поражения
            response.sendRedirect(session.getServletContext().getContextPath() + "/game-over.jsp");
        }
    }


    private void switchToNextQuestion(HttpSession session, QuestionRepository questionRepository, HttpServletRequest request,  HttpServletResponse response) throws IOException, ServletException {
        // Извлекаем следующую фабрику из очереди

        // Проверка на null, если вопросы закончились
        if (questionRepository.hasMoreQuestions()) {

            Question nextQuestion = questionRepository.getNextQuestion();
            // Устанавливаем новую фабрику в сессию
            session.setAttribute("currentQuestion", nextQuestion);
            // Перенаправляем на /start для отображения следующего вопроса
//            response.sendRedirect(session.getServletContext().getContextPath() + "/start");

            List<String> options = nextQuestion.getAnswers();

            // Передаем вопрос и варианты ответов в JSP
            request.setAttribute("currentQuestion", nextQuestion);
            request.setAttribute("options", options);

            // Перенаправляем на JSP для отображения первого вопроса
            getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
        } else {
            // Отримуємо поточні дані гравця та кількість зіграних ігор з сесії
            String playerName = (String) session.getAttribute("playerName");
            int gamesPlayed = (int) session.getAttribute("gamesPlayed");
            // Оновлюємо кількість зіграних ігор
            gamesPlayed++;
            // Оновлюємо інформацію про гравця та кількість зіграних ігор в сесії
            session.setAttribute("playerName", playerName);
            session.setAttribute("gamesPlayed", gamesPlayed);

            // Ваши действия при завершении вопросов (например, перенаправление на страницу завершения теста)
            response.sendRedirect(session.getServletContext().getContextPath() + "/quiz-completed.jsp");
        }
    }
}
