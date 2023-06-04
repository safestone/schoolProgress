package dataSaveProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	
//	public static void main(String[] args) {
//		createTable();
//		createCustomer("lee", "12314", "Male", "23", "Random Note");
//		ArrayList<String> list = getCustomers();
//		for(String item: list) {
//			System.out.println(item);
//		}
//	}
	
	public static String[][] getCustomers() {
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("Select name, phone, gender, age, note FROM customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]> list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("note")
				});
			}
			
			System.out.println("데이터 불러오기 성공");
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public static void createCustomer(String name, String phone, String gender, String age ,String note) {
		try {
			Connection conn = getConnection();
			PreparedStatement insert = conn.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name, phone, gender, age, note) "
					+ "VALUE "
					+ "('"+name+"', '"+phone+"', '"+gender+"', '"+age+"', '"+note+"')");
			insert.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void createTable() {
	    try {
	        Connection conn = getConnection();
	        PreparedStatement createTable = conn.prepareStatement(
	                "CREATE TABLE IF NOT EXISTS "
	                + "customer(id int NOT NULL AUTO_INCREMENT,"
	                + "name varchar(255),"
	                + "phone varchar(255),"
	                + "gender varchar(255),"
	                + "age varchar(255),"
	                + "note varchar(255),"
	                + "PRIMARY KEY(id))");
	        createTable.execute();
	    } catch (Exception e) {
	        System.out.println(e.getMessage());
	    } finally {
	        System.out.println("테이블 성공적으로 생성");
	    }
	}

	
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String dbUrl = "jdbc:mysql://localhost:3306/swingdb";
			String dbId = "root";
			String dbPw = "root";
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(dbUrl, dbId, dbPw);
			System.out.println("연결 완료");
			
			return conn;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
