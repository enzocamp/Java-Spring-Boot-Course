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

public class Program {

	public static void main(String[] args) {
			
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Connection conn = null;
		
		PreparedStatement st = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.prepareStatement(
					"INSERT INTO seller "
					+ "(Name, Email, BirthDate, BaseSalary, DepartmentId) "
					+ "VALUES "
					+ "(?, ?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, "Carl Seigan");
			st.setString(2, "carl@gmail.com");
			st.setDate(3, java.sql.Date.valueOf(LocalDate.parse("22/04/1995", fmt)));
			st.setDouble(4, 3000.0);
			st.setInt(5, 4);
			
			int rowsAffected = st.executeUpdate();
		
			if(rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
			}
			else {
				System.out.println("No rows affected");
			}
			
			System.out.println("Done! Rows Aggected: " + rowsAffected);
		}
		catch(SQLException e){
			e.printStackTrace();
		}

		finally {
			DB.closeStatement(st);
			DB.closeConnection();
				
		}
	}

}
