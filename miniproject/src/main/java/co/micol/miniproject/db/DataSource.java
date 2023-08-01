package co.micol.miniproject.db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DataSource { // 싱글톤 패턴
	private static DataSource dataSource;
	private String driver;
	private String url; // 호스트명 or 서버주소:포트명:SID
	private String user;
	private String password;
	
	public static Connection conn;

	private DataSource() {
		try {
			getProperty();
			Class.forName(driver);

		} catch (Exception e) {
			System.out.println("DB연결실패");
		}
	}

	private void getProperty() {	//db.properties 파일정보를 가져옴
		 String resource = "/db.properties";
		 Properties properties = new Properties();
		 
		 try {
			 InputStream reader = getClass().getResourceAsStream(resource);
			 properties.load(reader);
			 driver = properties.getProperty("driver");
			 url = properties.getProperty("url");
			 user = properties.getProperty("user");
			 password = properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static DataSource getInstance() {
		dataSource = new DataSource();
		return dataSource;
	}

	public Connection getConnection() {
		try {
			conn = DriverManager.getConnection(url, user, password);

		} catch (Exception e) {

		}
		System.out.println("DB연결성공");
		return conn;
	}
}
