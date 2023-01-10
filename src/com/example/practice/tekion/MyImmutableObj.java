package com.example.practice.tekion;

import java.util.Date;

final public class MyImmutableObj {
    private final String name;
    private final Date startDate;
    public MyImmutableObj(String name, Date startDate) {
        this.name = name;
        this.startDate = (Date) startDate.clone();
    }

    public String getName() {
        return name;
    }

    public Date getStartDate() {
        return startDate;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
