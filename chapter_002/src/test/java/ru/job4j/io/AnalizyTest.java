package ru.job4j.io;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import java.io.*;

public class AnalizyTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

        @Test
        public void unavailableTest()throws IOException {
            Analizy anal = new Analizy();
            String expected1 = "10:57:01;10:59:01";
            String expected2 = "11:01:02;11:02:02";
            String rsl1 = "";
            String rsl2 = "";
            File source = folder.newFile("source.txt");
            File target = folder.newFile("target.txt");
            try (PrintWriter out = new PrintWriter(source)) {
                out.write("200 10:56:01");
                out.append(System.lineSeparator());
                out.write("500 10:57:01");
                out.append(System.lineSeparator());
                out.write("400 10:58:01");
                out.append(System.lineSeparator());
                out.write("200 10:59:01");
                out.append(System.lineSeparator());
                out.write("500 11:01:02");
                out.append(System.lineSeparator());
                out.write("200 11:02:02");
            }
            anal.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
            try (BufferedReader in = new BufferedReader(new FileReader(target.getAbsolutePath()))) {
                rsl1 = in.readLine();
                rsl2 = in.readLine();

            } catch (Exception e) {
                e.printStackTrace();
            }
            Assert.assertEquals(expected1, rsl1);
            Assert.assertEquals(expected2, rsl2);
        }
}