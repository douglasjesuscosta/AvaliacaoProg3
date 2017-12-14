package conection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import util.PropertiesFactory;

public class ConnectionBd {
	
	private Properties programProperties;
	private static ConnectionBd a_connection;
	private static Connection connection;
	
	private ConnectionBd() throws SQLException, ClassNotFoundException{
		Class.forName("org.postgresql.Driver");
		connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Trabalho_II","postgres","postgres");
	}
	
	public static PreparedStatement getPreparedStatement(String sql){
		
		try{
			return connection.prepareStatement(sql);
		}catch (Exception e) {
			throw new RuntimeException("<ConnectionBr> Problema ao retornar preparedstatement");
		}
	}
	
	public static ConnectionBd getConnctionBd() throws SQLException, ClassNotFoundException{
		if(a_connection == null){
			a_connection = new ConnectionBd();
		}
		return a_connection;
	}
	
	public Statement createStatement() throws SQLException{
		return connection.createStatement();
	}
	
	public void executeSqlWithoutReturn(String sql) throws SQLException{
		Statement st = connection.createStatement();
		st.execute(sql);
	}
	
	public ResultSet executeSqlWithReturn(String sql) throws SQLException{
		Statement st = createStatement();
		return st.executeQuery(sql);
	}

}
