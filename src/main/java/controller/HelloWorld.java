package controller;

import static spark.Spark.*;

public class HelloWorld {
    public static void main(String[] args) {
        secure("test.jks", System.getenv("password"), null, null);
        get("hello", (req, res) -> "Hello Secure World");
    }
}