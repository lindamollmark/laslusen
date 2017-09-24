package com.laslusen.laslusen.service;

import com.laslusen.laslusen.core.Bok;
import com.laslusen.laslusen.dao.BokDao;
import com.laslusen.laslusen.entity.BokEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {
    Scanner in = new Scanner(System.in);

    @Autowired
    private BokDao dao;

    public void start(){
        System.out.println("Hej! Vill du registrera läsning på en (1)påbörjad bok eller en (2)ny bok?");
        int val = Integer.parseInt(in.nextLine());
        if (val == 1){
            System.out.println("Välj bok från listan: " +
                    "\n 1: Sagan om ringen" +
                    "\n 2: Stjärnornas Krig" +
                    "\n 3: Fångad av kärlek");
        }
        else{

            String titel = nyBok();
            Bok nybok = new Bok(titel);

            dagensLäsning(titel, nybok);

            slutadeLäsaVidSida(nybok);

            BokEntity bokEntity = new BokEntity().fromModel(nybok);

            dao.save(bokEntity);

        }

    }

    private String nyBok() {
        System.out.println("Vad heter boken som du läst?");
        return in.nextLine();
    }

    private void slutadeLäsaVidSida(Bok nybok) {
        System.out.println("Vilken sida slutar du på?");
        int lastPage = in.nextInt();
        nybok.setSlutadeLäsa(lastPage);
    }

    private void dagensLäsning(String titel, Bok nybok) {
        System.out.println("Hur många sidor har du läst i " + titel + "?");
        int dagensAntal = in.nextInt();
        nybok.setDagensLäsning(dagensAntal);
    }
}
