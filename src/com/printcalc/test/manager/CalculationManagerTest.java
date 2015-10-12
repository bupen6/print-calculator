package com.printcalc.test.manager;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.printcalc.manager.CalculationManager;

/*
 * @author bhupendra
 * 
 * CalculationManager Test
 */
public class CalculationManagerTest {

	private CalculationManager calculationManager;

	@Before
	public void setUp() {
		calculationManager = Mockito.mock(CalculationManager.class);
	}

	@Test
	public void calculatePriceTest1() {
		calculationManager.calculatePrice();
		Mockito.verify(calculationManager, Mockito.times(1)).calculatePrice();
	}

}
