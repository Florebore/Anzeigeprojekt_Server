/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 *
 * @author Florian
 */

//TODO abstrakte Klasse Job mit Unterklasse TODO welche Attribute muss ein Job enthalten
// Referenz auf MainViewControllerm, um auf Methoden zuzugreifen
// Beispielsweise werden Aufrufmethode und Attribute getrennt

public class Job implements Serializable {
    
 protected long timecreatedMillis;
 //protected LocalDateTime timecreatedLocalDatetime;
 protected long timestart;
 protected long timeend; 
 protected Boolean beendet;
  
  // einmal wöchentlich etc sind die möglichen Ausführungsformen
  public String Wiederholung;


    public Job(long timecreatedMillis, long timestart, long timeend, Boolean beendet) {
        this.timecreatedMillis = System.currentTimeMillis();
        //this.timecreatedLocalDatetime = LocalDateTime.now();
        this.timestart = timestart;
        this.timeend = timeend;
        this.beendet = beendet;
        
    }
  
  
    
   
    public Job() throws URISyntaxException {
        
        timecreatedMillis = System.currentTimeMillis();
        
       
        
    }
    
    public void settimecreated(long timecocreated){
    
    this.timecreatedMillis = timecocreated;
    
    }

    public Boolean getBeendet() {
        return beendet;
    }

    public void setBeendet(Boolean beendet) {
        this.beendet = beendet;
    }

    public String getWiederholung() {
        return Wiederholung;
    }

    public void setWiederholung(String Wiederholung) {
        this.Wiederholung = Wiederholung;
    }
    
    public void settimestart(long timecostart){
    
    this.timestart = timecostart;    
    }
    
    public void settimeend (long timecoend) {
    
    this.timeend = timecoend;
    } 
    
    public long gettimecreatedMillis(){
    
    return this.timecreatedMillis;
    }
    
    public long gettimestart(){
        
        return this.timestart;
    }
    
    public long gettimeend(){
    
        return this.timeend;
    }
    
    // Converts LocalDateTime to long milliseconds
    public long convertdatetimetomillis(LocalDateTime datetime){
        
    LocalDateTime localDT = datetime;
    long localDTInMilli = localDT.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
      return localDTInMilli;
    }
    
    //Converts long milliseconds to LocalDateTime
    
    public LocalDateTime convertmillistoLocalDatetime(long millis){
    
    long milliseconds = millis;
    LocalDateTime cvDate = Instant.ofEpochMilli(milliseconds).atZone(ZoneId.systemDefault()).toLocalDateTime();

    return cvDate;}
    
}
