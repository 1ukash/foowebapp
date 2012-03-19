package ru.spbstu.telematics.student;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {
	
	public static class POJOExample {
		private String name;
		private int age;

		public POJOExample(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String param = req.getParameter("q");
//		req.setAttribute("param", param);
		req.setAttribute("object", param);
		
		POJOExample pe = new POJOExample("John", 22);
		
		req.setAttribute("pe", pe);
		
		req.getRequestDispatcher("/hello.jsp").forward(req, resp);
	}
	
	
}
