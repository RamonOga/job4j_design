package ru.job4j.solid.lsp.exampleTwo;

public class Developer {
    int skill;

    public Task doWork(Task task) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < (task.getComplexity() * 100) / skill; i++) {
            //work code
        }
        long finish = System.currentTimeMillis();
        long workTime = finish - start;
        if (workTime >= 5000) {
            task.comment = "So long";
        }
        return task;
    }
}
