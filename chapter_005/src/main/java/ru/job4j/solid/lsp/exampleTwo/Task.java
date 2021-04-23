package ru.job4j.solid.lsp.exampleTwo;

public class Task {
    private int complexity;
    String comment = "";

    public Task(int complexity) {
        this.complexity = complexity;
    }

    public int getComplexity() {
        return complexity;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
