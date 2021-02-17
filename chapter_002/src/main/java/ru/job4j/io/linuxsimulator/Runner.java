package ru.job4j.io.linuxsimulator;

public class Runner {

    public static void main(String[] args) {
      IO io = IO.getIO();
      Shell shell = new Shell();

      io.greeting();
      String[] userLine = io.scan();
      while (!userLine[0].equals("exit")) {
          switch (userLine[0]) {
              case "cd" -> {
                  shell.cd(userLine[1]);
              }
              case "pwd" -> {
                  shell.pwd();
              }
              default -> shell.cnf();
          }
            userLine = io.scan();
        }
    }
}
