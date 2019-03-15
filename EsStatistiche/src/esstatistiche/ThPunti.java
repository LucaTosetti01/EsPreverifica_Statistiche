/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class ThPunti extends Thread {

    private CDatiCondivisi PtrDati;

    public ThPunti(CDatiCondivisi dati) {
        PtrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < PtrDati.getNumCaratteri(); i++) {
                PtrDati.WaitSem2();
                
                if(PtrDati.getCarattereEstratto()=='.') {
                PtrDati.setNumPuntiLetti(PtrDati.getNumPuntiLetti() + 1);
                }
                
                PtrDati.SignalSem3();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThPunti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
