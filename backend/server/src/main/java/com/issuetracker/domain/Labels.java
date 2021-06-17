package com.issuetracker.domain;

import java.util.ArrayList;
import java.util.List;

public class Labels {

    private final List<Label> labels = new ArrayList<>();

    public void add(Label label) {
        labels.add(label);
    }

    public List<Label> toList() {
        return labels;
    }

    public List<Label> getLabels() {
        return labels;
    }
}
