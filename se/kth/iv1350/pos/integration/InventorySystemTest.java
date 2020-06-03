package se.kth.iv1350.pos.integration;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.iv1350.pos.DTO.ItemDTO;

class InventorySystemTest {
	
	InventorySystem inventorySystem;

	@BeforeEach
	void setUp() throws Exception {
		inventorySystem = new InventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		inventorySystem = null;
	}
	
	// id: 4321 simulates a database failure
	@Test
    void databaseFailureTest() throws DatabaseFailureException {
        try
        {
            inventorySystem.getItem(4321);
        }
        catch (Exception ex)
        {
            Assert.assertEquals(ex.getClass(), DatabaseFailureException.class);
        }
    }
	 
    // should throw exception since id: 10001 doesn't correspond with any item
    @Test
    void wrongIdentifierInputTest() throws ItemNotFoundException {
        try
        {
            inventorySystem.getItem(10001);
            fail("A match was found even though identifier does not correspond with any item in inventory");
        }
        catch (Exception ex)
        {
            Assert.assertEquals(ex.getClass(), ItemNotFoundException.class);
        }
    }

}
