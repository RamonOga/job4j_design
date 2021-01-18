package ru.job4j.io.serialization.json;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.json.JSONObject;
import org.json.JSONPropertyIgnore;

import java.io.Writer;

public class ClassB {
    private ClassA a;

    @JSONPropertyIgnore
    public ClassA getA() {
        return a;
    }

    public void setA(ClassA a) {
        this.a = a;
    }

    public static void main(String[] args) {
        Driver driver = new Driver();
        Contact contact = new Contact("+11111111");
        Person person = new Person(true, 23, contact, "one", "two");
        System.out.println(new JSONObject(person).toString());

    }
}
