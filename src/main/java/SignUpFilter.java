import javax.servlet.*;
import java.io.IOException;

public class SignUpFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String login = request.getParameter("userName");

        if (login.equals("admin")) {
            request.setAttribute("message", "Error! You can't create an account with this name.");
            request.getRequestDispatcher("sign_up.jsp").forward(request, response);
            return;
        }

        chain.doFilter(request, response);
    }
}
