package main;

import java.util.List;

public class SelectedAnswer {
    private Integer questionIndex;
    private List<String> selectedOptions;
    private Object getSelectedOption;

    public SelectedAnswer(Integer questionIndex, List<String> selectedOptions) {
        this.questionIndex = questionIndex;
        this.selectedOptions = selectedOptions;
    }

    public SelectedAnswer(String string) {
        //TODO Auto-generated constructor stub
        
    }

    public Integer getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(Integer questionIndex) {
        this.questionIndex = questionIndex;
    }

    public List<String> getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(List<String> selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    // Method to retrieve the selected option (assuming it's the first one in the list)
    public String getSelectedOption() {
        if (selectedOptions != null && !selectedOptions.isEmpty()) {
            return selectedOptions.get(0); // Return the first selected option
        }
        return null; // Handle empty or null selectedOptions gracefully
    }
}
