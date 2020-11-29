import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpServlet")
public class SignUpServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String login = request.getParameter("userName");
        String pass = request.getParameter("userPass");

        JsonHandler jsonHandler = new JsonHandler();
        if (jsonHandler.addUser(new User(login, pass))) {
            request.setAttribute("message", "Successfully saved!");
            request.getRequestDispatcher("/form.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Error! This login is unavailable.");
            request.getRequestDispatcher("sign_up.jsp").forward(request, response);
        }
    }
}
