package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import db.DB;
import db.DbIntegrityException;

public class Program {

	public static void main(String[] args) {
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM department "
					+ "WHERE "
					+ "Id = ?"
					);
			
			st.setInt(1, 2); // deletando na linha 1 , o registro com Id 5

			
			int rowsAffected = st.executeUpdate();
		
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
			}
			else {
				System.out.println("No rows affected");
			}
			
		}
		catch(SQLException e){
			throw new DbIntegrityException(e.getMessage()); // Alterando para exceção personalizada
		}

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
				
		}
	}

}
