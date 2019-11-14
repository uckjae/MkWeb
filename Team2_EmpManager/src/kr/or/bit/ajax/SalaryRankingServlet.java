package kr.or.bit.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONArray;

import kr.or.bit.dao.EmpDao;
import kr.or.bit.dto.chart.TotalSaleryChart;

@WebServlet("/SalaryRanking.do")
public class SalaryRankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SalaryRankingServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("id");
		System.out.println(id);
		EmpDao dao = null;
		JSONArray json = null;
		try {
			dao = new EmpDao();

			List<TotalSaleryChart> results = dao.ChartDataByTotalSalery(10);
			StringBuilder datalist = new StringBuilder();
			datalist.append("[");
			for (TotalSaleryChart salery : results)
				datalist.append( String.format("{ename : %s, totalsal : %d},", salery.getEname(), salery.getTotalSalery()));

			datalist.append("]");
			json = new JSONArray(datalist.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(json);
		out.print(json); 
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
