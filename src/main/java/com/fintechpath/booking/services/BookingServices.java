package com.fintechpath.booking.services;

import org.springframework.http.ResponseEntity;
import com.fintechpath.booking.controller.BookingController;
import org.example.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BookingServices {
    private static final Logger log= LoggerFactory.getLogger(BookingServices.class);
    private int id=0;

    ArrayList<Book> books =new ArrayList<>();
    public void addNewBook(Book book)
    {
        try {
            books.add(book);
            book.setId(++id);
            log.info("Adding book with id ="+book.getId()+" Succeed.");
        }
        catch (Exception exception)
        {
            log.error("Adding book with id ="+book.getId()+" Failed.");
        }
    }
     public List<Book> showBook()
     {
         String showenId="";
         for (Book book : books)
         {
             showenId=showenId+book.getId()+",";
         }
         log.info("showing books with ids:"+showenId);
         return books;
     }
    public String deleteBook(int id)
    {
        int counter = -1;
        for (Book checkBook : books)
        {
            counter++;
            if (checkBook.getId() == id)
            {
                books.remove(counter);
                log.info("The book with id = "+id+" deleted successfully");
                return "The book with id = "+id+" deleted successfully";
            }
        }
        log.error("Didn't find a book with id = "+id);
        return "Didn't find a book with id = "+id;
    }
    public String updateBook(int id,Book book)
    {
        for (Book checkBook : books)
        {
            if (checkBook.getId() == id)
            {
                checkBook.setTitle(book.getTitle());
                checkBook.setAuthorName(book.getAuthorName());
                checkBook.setBookType(book.getBookType());
                checkBook.setUsedLanguage(book.getUsedLanguage());
                checkBook.setQuantity(book.getQuantity());
                checkBook.setPrice(book.getPrice());
                log.info("The book with id = "+id+" Updated Successfully");
                return "The book Updated Successfully";
            }
        }
        log.error("Didn't find a book with id = "+id);
        return "Didn't find a book with id = "+id;
    }
//    public String buyBook(String cardNumber,String firstname,String lastName, int bookId, int quantity) {
//
//            for (Book checkBook : books)
//            {
//                if (checkBook.getId() == bookId) {
//                    if (checkBook.getQuantity() >= quantity) {
//                        checkBook.setQuantity((checkBook.getQuantity() - quantity));
//                        if (checkBook.getQuantity() == 0) {
//                            books.remove(checkBook.getId());
//
//                        }
////                    Book newBook=book;
////                    for (Book checkPersonBook : myBook) {
////                        if (checkPersonBook.getID() == newBook.getID()) {
////                            checkPersonBook.setAmountOfBook((checkPersonBook.getAmountOfBook()+quantity));
////                        }
////                        else{
////                            newBook.setAmountOfBook(quantity);
////                            myBook.add(newBook.getID(), newBook);
////                        }
////                    }
//
//
//                        return "The purchase has been done successfully";
//                    } else {
//                        return "there is only " + quantity + " book";
//                    }
//                }
//            }
//            return "Didn't Find a book with this id";
//        }




}
