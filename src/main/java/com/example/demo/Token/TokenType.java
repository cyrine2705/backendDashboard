package com.example.demo.Token;

public enum TokenType {

    BEARER("BEARER");

        private String state;
    TokenType (String state) {
            this.state = state;
        }
        public String getState() {
            return state;
        }
    }

