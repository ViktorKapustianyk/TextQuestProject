package org.javarush.m3fp;

import org.javarush.m3fp.questions.desertedIsland.QuestionOne;
import org.javarush.m3fp.questions.desertedIsland.QuestionRepository;
import org.javarush.m3fp.questions.desertedIsland.QuestionThree;
import org.javarush.m3fp.questions.desertedIsland.QuestionTwo;
import org.javarush.m3fp.quiz.Question;
import org.javarush.m3fp.quiz.QuestionFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Queue;

@WebServlet(name = "StartQuestServlet" , value ="/start")
public class StartQuestServlet extends HttpServlet {
    private QuestionRepository questionRepository;

    @Override
    public void init() {
        // Получаем экземпляр QuestionRepository из контекста сервлетов
        ServletContext context = getServletContext();
        questionRepository = (QuestionRepository) context.getAttribute("questionRepository");

        // Если QuestionRepository еще не существует, создаем новый и добавляем в контекст
        if (questionRepository == null) {
            questionRepository = new QuestionRepository();
            context.setAttribute("questionRepository", questionRepository);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        session.setAttribute("questionRepository", getServletContext().getAttribute("questionRepository"));
        // Отримуємо поточні дані гравця та кількість зіграних ігор з сесії
        String playerName = (String) session.getAttribute("playerName");
        Integer gamesPlayed = (Integer) session.getAttribute("gamesPlayed");

// Проверка на null, якщо це перший запуск гри
        if (playerName == null) {
            // Оприділяємо ім'я гравця (може вказати користувач)
            playerName = request.getParameter("playerName");
            session.setAttribute("playerName", playerName);
        }

// Проверка на null, якщо це перший запуск гри
        if (gamesPlayed == null) {
            // Ініціалізуємо кількість зіграних ігор
            gamesPlayed = 1;
            session.setAttribute("gamesPlayed", gamesPlayed);
        }

        String restartParam = request.getParameter("restart");

        // Проверяем, был ли запрос на рестарт
        if (restartParam != null && "true".equals(request.getParameter("restart"))) {
            // Если запрос на рестарт, сбрасываем индекс и инициализируем вопрос заново
            questionRepository.resetIndex();
        }

        Question currentQuestion = questionRepository.getNextQuestion();

        // Проверка на null, если вопросы закончились
        if (currentQuestion != null ) {
            // Устанавливаем первую фабрику в сессию
            session.setAttribute("currentQuestion", currentQuestion);

            // Получаем варианты ответов
            List<String> options = currentQuestion.getAnswers();

            // Передаем вопрос и варианты ответов в JSP
            request.setAttribute("currentQuestion", currentQuestion);
            request.setAttribute("options", options);

            // Перенаправляем на JSP для отображения первого вопроса
            getServletContext().getRequestDispatcher("/startQuest.jsp").forward(request, response);
        } else {
//             Ваши действия при завершении вопросов (например, перенаправление на страницу завершения теста)
            response.sendRedirect(session.getServletContext().getContextPath() + "/quiz-completed.jsp");
        }
    }
}
