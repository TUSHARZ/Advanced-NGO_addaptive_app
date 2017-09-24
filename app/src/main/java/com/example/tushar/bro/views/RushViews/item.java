package com.example.tushar.bro.views.RushViews;


import com.example.tushar.bro.entities.RushEvent;

import java.util.List;

public class item {

    public int type;
    public String header;
    public RushEvent rushEvent;
    public List<item> invisibleChildren;

    public item(int type, String header) {

        this.type = type;
        this.header = header;
    }

    public item(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }
}

