  
package se.kth.iv1350.pos.integration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Sale;

import java.util.ArrayList;

public class AccountingSystemTest
{
    private AccountingSystem accountingSystem;
    private Sale sale1;
    private Sale sale2;
    int numberOfSales;

    @Before
    public void setUp() throws Exception {
        Controller contr = new Controller();
        accountingSystem = new AccountingSystem();
        Sale sale1 = contr.startNewSale();
        Sale sale2 = contr.startNewSale();
        numberOfSales = 2;
    }

    @After
    public void tearDown() throws Exception {
    	accountingSystem = null;
        sale1 = null;
        sale2 = null;
    }

    @Test
    // Make certain correct number 
    public void returnCopy() {
    	accountingSystem.logSale(sale1);
    	accountingSystem.logSale(sale2);
        Assert.assertSame(accountingSystem.getListOfSales().size(), numberOfSales);
    }
}