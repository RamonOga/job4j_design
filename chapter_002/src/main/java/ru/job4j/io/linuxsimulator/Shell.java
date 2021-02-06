package ru.job4j.io.linuxsimulator;

import java.util.StringJoiner;

public class Shell {

    String root = "/";

    public void cd(String s) {
        if (s.equals("-1")) {
            cnf();
        } else if (s.equals("..")) {
            prevStep();
        } else {
            root = root + s + "/";
        }
    }

    public String pwd() {
        System.out.println(root);
        return root;
    }

    public void ls(String s) {
        System.out.println("ls");
    }

    public void cnf() {
        System.out.println("Command not found");
    }

    private void prevStep() {
        String[] path = root.split("/");
        StringJoiner sj = new StringJoiner("/");
        for (int i = 1; i < path.length - 1; i++) {
            sj.add(path[i]);
        }
        root = sj.toString();
    }
}
