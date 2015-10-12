package com.printcalc.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.printcalc.constants.PrintCalcConstants;



public class DBConnection {

	// Returns connection
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		Class.forName(PrintCalcConstants.DRIVER_TYPE);
		return DriverManager.getConnection(PrintCalcConstants.CONNECTION_HOST,
				PrintCalcConstants.user, PrintCalcConstants.pass);
	}
}
