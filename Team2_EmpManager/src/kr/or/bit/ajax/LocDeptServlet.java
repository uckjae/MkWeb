package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.chart.LocDept;

/**
 * Servlet implementation class LocDeptServlet
 */
@WebServlet("/LocCount")
public class LocDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
	
		String command = request.getParameter("cmd");
		if(command.equals("show")) {
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/chart/LocDeptNo.jsp");
			dis.forward(request, response);
		}else if(command.equals("chart")) {
			
			PrintWriter out = response.getWriter();	
			EmpDao dao = null;
			dao = new EmpDao();
			List<LocDept> locdatas = dao.LocChart();
			JSONArray json = null;
			StringBuilder loclist = new StringBuilder();
			
			try {
				loclist.append("[");
				for(LocDept loc : locdatas)
					loclist.append(String.format("{Loc : %s , Count : %d },", loc.getCity() , loc.getCount()));
				loclist.append("]");
				json = new JSONArray(loclist.toString());
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			out.print(json);
		}

		
		
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}
