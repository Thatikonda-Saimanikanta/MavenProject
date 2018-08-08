package com.mindtree.Dao;

import java.sql.SQLException;
import java.sql.Connection;
import com.mindtree.Entities.Matches;
/*This class contains abstract methods which performs action on database*/
public interface Dao {
public void SaveintoMatches(Matches m) throws ClassNotFoundException, SQLException;
public String ShowFromMatches(Matches m) throws ClassNotFoundException, SQLException;
}
