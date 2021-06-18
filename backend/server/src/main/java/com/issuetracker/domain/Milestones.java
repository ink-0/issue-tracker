package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Milestones {
    private final List<Milestone> milestones = new ArrayList<>();

    public void add(Milestone milestone) {
        milestones.add(milestone);
    }

    public List<Milestone> toList() {
        return milestones;
    }
    
}
