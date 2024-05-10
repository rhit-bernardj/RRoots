package main;

import java.util.List;
//frame for each question
public class Question {
    private String text;
    private List<String> options;

    public Question(String text, List<String> options) {
        this.text = text;
        this.options = options;
    }

    public String getText() {
        return text;
    }

    public List<String> getOptions() {
        return options;
    }
}

