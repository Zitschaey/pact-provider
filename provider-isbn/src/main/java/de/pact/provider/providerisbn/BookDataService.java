package de.pact.provider.providerisbn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookDataService {

  private List<Book> books = new ArrayList<>();

  public BookDataService() {
    books.add(new Book("9780590353427", "J.K. Rowling", "Harry Potter and the Sorcerer's Stone", 1));
    books.add(new Book("059035342X", "Harper Lee", "To Kill a Mockingbird", 2));
    books.add(new Book("9780446310789", "Harper Lee", "To Kill a Mockingbird", 3));
    books.add(new Book("045152493", "George Orwell", "1984", 4));
  }

  public Book getBookById(int id) {

    for (Book book : books) {
      if (book.getId() == id) {
        return book;
      }
    }
    return null;
  }
}
