package ru.job4j.tictaktoe;

public class Player {
    private final Figure figure;
    private Input input;

    Player (Figure figure) {
        this.figure = figure;
        input = new Scanner();
    }

    public Figure getFigure() {
        return figure;
    }
}
