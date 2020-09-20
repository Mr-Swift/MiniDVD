package com.apple.developer.luc01;

public class DVDSet {
    private String name;
    private String state;
    private String date;
    private int counts;

    public DVDSet(String name,String state,String date,int counts)
    {
        this.name=name;
        this.state=state;
        this.date = date;
        this.counts=counts;
    }

    public void setName(String name)
    {
        this.name=name;
    }

    public void setState(String state)
    {
        this.state=state;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public void resetCounts()
    {
        this.counts=0;
    }

    public void setCounts(int counts)
    {
        this.counts=counts;
    }

    public void countAdd()
    {
        this.counts=this.counts+1;
    }

    public String getName()
    {
        return name;
    }

    public String getState()
    {
        return state;
    }

    public String getDate()
    {
        return date;
    }

    public int getCounts()
    {
        return counts;
    }
}
