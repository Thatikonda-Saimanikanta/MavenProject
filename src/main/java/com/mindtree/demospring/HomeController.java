package com.mindtree.demospring;

import com.mindtree.Dao.*;
import com.mindtree.Entities.*;

import java.io.Console;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@EnableAutoConfiguration
@CrossOrigin
@Controller
public class HomeController implements ErrorController {

	private static final String PATH = "/error";

	Matches m = new Matches();

	@RequestMapping(value = PATH)
	public String error() {
		return "Error handling";
	}
	@Override
	public String getErrorPath() {

		System.out.println("error path ");
		return PATH;
	}

	@RequestMapping("/")
	public String serveHome() {

		return "front.html";
	}

	@ResponseBody
	@RequestMapping("/matches")
	public String serveHome1(@RequestParam String teamname) throws ClassNotFoundException, SQLException {
		Daoimpl d = new Daoimpl();
		m.setFirst_team_name(teamname);
		m.setSecond_team_name(teamname);
		String db = d.ShowFromMatches(m);
		return "database: " + db;
	}

	@ResponseBody
	@RequestMapping(value="/adding")
	public void serveHome2(@RequestParam String ftname, @RequestParam String stname, @RequestParam int ftgoals,
			@RequestParam int stgoals, @RequestParam String tdate) throws ClassNotFoundException, SQLException, ParseException {
		Daoimpl d=new Daoimpl();
		m.setFirst_team_name(ftname);
		 m.setSecond_team_name(stname);
		 m.setFtg(ftgoals);
		 m.setStg(stgoals);
		 SimpleDateFormat x= new SimpleDateFormat("dd-MM-yyyy hh:MM");
		 Date dt= x.parse(tdate);
		 Timestamp ts=new Timestamp(dt.getTime());
		 m.setMatch_date(ts);
		 d.SaveintoMatches(m);
	}

}
