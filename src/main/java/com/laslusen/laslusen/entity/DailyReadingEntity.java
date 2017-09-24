package com.laslusen.laslusen.entity;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Map;

@Entity
@Table(name = "reading")
public class DailyReadingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Date date;
    private int pages;

    public DailyReadingEntity() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public DailyReadingEntity fromModel(Map.Entry<LocalDateTime, Integer> daily) {
        this.date = Date.valueOf(daily.getKey().toLocalDate());
        this.pages = daily.getValue();

        return this;
    }
}
