/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paloma
 */
public class TicketMachineTest {
    TicketMachine tm;
    
    public TicketMachineTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tm = new TicketMachine(20);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of inserir method, of class TicketMachine.
     */
    @Test
    public void testInserir() throws Exception {
        tm.inserir(10);
        assertEquals(10, tm.getSaldo());
    }

    /**
     * Test of getSaldo method, of class TicketMachine.
     */
    @Test
    public void testGetSaldo() {
        assertEquals(tm.saldo, tm.getSaldo());
    }

    /**
     * Test of getTroco method, of class TicketMachine.
     */
    @Test
    public void testGetTroco() {
        try {
            tm.inserir(10);
        } catch (PapelMoedaInvalidaException ex) {
            Logger.getLogger(TicketMachineTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertEquals(5, tm.getTroco());
    }

    /**
     * Test of imprimir method, of class TicketMachine.
     */
    @Test
    public void testImprimir() throws Exception {
        assertEquals(tm.getSaldo(), tm.imprimir());
    }

    /**
     * Test of verificaSaldo method, of class TicketMachine.
     */
    @Test
    public void testVerificaSaldo() throws Exception {
        assertEquals(tm.saldo>=tm.valor, tm.getSaldo());
    }
    
}
