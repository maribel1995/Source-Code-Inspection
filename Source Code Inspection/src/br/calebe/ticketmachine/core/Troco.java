package br.calebe.ticketmachine.core;

import java.util.Iterator;

/**
 *
 * @author Calebe de Paula Bianchini
 */
class Troco {

    protected Troco troco;
    protected PapelMoeda[] papeisMoeda;

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int[] tipoPapelMoeda = {2, 5, 10, 20, 50, 100};

        for (int i = 0; valor > 0; i++) {
            int count = 0;
            boolean achou = false;
            for (int j = 0; j < tipoPapelMoeda.length && !achou; j++) {
                if (tipoPapelMoeda[i] == valor) {
                    while (valor % tipoPapelMoeda[i] != 0) {
                        count++;
                    }
                    papeisMoeda[i] = new PapelMoeda(tipoPapelMoeda[i], count);
                    valor = valor - (tipoPapelMoeda[i] * count);
                }
            }
        }
    }

    public Iterator<PapelMoeda> getIterator() {
        return new TrocoIterator();
    }

    class TrocoIterator implements Iterator<PapelMoeda> {

        public TrocoIterator() {
            
        }

        @Override
        public boolean hasNext() {
            for (int i = 6; i >= 0; i++) {
                if (troco.papeisMoeda[i] != null) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public PapelMoeda next() {
            PapelMoeda ret = null;
            for (int i = 6; i >= 0 && ret == null; i++) {
                if (troco.papeisMoeda[i] != null) {
                    ret = troco.papeisMoeda[i];
                    troco.papeisMoeda[i] = null;
                }
            }
            return ret;
        }

        @Override
        public void remove() {
            next();
        }
    }
}
