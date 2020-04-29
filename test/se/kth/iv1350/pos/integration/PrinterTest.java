package se.kth.iv1350.pos.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Receipt;
import se.kth.iv1350.pos.model.Sale;

public class PrinterTest
{
    private Printer printer;
    private Sale sale;
    CashRegister cashRegister;

    @Before
    public void setUp() throws Exception
    {
        cashRegister = new CashRegister();
        printer = new Printer();
        sale = cashRegister.newSale();
    }

    @After
    public void tearDown() throws Exception
    {
        cashRegister = null;
        printer = null;
        sale = null;
    }

    @Test
    // Same {@link Sale} object returns a new {@link Receipt} object each time it prints.
    public void eachReceiptUnique()
    {
        Receipt r1 = printer.printReceipt(sale);
        Receipt r2 = printer.printReceipt(sale);
        Assert.assertNotSame(r1, r2);
    }
}
