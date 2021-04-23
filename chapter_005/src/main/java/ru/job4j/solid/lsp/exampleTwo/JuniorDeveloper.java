package ru.job4j.solid.lsp.exampleTwo;

public class JuniorDeveloper extends Developer{

    @Override
    public Task doWork(Task task) {
        for (int i = 0; i < (task.getComplexity() * 100) / skill; i++) {
            //work code
        }
        task.setComment("task completed");
        return task;
    }
}

