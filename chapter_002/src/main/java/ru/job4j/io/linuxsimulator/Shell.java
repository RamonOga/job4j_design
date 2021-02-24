package ru.job4j.io.linuxsimulator;

public class Shell {

    ShallPath sp = new ShallPath();

    public void cd(String path) {
        String[] pathArr = path.split("/");
        for (String s : pathArr) {
            if (s.equals("..")) {
                sp.pop();
            } else {
                if (!s.equals("")) {
                    sp.push(s);
                }
            }
        }
    }

    public String pwd() {
        return sp.print();
    }

    public void cnf() {
        System.out.println("Command not found");
    }
}
