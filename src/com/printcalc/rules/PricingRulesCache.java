package com.printcalc.rules;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

import com.printcalc.db.DBService;
import com.printcalc.model.GenericPaper;
import com.printcalc.model.Price;


public class PricingRulesCache {

	private Map<String, Map<String, Price>> cache;
	private DBService agent;
	
	{
		cache = new ConcurrentHashMap<String, Map<String, Price>>();
	}
	
	public Price getPriceFromCache(GenericPaper genericPaper){
		Price price = null;
		String paperType = genericPaper.getPaperType();
		String printType = genericPaper.getPrintType();
		if(cache.containsKey(paperType)){
			Map<String, Price> map = cache.get(paperType);
			if(map.containsKey(printType)){
//				System.out.println("Getting from cache outer");
				return map.get(printType);
			}
			else{
				if(agent==null)
					agent = new DBService();
				try{
//					System.out.println("Getting Price From Database Inner");
					price = agent.getPriceFromDataBase(genericPaper);
					map.put(printType, price);
					cache.put(paperType, map);
					return price;
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		else{
			if(agent==null)
				agent = new DBService();
				try{					
//					System.out.println("Getting Price From Database Outer And Inner");
					price = agent.getPriceFromDataBase(genericPaper);
					Map<String, Price> value = new TreeMap<String, Price>();
					value.put(genericPaper.getPrintType(), price);
					cache.put(paperType, value);
				}	
				catch(Exception e){
					e.printStackTrace();
				}
		}
		return price;
	}
		
}
