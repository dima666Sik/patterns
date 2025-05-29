package ua.org.pattern.behavioral;

import java.util.Iterator;

// iterator pattern
class Main {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection(3);
        collection.add(new Book("Java Basics"));
        collection.add(new Book("Design Patterns"));
        collection.add(new Book("Effective Java"));

        for (Book book : collection) {
            System.out.println(book.title);
        }
    }
}

class Book {
    String title;
    Book(String title) {
        this.title = title;
    }
}

class BookCollection implements Iterable<Book> {
    private Book[] books;
    private int size = 0;

    public BookCollection(int capacity) {
        books = new Book[capacity];
    }

    public void add(Book book) {
        if (size < books.length) {
            books[size++] = book;
        }
    }

    @Override
    public Iterator<Book> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Book next() {
                return books[index++];
            }
        };
    }
}
