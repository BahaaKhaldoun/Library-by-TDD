package org.example;

public class book {
    int id;
    String title;
    String author;
    bookType type;
    bookStatus status;

    public book(int id, String title, String author, bookType type, bookStatus status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.type = type;
        this.status = status;
    }
}
