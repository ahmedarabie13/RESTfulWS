package com.arabie.webservices;

import java.util.List;
import com.arabie.domain.Book;
import com.arabie.repos.BookRepo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

@Path("books")
public class BookRestService {
    @GET
    @Path("{bookId}")
    @Produces({"application/xml","application/json"})
    @Consumes({"application/xml","application/json"})
    public Book getBook(@PathParam("bookId")int id){
        return BookRepo.getInstance().select(id);
    }

    @GET
    @Produces({"application/xml","application/json"})
    public List<Book> getAllBooks(){
        return BookRepo.getInstance().selectAllBooks();
    }
    
    @PUT  
    @Path("{bookId}")
    @Consumes({"application/xml","application/json"})
    @Produces({"application/xml","application/json"})
    public Book updateBook(@PathParam("bookId")int id, Book book){
        return BookRepo.getInstance().updateBookName(id, book.getTitle());
    }

    @DELETE
    @Path("{bookId}")
    public boolean deleteBook(@PathParam("bookId")int id){
        return BookRepo.getInstance().removeBook(id);
    }

    @POST
    @Consumes({"application/xml","application/json"})
    @Produces({"application/xml","application/json"})
    public Book addBook(Book book){
        return BookRepo.getInstance().insert(book.getTitle()
        , book.getTotalPAges(), book.getRating(), book.getType());
    }    
}
