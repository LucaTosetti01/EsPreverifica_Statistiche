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
public class ThSpazi extends Thread {

    private CDatiCondivisi PtrDati;

    public ThSpazi(CDatiCondivisi dati) {
        PtrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < PtrDati.getNumCaratteri(); i++) {
                PtrDati.WaitSem3();
                
                if(PtrDati.getCarattereEstratto()==' ') {
                PtrDati.setNumSpaziLetti(PtrDati.getNumSpaziLetti() + 1);
                }
                
                PtrDati.SignalSem4();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThSpazi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
