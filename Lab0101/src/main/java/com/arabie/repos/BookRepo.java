package com.arabie.repos;

import com.arabie.domain.Book;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BookRepo {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("BookShop");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    private static BookRepo instance = null;

    public static BookRepo getInstance() {
        if (instance == null) {
            synchronized (BookRepo.class) {
                if (instance == null) {
                    instance = new BookRepo();
                }
            }
        }
        return instance;
    }

    public Book insert(String title, int totalPAges, double rating, String type) {
        Book book = null;
        try {
            entityManager.getTransaction().begin();
            book = new Book(title, totalPAges, rating, type);
            entityManager.persist(book);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            entityManager.getTransaction().commit();
        }
        System.out.println("Book Inserted");
        return book;
    }

    public Book select(int id) {
        Book book = null;
        try {
            // entityManager.getTransaction().begin();
            book = (Book) entityManager.find(Book.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // entityManager.getTransaction().commit();
        }

        return book;
    }

    public Book updateBookName(int id, String title) {
        Book book = null;
        try {
            entityManager.getTransaction().begin();
            book = (Book) entityManager.find(Book.class, id);
            book.setTitle(title);
            entityManager.merge(book);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
        return book;
    }

    public boolean removeBook(int id) {
        try {

            entityManager.getTransaction().begin();
            Book book = (Book) entityManager.find(Book.class, id);
            entityManager.remove(book);
            // entityManager.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.getTransaction().commit();
        }
        return true;

    }

    public List<Book> selectAllBooks() {
        List<Book> listOfBooks = null;
        try {
            // entityManager.getTransaction().begin();
            
            listOfBooks =  entityManager.createQuery("from book").getResultList();
                                        
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // entityManager.getTransaction().commit();
        }
        return listOfBooks;
    }
}