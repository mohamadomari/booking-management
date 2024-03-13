package com.fintechpath.booking.controller;
import org.springframework.http.ResponseEntity;
import com.fintechpath.booking.services.BookingServices;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.example.Account;
import org.example.Body;
import org.example.Book;
import org.example.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/*TODO List :
* swagger
* logger
* name convention (Booking Controller ....etc  ).done
* RequestBody (customer name:Booking System  , amount , account (person , account number , int visa card)   ).done
* properties
* eureka server :
* */


@RestController
@RequestMapping("/booking")
@Slf4j
public class BookingController
{
    private static final Logger log=LoggerFactory.getLogger(BookingController.class);

    BookingServices bookingServices;
    @Autowired
    public BookingController(BookingServices bookingService)
    {
        this.bookingServices= bookingService;
    }
    @PostMapping("/addBook")
    public void addNewBook(@RequestBody Book book)
    {
        log.info("Adding a new Book with title: "+book.getTitle());
         bookingServices.addNewBook(book);
    }
    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id)
    {
        log.info("Deleting a Book with id:"+id);
        return bookingServices.deleteBook(id);
    }
    @GetMapping("/getBooks")
    public List<Book> showBooks()
    {
        log.info("Showing all the books");
        return bookingServices.showBook();
    }
    @PutMapping()
    public String updateBook(@RequestParam int id,@RequestBody Book book)
    {
        log.info("updating a Book with id:"+book.getId());
         return bookingServices.updateBook(id,book);
    }
//    @PostMapping("/test")
//    public Body Pay()
//    {
//        Person person= new Person("Bashar","Edghaim","0.5","Male","123456789");
//        Account account= new Account(person,987654321,1234567891);
//        Body body= new Body("Booking Service",12.0,account);
//        return body;
//    }



}
