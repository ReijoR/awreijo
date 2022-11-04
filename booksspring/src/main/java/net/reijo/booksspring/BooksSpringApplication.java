package net.reijo.booksspring;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksSpringApplication {

    @Bean
    public CommandLineRunner springMain() {
        return args -> {
            System.out.println("Toimii!");
        };
    }

    /*    
        @Bean
        public CommandLineRunner runner(BookRepository rep){
            return args -> {
            System.out.println("All books");
            Iterable<Book> books = rep.findAll();
            for(Book b:books){
            System.out.println(b.getTitle());
            }
        };
    } 
    
     */
 /*
        @Bean
        public CommandLineRunner runner(AuthorRepository rep){
            return args -> {
            System.out.println("All authors");
            Iterable<Author> authors = rep.findAll();
            for(Author a:authors){
            System.out.println(a.getLastName());
            }
        };
    } 
     */
    @Bean
    public CommandLineRunner runner(AuthorRepository rep) {
        return args -> {
            System.out.println("Nimiä");
            List<Author> authorsByContains = rep.findByFirstNameContains("u");
            for (Author a : authorsByContains) {
                System.out.println(a);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(BooksSpringApplication.class, args);
    }

}
