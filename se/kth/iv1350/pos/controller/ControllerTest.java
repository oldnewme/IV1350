package se.kth.iv1350.pos.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.DTO.SaleDTO;
import se.kth.iv1350.pos.integration.ItemNotFoundException;
import se.kth.iv1350.pos.integration.OperationFailedException;
import se.kth.iv1350.pos.model.CashRegister;

class ControllerTest {
	
	private Controller contr;
	private CashRegister cashRegister;

	@BeforeEach
	void setUp() throws Exception {
		cashRegister = new CashRegister();
		contr = new Controller(cashRegister);
	}

	@AfterEach
	void tearDown() throws Exception {
		cashRegister = null;
		contr = null;
	}

	@Test
	void endSaleReturnsObject() {
		cashRegister.startNewSale();
		SaleDTO saleDTO = contr.endSale();
		Assert.assertNotNull(saleDTO);	
	}
	
    @Test
    void FailedOperationTest() throws OperationFailedException {
        try
        {
        	contr.registerItem(4321);
        }
        catch (Exception ex)
        {
            Assert.assertEquals(ex.getClass(), OperationFailedException.class);
        }
    }
	
	
	
}
