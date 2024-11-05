package oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapseb implements DateLapseInterface{
    private LocalDate from;
    private int sizeInDays;
    
    public DateLapseb(LocalDate from, LocalDate to) {
        this.from = from;
        this.sizeInDays = (int) from.until(to, ChronoUnit.DAYS);
    }

    @Override
    public LocalDate getFrom() {
        return from;
    }

    @Override
    public LocalDate getTo() {
        return from.plusDays(sizeInDays);
    }
    
    @Override
    public int sizeInDays(){
        return this.sizeInDays;
    }

    @Override
    public boolean includesDate (LocalDate other){
        return (from.isBefore(other)|| from.isEqual(other)) && (this.getTo().isAfter(other)||this.getTo().isEqual(other));
    }
    
}
