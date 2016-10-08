/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
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
    TicketMachine tmNegativo;
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
    
    @Test
    public void inicializacaoNegativa()throws Exception {

        tmNegativo = new TicketMachine(-20);
        //Passou no Test e não deveria, pois inicializou com um preço negativo
    }
    /**
     * Test of inserir method, of class TicketMachine.
     */
    public void testInserirNota100() throws Exception {
        tm.inserir(100);
        assertEquals(100, tm.getSaldo());
    }

    @Test
    public void testInserirNota2() throws Exception {
        tm.inserir(2);
        assertEquals(2, tm.getSaldo());
    }

    public void testInserirNota50() throws Exception {
        tm.inserir(50);
        assertEquals(50, tm.getSaldo());
    }

    @Test
    public void testInserirNota20() throws Exception {
        tm.inserir(20);
        assertEquals(20, tm.getSaldo());
    }

    @Test
    public void testInserirNota5() throws Exception {
        tm.inserir(5);
        assertEquals(5, tm.getSaldo());
    }

    @Test
    public void testInserirNota10() throws Exception {
        tm.inserir(10);
        assertEquals(10, tm.getSaldo());
    }

    @Test
    public void testInserirForcarErroNota() throws PapelMoedaInvalidaException {
        tm.inserir(15);
        assertEquals(15, tm.getSaldo());
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
    public void testImprimir() throws PapelMoedaInvalidaException, SaldoInsuficienteException {
        tm.inserir(50);
        tm.imprimir();
        assertEquals("depois de inserir 50 reais e imprimir 20 seu saldo deverá ser 30", 50, tm.getSaldo());

    }

    /**
     * Test of verificaSaldo method, of class TicketMachine.
     */
    @Test
    public void testVerificaSaldo() throws Exception {
        assertEquals(tm.saldo>=tm.valor, tm.getSaldo());
    }
    
}
