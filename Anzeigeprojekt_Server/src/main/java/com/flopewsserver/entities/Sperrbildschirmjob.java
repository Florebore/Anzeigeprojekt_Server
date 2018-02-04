/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

/**
 *
 * @author Florian
 */
public class Sperrbildschirmjob extends Job implements Serializable {
    
    private String fxmllocation;
    private String imagelocation;
    private String displaynumber;

    
    public Sperrbildschirmjob() throws URISyntaxException{
    
    }
    
    
@JsonCreator

    public Sperrbildschirmjob(@JsonProperty("fxmllocation") String fxmllocation, @JsonProperty("imagelocation") String imagelocation,@JsonProperty("displaynumber") String displaynumber,@JsonProperty("timecreatedMillis") long timecreatedMillis, @JsonProperty("timestart")long timestart,@JsonProperty("timeend") long timeend, @JsonProperty("beendet") Boolean beendet) throws URISyntaxException {
        
        super(timecreatedMillis, timestart, timeend, beendet);
        this.fxmllocation = fxmllocation;
        this.imagelocation = imagelocation;
        this.displaynumber = displaynumber;
        
    }
    


public void setfxmllocation(String fxmlloc){
        
this.fxmllocation = fxmlloc;        

}

public String getfxmllocation(){
return this.fxmllocation;}

public void setdisplaynumber(String number){
    
    this.displaynumber = number;
   
}

public String getdisplaynumber(){
return this.displaynumber;
}

public String getimagelocation(){
    return this.imagelocation;
}

public void setimagelocation(String imagelocation){
this.imagelocation = imagelocation;}
        
}
;