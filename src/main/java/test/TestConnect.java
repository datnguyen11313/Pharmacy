package test;

import database.ConnectDB;

public class TestConnect {

	public static void main(String[] args) {

		try (var conn = ConnectDB.getCon()) {
			System.out.println("ALOALOALOALO");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

// goi chuoi
//try (var conn = DriverManager.getConnection(ConnectDB.getURL());)