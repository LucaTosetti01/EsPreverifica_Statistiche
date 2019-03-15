/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tosetti_luca
 */
public class ThGeneraCaratteri extends Thread {

    private char[] array = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', ' ', '.', ' ', '.', ' ', '.'};
    private CDatiCondivisi PtrDati;

    public ThGeneraCaratteri(CDatiCondivisi dati) {
        PtrDati = dati;
    }

    public void run() {
        try {
            for (int i = 0; i < PtrDati.getNumCaratteri(); i++) {

                Random rand = new Random();
                int NumRand = rand.nextInt(array.length);

                PtrDati.WaitSem1();
                PtrDati.setCarattereEstratto(array[NumRand]);
                PtrDati.getBuffer().add(String.valueOf(PtrDati.getCarattereEstratto()));
                if (PtrDati.getCarattereEstratto() == '.') {
                    PtrDati.setNumPuntiInseriti(PtrDati.getNumPuntiInseriti() + 1);
                }
                if (PtrDati.getCarattereEstratto() == ' ') {
                    PtrDati.setNumSpaziInseriti(PtrDati.getNumSpaziInseriti() + 1);
                }
                
                PtrDati.SignalSem2();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ThGeneraCaratteri.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
