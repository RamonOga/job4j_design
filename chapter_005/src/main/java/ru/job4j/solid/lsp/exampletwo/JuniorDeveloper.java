package ru.job4j.solid.lsp.exampletwo;

public class JuniorDeveloper extends Developer {

    @Override
    public Task doWork(Task task) {
        for (int i = 0; i < (task.getComplexity() * 100) / skill; i++) {
            System.out.println("do something");
        }
        task.setComment("task completed");
        return task;
    }
}

