package com.example.dataindexer.test

trait RestTest {
    String getUrlFrom(String parameter, int port) {
        return "http://localhost:" + port + "/" + parameter
    }
}