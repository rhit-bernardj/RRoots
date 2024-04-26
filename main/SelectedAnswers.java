package main;
public class SelectedAnswers {
    private String question;
    private String option;

    public SelectedAnswers(String question, String option) {
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
