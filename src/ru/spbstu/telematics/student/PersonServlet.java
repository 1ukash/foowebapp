package ru.spbstu.telematics.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PersonServlet extends HttpServlet{
	
	private PersonManager man = new PersonManager();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null ){
			Person p = man.doReadPerson(id);
			req.setAttribute("p", p);
			req.getRequestDispatcher("/viewperson.jsp").forward(req, resp);
		} else {
			List<Person> people = man.doReadAll();
			req.setAttribute("people", people);
		}
	}

}
