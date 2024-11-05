package oo1;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateLapse implements DateLapseInterface{
    private LocalDate from;
    private LocalDate to;
    
    public DateLapse(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public LocalDate getFrom() {
        return from;
    }

    @Override
    public LocalDate getTo() {
        return to;
    }
    
    @Override
    public int sizeInDays(){
        return (int) this.from.until(to, ChronoUnit.DAYS);
    }

    @Override
    public boolean includesDate (LocalDate other){
        return (from.isBefore(other)|| from.isEqual(other)) && (to.isAfter(other)||to.isEqual(other));
    }
    
}
