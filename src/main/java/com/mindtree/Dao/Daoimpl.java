package com.mindtree.Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mindtree.Entities.Matches;
import com.mindtree.Utilities.DaoConnection;
public class Daoimpl implements Dao{

	/*public boolean checkTeamName(String teamname) throws ClassNotFoundException, SQLException {
		Connection con=com.mindtree.Utilities.DaoConnection.Connect();
		String query1 = "select * from teams where team_name=?";
		PreparedStatement st1 = con.prepareStatement(query1);
		st1.setString(1, teamname);
		ResultSet rs1 = st1.executeQuery();
		boolean value = rs1.next();
		return value;
	}*/
    /* This method is used to insert the user input data into matches table*/  
	public void SaveintoMatches(Matches m) throws ClassNotFoundException,SQLException{
		Connection con=DaoConnection.Connect();
		String Query = "insert into Matches(match_date,first_team_name,second_team_name,first_team_goals,second_team_goals) values (?,?,?,?,?)";
		PreparedStatement st = con.prepareStatement(Query);
		try
		{
		st.setTimestamp(1, m.getMatch_date());
		st.setString(2, m.getFirst_team_name());
		st.setString(3, m.getSecond_team_name());
		st.setInt(4, m.getFtg());
		st.setInt(5, m.getStg());
		int c=st.executeUpdate();
		System.out.println("match details added..");
		}
		finally
		{
		con.close();
		st.close();
		}
	}
    /* This method is used to display the data from matches table*/
	public String ShowFromMatches(Matches m) throws ClassNotFoundException, SQLException {
		Connection con=DaoConnection.Connect();
		String s="",s1="";
		String query = "select match_date,second_team_name,first_team_goals,second_team_goals from matches where first_team_name =(?) order by first_team_goals-second_team_goals desc";
		String query2 = "select match_date,first_team_name,second_team_goals,first_team_goals from matches where second_team_name =(?) order by first_team_goals-second_team_goals desc";
		PreparedStatement st = con.prepareStatement(query);
		PreparedStatement st1 = con.prepareStatement(query2);
		st.setString(1, m.getFirst_team_name());
		st1.setString(1, m.getSecond_team_name());
		ResultSet rs = st.executeQuery();
		ResultSet rs1=st1.executeQuery();
		while (rs.next()) {
			s=s+rs.getTimestamp(1) + " " + rs.getString(2) + "-\t" + rs.getInt(3) + "-" + rs.getInt(4)+" "+"</br>";
		}
		while (rs1.next()) {
			s1=s1+rs1.getTimestamp(1) + " " + rs1.getString(2) + "-\t" + rs1.getInt(3) + "-" + rs1.getInt(4)+""+"</br>";
		}
		con.close();
		st.close();
		st1.close();
		return s+s1;
	}
}
