package com.elitekaycy.ascii;

import static spark.Spark.*;

import com.elitekaycy.ascii.core.AsciiGenerator;
import java.util.Map;

public class App {
  public static void main(String[] args) {
    port(8000);
    staticFiles.header("Content-Type", "text/html; charset=utf-8");
    staticFiles.location("/public");

    get("/ping", (req, res) -> "pong");

    post(
        "/ascii",
        (req, res) -> {
          String json = req.body();

          var mapper = new com.fasterxml.jackson.databind.ObjectMapper();
          String input = mapper.readTree(json).get("input").asText();
          String ascii = AsciiGenerator.generate(input);
          res.type("application/json");
          return mapper.writeValueAsString(Map.of("ascii", ascii));
        });
  }
}
