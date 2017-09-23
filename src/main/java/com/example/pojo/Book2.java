package com.example.pojo;

public class Book2 {
    private long bookId;
    private String name;
    private int number;

    public Book2(
            final long bookId,
            final String name,
            final int number) {
        this.bookId = bookId;
        this.name = name;
        this.number = number;
    }

    public long getBookId() {
        return bookId;
    }

    public void setBookId(final long bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(final int number) {
        this.number = number;
    }
}
