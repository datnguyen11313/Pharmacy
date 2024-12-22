package database;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectDB {
	// tra ve chuoi ket noi
	public static String getURL() {
		String url = null;

		try (var input = new FileInputStream("db.properties");) {
			var p = new Properties();
			p.load(input);
			url = p.getProperty("url") + p.getProperty("serverName") + ":" + p.getProperty("portNumber")
					+ "; databaseName = " + p.getProperty("databaseName") + "; user=" + p.getProperty("user")
					+ "; password = " + p.getProperty("password") + "; eccrypt=" + p.getProperty("encrypt")
					+ "; trustServerCertificate=" + p.getProperty("trustServerCertificate");
		}

		catch (Exception e) {
			e.printStackTrace();
			url = null;
		}
		return url;
	}

	// tra ve connection luon

	public static Connection getCon() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(getURL());
		} catch (Exception e) {
			e.printStackTrace();
			conn = null;
		}
		return conn;
	}
}
