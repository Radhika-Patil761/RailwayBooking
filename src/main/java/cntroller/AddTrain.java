package cntroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TrainDao;
import dto.Train;

@WebServlet("/addtrain")
public class AddTrain   extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int trainnumber=Integer.parseInt(req.getParameter("tnumber"));
		String trainname=req.getParameter("tname");
		int trainseat=Integer.parseInt(req.getParameter("tseat"));
		String station=req.getParameter("tstations");
        String[] trainstation=station.split(",");
        String price=req.getParameter("tprice");
        String[] trainprice=price.split(",");
        String time=req.getParameter("ttime");
        String[] traintime=time.split(",");
        String days=req.getParameter("tdays");
        String[] traindays=days.split(",");
       PrintWriter out= resp.getWriter();
       Train train=new Train();
        train.setDays(traindays);
        train.setName(trainname);
        train.setNumber(trainnumber);
        train.setPrice(trainprice);
        train.setSeat(trainseat);
        train.setStations(trainstation);
        train.setTime(traintime);
        TrainDao dao=new TrainDao();
        dao.save(train);
         
        resp.getWriter().print("<h1 style='color:red'>train details added successfully</h1>");
		req.getRequestDispatcher("ManagementHome.html").include(req, resp);
        
	}
}
