package com.laslusen.laslusen.entity;

import com.laslusen.laslusen.core.Bok;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "book")
public class BokEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String titel;

    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @JoinColumn(name="dailyReading", referencedColumnName = "id")
    private List<DailyReadingEntity> dailyReading = new ArrayList<>();

    private int LastPage;


    public BokEntity(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public List<DailyReadingEntity> getDailyReading() {
        return dailyReading;
    }

    public void setDailyReading(List<DailyReadingEntity> dailyReading) {
        this.dailyReading = dailyReading;
    }

    public int getLastPage() {
        return LastPage;
    }

    public void setLastPage(int lastPage) {
        LastPage = lastPage;
    }

    public BokEntity fromModel(Bok nybok) {
        this.titel = nybok.getTitel();

        List<DailyReadingEntity> reading = new ArrayList<>();
        for (Map.Entry<LocalDateTime, Integer> daily :nybok.getDagensLäsning().entrySet()){
            DailyReadingEntity entity = new DailyReadingEntity();
            entity = entity.fromModel(daily);
            reading.add(entity);
        }
        this.dailyReading = reading;
        this.LastPage = nybok.getLastPage();

        return this;
    }
}
