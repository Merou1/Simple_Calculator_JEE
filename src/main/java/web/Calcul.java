package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Calcul
 */
@WebServlet("/Calcul")
public class Calcul extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Calcul() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String operande1Str = request.getParameter("operande1"); //req.getparam katreturne string
	    String operande2Str = request.getParameter("operande2");
	    String operation = request.getParameter("operation");

	    // Check si des params ne sont pas biend passés
	    if (operande1Str == null || operande2Str == null || operation == null || operande1Str.isEmpty() || operande2Str.isEmpty()) {
	        response.sendRedirect("Saisie.jsp?error=invalidee");
	        return;
	    }

	    try {
	        double operande1 = Double.parseDouble(operande1Str.trim()); //trim ela 9bel les espaces bash it7eydou psa "3,14" mashy hiya " 3.14" t9der teati error
	        double operande2 = Double.parseDouble(operande2Str.trim());
	        double result = 0;

	        switch (operation) {
	            case "+":
	                result = operande1 + operande2;
	                break;
	            case "-":
	                result = operande1 - operande2;
	                break;
	            case "/":
	                if (operande2 != 0) {
	                    result = operande1 / operande2;
	                } else {
	                    response.sendRedirect("Saisie.jsp?error=denominateur==0");
	                    return;
	                }
	                break;
	            case "*":
	                result = operande1 * operande2;
	                break;
	            default:
	                response.sendRedirect("Saisie.jsp?error=invalid");
	                return;
	        }

	        request.setAttribute("result", result);
	        request.setAttribute("operande1", operande1);
	        request.setAttribute("operande2", operande2);
	        request.setAttribute("operation", operation);

	        request.getRequestDispatcher("Resultat.jsp").forward(request, response);

	    } catch (NumberFormatException e) {
	        response.sendRedirect("Saisie.jsp?error=invalid");
	    }
	}


}
