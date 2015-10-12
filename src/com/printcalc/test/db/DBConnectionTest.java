package com.printcalc.test.db;

import java.sql.SQLException;

import junit.framework.Assert;

import org.junit.Test;

import com.printcalc.db.DBConnection;

/*
 * 
 * 
 * @author bhupendra
 * 
 * DBConnection Test
 */
public class DBConnectionTest {

	@Test
	public void getConnectionTest() throws ClassNotFoundException, SQLException {
		Assert.assertNotNull("DB connection must not be null",
				DBConnection.getConnection());
	}
}
