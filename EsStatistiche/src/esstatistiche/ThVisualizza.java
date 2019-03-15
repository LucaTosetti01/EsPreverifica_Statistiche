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
public class ThVisualizza extends Thread {

    private CDatiCondivisi PtrDati;

    public ThVisualizza(CDatiCondivisi dati) {
        PtrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < PtrDati.getNumCaratteri(); i++) {
                PtrDati.WaitSem4();
                
                System.out.println("----------------------------------------------");
                System.out.println(PtrDati.getBuffer().toString());
                System.out.println("Il numero di spazi inseriti: " + PtrDati.getNumSpaziInseriti());
                System.out.println("Il numero di punti inseriti: " + PtrDati.getNumPuntiInseriti());
                System.out.println("Il numero di spazi letti: " + PtrDati.getNumSpaziLetti());
                System.out.println("Il numero di punti letti: " + PtrDati.getNumPuntiLetti());
                System.out.println("----------------------------------------------");
                
                PtrDati.SignalSem1();
            }
            
            PtrDati.SignalSemJoin();
            
        } catch (InterruptedException ex) {
            Logger.getLogger(ThVisualizza.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
