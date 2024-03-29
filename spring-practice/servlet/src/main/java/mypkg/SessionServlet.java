package mypkg;

import java.io.*;
import java.util.*;
import jakarta.servlet.*;             // Tomcat 10
import jakarta.servlet.http.*;        // Tomcat 10
import jakarta.servlet.annotation.*;  // Tomcat 10

public class SessionServlet extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServletContext context = config.getServletContext();

        context.setAttribute("jdbcDriver", getServletContext().getInitParameter("jdbcDriver"));

        context.setAttribute("databaseURL", config.getInitParameter("databaseURL"));
        context.setAttribute("user", config.getInitParameter("user"));
        context.setAttribute("password", config.getInitParameter("password"));
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        // Set the response message's MIME type
        response.setContentType("text/html;charset=UTF-8");
        // Allocate a output writer to write the response message into the network socket
        PrintWriter out = response.getWriter();

        // Return the existing session if there is one. Create a new session otherwise.
        HttpSession session = request.getSession();
        ServletContext context = getServletContext();

        Integer accessCount;
        synchronized(session) {
            accessCount = (Integer)session.getAttribute("accessCount");
            if (accessCount == null) {
                accessCount = 0;   // autobox int to Integer
            } else {
                accessCount = new Integer(accessCount + 1);
            }
            session.setAttribute("accessCount", accessCount);
        }

        // Write the response message, in an HTML page
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>");
            out.println("<title>Session Test Servlet</title></head><body>");

            out.println("<p> " + context.getAttribute("jdbcDriver") + " </p>");
            out.println("<p> " + context.getAttribute("databaseURL") + " </p>");
            out.println("<p> " + context.getAttribute("user") + " </p>");
            out.println("<p> " + context.getAttribute("password") + " </p>");

            out.println("<h2>You have access this site " + accessCount + " times in this session.</h2>");
            out.println("<p>(Session ID is " + session.getId() + ")</p>");

            out.println("<p>(Session creation time is " +
                    new Date(session.getCreationTime()) + ")</p>");
            out.println("<p>(Session last access time is " +
                    new Date(session.getLastAccessedTime()) + ")</p>");
            out.println("<p>(Session max inactive interval  is " +
                    session.getMaxInactiveInterval() + " seconds)</p>");

            out.println("<p><a  href='" + request.getRequestURI() +  "'>Refresh</a>");
            out.println("<p><a  href='" + response.encodeURL(request.getRequestURI())  +
                    "'>Refresh with  URL rewriting</a>");
            out.println("</body></html>");
        } finally {
            out.close();  // Always close the output writer
        }
    }
}