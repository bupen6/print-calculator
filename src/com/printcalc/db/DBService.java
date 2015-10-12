package com.printcalc.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;

public class DBService {

	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	public Price getPriceFromDataBase(GenericPaper genericPaper)throws RuntimeException, SQLException{
		String query = new QueryMaker().buildQuery(genericPaper);
		try {
			connection = DBConnection.getConnection();
			preparedStatement = connection
					.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();
			if(resultSet==null)
				throw new RuntimeException("Rules for "+genericPaper.getPaperType()+" with "+genericPaper.getPrintType()+" not found, please set in database");
			else
				return this.generatePrice(resultSet);
		} catch (Exception e) {
			e.printStackTrace();
			connection.close();
			throw new RuntimeException();
		}finally{
			connection.close();
		}
	}
	
	private Price generatePrice(ResultSet resultSet) throws NumberFormatException, SQLException{
		int blackAndWhitePrice = 0;
		int colourPrice = 0;
		if(resultSet.next()){
			blackAndWhitePrice =Integer.parseInt(resultSet.getString("blackandwhiteprice"));
			colourPrice = Integer.parseInt(resultSet.getString("colourprice"));
		}
		return new Price(blackAndWhitePrice, colourPrice);
	}
}
