package com.laslusen.laslusen.core;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Bok {

    String titel;
    Map<LocalDateTime, Integer> dagensLäsning;
    private int LastPage;

    public Bok(String titel){
        this.titel = titel;
        dagensLäsning = new HashMap<>();
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public Map<LocalDateTime, Integer> getDagensLäsning() {
        return dagensLäsning;
    }

    public void setDagensLäsning(int dagensLäsning) {
        getDagensLäsning().put(LocalDateTime.now(), dagensLäsning);
    }

    public void setSlutadeLäsa(int lastPage) {
        this.LastPage = lastPage;
    }

    public int getLastPage() {
        return LastPage;
    }
}
