package com.example.demo.service;

public class Invoice {

        private final long id;
        private final String content;

        public Invoice(long id, String content) {
            this.id = id;
            this.content = content;
        }

        public long getId() {
            return id;
        }

        public String getContent() {
            return content;
        }
    }

