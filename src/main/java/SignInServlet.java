import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignInServlet")
public class SignInServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("userName");
        String pass = request.getParameter("userPass");

        JsonHandler jsonHandler = new JsonHandler();
        if (jsonHandler.checkUser(new User(login, pass))) {
            request.setAttribute("username", login);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "User " + login + " doesn't exist or password's incorrect!");
            request.getRequestDispatcher("form.jsp").forward(request, response);
        }
    }
}