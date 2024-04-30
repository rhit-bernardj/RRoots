package main;

public class SelectedAnswer {
    private String question;
    private String option;

    public SelectedAnswer(String question, String option) {
        this.question = question;
        this.option = option;
    }

    public String getQuestion() {
        return question;
    }

    public String getOption() {
        return option;
    }
}
