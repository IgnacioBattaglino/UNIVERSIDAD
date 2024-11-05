package oo1;

import java.time.LocalDate;

public interface DateLapseInterface {
    LocalDate getFrom();
    LocalDate getTo();
    int sizeInDays();
    boolean includesDate(LocalDate other);
}
