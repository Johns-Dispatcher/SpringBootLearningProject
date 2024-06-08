package pers.johns.springboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.johns.springboot.config.BookContainer;
import pers.johns.springboot.exception.BookNotFoundException;
import pers.johns.springboot.exception.IsbnNotFoundException;
import pers.johns.springboot.model.BookRecord;

import java.util.Optional;


/**
 * ClassName    : BookController
 * Description  :
 * CreateTime   : 2024/6/8 16:01
 *
 * @author : JohnS
 * @version : 1.0
 */

@RequiredArgsConstructor
@RestController
@RequestMapping("/book")
public class BookController {

    private final BookContainer bookContainer;

    @GetMapping("/query")
    public BookRecord queryBook(String isbn, HttpServletRequest request) {

        if (isbn == null || isbn.isEmpty()) {
            // throw new BookNotFoundException("ISBN不能为空");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "ISBN不能为空", request);
        }

        Optional<BookRecord> bookRecord = bookContainer.getBooks()
                .stream()
                .filter(book -> book.isbn().equals(isbn))
                .findFirst();

        if (bookRecord.isEmpty()) {
            // throw new BookNotFoundException("ISBN为" + isbn + "的书不存在");
            throw new IsbnNotFoundException(HttpStatus.NOT_FOUND, "ISBN为" + isbn + "的书不存在", request);
        }

        return bookRecord.get();
    }
}
