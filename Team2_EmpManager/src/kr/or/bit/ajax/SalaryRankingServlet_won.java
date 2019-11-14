package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.chart.AvgMaxMinSalaryByDept;
import kr.or.bit.dto.chart.TotalSaleryChart;

@WebServlet("/SalaryRanking_won.do")
public class SalaryRankingServlet_won extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalaryRankingServlet_won() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String command = request.getParameter("cmd");
		
		if(command.equals("show")) {
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/chart/SalaryRankingChart_won.jsp");
			dis.forward(request, response);
		}else if (command.equals("chart")) {
			PrintWriter out = response.getWriter();
			String id = request.getParameter("id");
			System.out.println(id);
			EmpDao dao = null;
			JSONArray json = null;
			try {
				dao = new EmpDao();
				int count =Integer.parseInt(request.getParameter("count")) ;
				List<AvgMaxMinSalaryByDept> results = dao.ChartSalByDept();
				StringBuilder datalist = new StringBuilder();
				datalist.append("[");
				for (AvgMaxMinSalaryByDept salery : results)
					datalist.append(
							String.format("{ename : %s, totalsal : %d},", salery.getEname(), salery.getTotalSalery()));

				datalist.append("]");
				json = new JSONArray(datalist.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}

			System.out.println(json);
			out.print(json);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}
}
