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
        int[] pm = {2, 5, 10, 20, 50, 100};
        papeisMoeda = new PapelMoeda[6];
        boolean achou = false;

        for (int i = 0; valor > 0; i++) {
            int cont = 0;
            
            for (int j = 0; j < pm.length && !achou; j++) {
                if (pm[i] == valor) {
                    while (valor % pm[i] != 0) {
                        cont++;
                    }
                    papeisMoeda[i] = new PapelMoeda(pm[i], cont);
                    valor = valor - (pm[i] * cont);
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
