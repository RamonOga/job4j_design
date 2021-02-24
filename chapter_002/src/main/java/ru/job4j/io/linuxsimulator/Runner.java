package ru.job4j.io.linuxsimulator;

public class Runner {

    public static void main(String[] args) {
      IO io = IO.getIO();
      Shell shell = new Shell();
      io.greeting();
      String[] userLine = io.scan();
      while (!userLine[0].equals("exit")) {
          switch (userLine[0]) {
              case "cd":
                  shell.cd(userLine[1]);
                  break;
              case "pwd":
                  shell.pwd();
                  break;
              default:
                  shell.cnf();
          }
            userLine = io.scan();
        }
    }
}
