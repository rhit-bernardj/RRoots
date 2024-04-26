<<<<<<<< HEAD:recommendations/SelectedAnswers.java
package recommendations;

========
package main;
>>>>>>>> d908fb315c23f3bb56e0c1a267c1103dfd7c6c0d:SelectedAnswers.java
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
