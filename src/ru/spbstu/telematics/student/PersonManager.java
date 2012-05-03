package ru.spbstu.telematics.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.LinkedList;
import java.util.List;

public class PersonManager {
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("nothing more to do, going to die", e);
		}
	}


	public List<Person> doReadAll() {
		List<Person> result = new LinkedList<Person>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con  = getConnection();
			//		Statement st = con.createStatement();
			//		ResultSet rs = st.executeQuery("select p.id, p.name, p.age, p.friend_id from person p where p.id=" + id);
			ps = con.prepareStatement("select p.id, p.name, p.age, p.friend_id from person p");
			rs = ps.executeQuery();
			while(rs.next()) {
				Person r = fetchPerson(rs);
				result.add(r);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return result;
	}

	private Person fetchPerson(ResultSet rs) throws SQLException {
		int personId = rs.getInt(1);
		String name = rs.getString("name");
		int age = rs.getInt("age");
		int friendId = rs.getInt("friend_id");
		Person p = new Person(personId, name, age, friendId);
		return p;
	}

	public Person doReadPerson(String id) {

		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;
		try {
			con  = getConnection();
			//		Statement st = con.createStatement();
			//		ResultSet rs = st.executeQuery("select p.id, p.name, p.age, p.friend_id from person p where p.id=" + id);
			ps = con.prepareStatement("select p.id, p.name, p.age, p.friend_id from person p where p.id=?");
			ps.setInt(1, Integer.valueOf(id));
			rs = ps.executeQuery();
			if(rs.next()) {
				Person result = fetchPerson(rs);
				return result;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			if (ps != null)
				try {
					ps.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			if (con != null)
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}

	private Connection getConnection() {
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost/lukash");
		} catch (SQLException e) {
			throw new RuntimeException("cannot initialize connection", e);
		}
	}
	
	void transactionExample(Connection con) throws SQLException {
		con.setAutoCommit(false);
		// select
		
		// update
		
		Savepoint p = con.setSavepoint();
		
		//delete
		
		con.rollback(p);
		
		// ..
		
		con.commit();
		
		// catch or error
		con.rollback();
		
	}
	

}
