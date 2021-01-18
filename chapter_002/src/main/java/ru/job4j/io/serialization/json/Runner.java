package ru.job4j.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Runner {
    public static void main(String[] args) {
       Driver driverOut = new Driver();
       final Gson gson = new Gson().newBuilder().setPrettyPrinting().create();
       String jsonOut = gson.toJson(driverOut);

       try (BufferedWriter out = new BufferedWriter(new FileWriter("json_test.json"))) {
           out.write(jsonOut);
       } catch (IOException e) {
           e.fillInStackTrace();
       }
       StringBuffer jsonIn = new StringBuffer();
       try (BufferedReader in = new BufferedReader(new FileReader("json_test.json"))) {
           String inString;
           while ((inString = in.readLine()) != null) {
               jsonIn.append(inString);
           }
        } catch (IOException ex) {
           ex.fillInStackTrace();
        }
        Driver driverIn = gson.fromJson(jsonIn.toString(), Driver.class);
        System.out.println(driverIn);
        System.out.println(driverIn.equals(driverOut));
        System.out.println(driverOut.equals(driverIn));

    }
}

class Driver {
    int age = 21;
    String name = "Peduart";
    boolean adequate = false;
    String[] categories = new String[]{"B", "B1"};

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public boolean isAdequate() {
        return adequate;
    }

    public String[] getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "Driver{"
                + "age=" + age
                + ", name='" + name + '\''
                + ", adequate=" + adequate
                + ", categories=" + Arrays.toString(categories)
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Driver driver = (Driver) o;
        return age == driver.age
                && adequate == driver.adequate
                && Objects.equals(name, driver.name)
                && Arrays.equals(categories, driver.categories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(age, name, adequate);
        result = 31 * result + Arrays.hashCode(categories);
        return result;
    }
}
