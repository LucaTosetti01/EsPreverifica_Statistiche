/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esstatistiche;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 *
 * @author tosetti_luca
 */
public class CDatiCondivisi {
    private int NumCaratteri,NumSpaziInseriti,NumPuntiInseriti,NumSpaziLetti,NumPuntiLetti;
    private char CarattereEstratto;
    private ArrayList<String> buffer;
    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;
    private Semaphore semJoin;
    
    public CDatiCondivisi() {
        sem1=new Semaphore(1);
        sem2=new Semaphore(0);
        sem3=new Semaphore(0);
        sem4=new Semaphore(0);
        semJoin=new Semaphore(0);
        NumCaratteri=0;
        NumSpaziInseriti=0;
        NumPuntiInseriti=0;
        NumSpaziLetti=0;
        NumPuntiLetti=0;
        CarattereEstratto='/';
        buffer=new ArrayList<String>();
    }

    public synchronized int getNumCaratteri() {
        return NumCaratteri;
    }

    public synchronized void setNumCaratteri(int NumCaratteri) {
        this.NumCaratteri = NumCaratteri;
    }

    public synchronized int getNumSpaziInseriti() {
        return NumSpaziInseriti;
    }

    public synchronized void setNumSpaziInseriti(int NumSpaziInseriti) {
        this.NumSpaziInseriti = NumSpaziInseriti;
    }

    public synchronized int getNumPuntiInseriti() {
        return NumPuntiInseriti;
    }

    public synchronized void setNumPuntiInseriti(int NumPuntiInseriti) {
        this.NumPuntiInseriti = NumPuntiInseriti;
    }

    public synchronized int getNumSpaziLetti() {
        return NumSpaziLetti;
    }

    public synchronized void setNumSpaziLetti(int NumSpaziLetti) {
        this.NumSpaziLetti = NumSpaziLetti;
    }

    public synchronized int getNumPuntiLetti() {
        return NumPuntiLetti;
    }

    public synchronized void setNumPuntiLetti(int NumPuntiLetti) {
        this.NumPuntiLetti = NumPuntiLetti;
    }

    public synchronized char getCarattereEstratto() {
        return CarattereEstratto;
    }

    public synchronized void setCarattereEstratto(char CarattereEstratto) {
        this.CarattereEstratto = CarattereEstratto;
    }

    public synchronized ArrayList<String> getBuffer() {
        return buffer;
    }

    public synchronized void setBuffer(ArrayList<String> buffer) {
        this.buffer = buffer;
    }

    public void WaitSem1() throws InterruptedException {
        sem1.acquire();
    }
    
    public void SignalSem1() {
        sem1.release();
    }
    
    public void WaitSem2() throws InterruptedException {
        sem2.acquire();
    }
    
    public void SignalSem2() {
        sem2.release();
    }
    
    public void WaitSem3() throws InterruptedException {
        sem3.acquire();
    }
    
    public void SignalSem3() {
        sem3.release();
    }
    
    public void WaitSem4() throws InterruptedException {
        sem4.acquire();
    }
    
    public void SignalSem4() {
        sem4.release();
    }
    
    public void WaitSemJoin() throws InterruptedException {
        semJoin.acquire();
    }
    
    public void SignalSemJoin() {
        semJoin.release();
    }
    
}
