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
import kr.or.bit.dto.chart.AvgMaxMinEmpByJob;




@WebServlet("/SalaryRankingServlet_Choi")
public class SalaryRankingServlet_Choi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SalaryRankingServlet_Choi() {
        super();
        
    }
    private void doProcess(HttpServletRequest request, HttpServletResponse response)
    		throws  ServletException, IOException{
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String commmad = request.getParameter("cmd");
    	
    	if(commmad.equals("show")) {
    		RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/chart/SalaryRankingChart_Choi.jsp");
    		dis.forward(request, response);
    	}else if(commmad.equals("chart")){
    	   PrintWriter out = response.getWriter();
    	   String id = request.getParameter("id");
    	   System.out.println(id);
    	   EmpDao dao =null;
    	   JSONArray json =null;
    	try {
    		dao = new EmpDao();
    		
    		List<AvgMaxMinEmpByJob>chart =dao.avgMaxMinEmpByjobs();
    		StringBuilder datalist = new StringBuilder();
    		datalist.append("[");
    		for(AvgMaxMinEmpByJob data :chart)
    			datalist.append(
   String.format("{job: %s, avgsal: %d, maxsal: %d, minsal: %d},", data.getJob(),data.getAvgsal(),data.getMaxsal(),data.getMinsal()));
    			
    		    datalist.append("]");
    			json = new JSONArray(datalist.toString());
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	out.print(json);
    	System.out.println(json);
    	}
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		doProcess(request,response);
	}

}
