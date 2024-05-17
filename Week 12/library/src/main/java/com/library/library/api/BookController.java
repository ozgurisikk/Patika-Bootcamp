package com.library.library.api;

import com.library.library.business.abstracts.AuthorService;
import com.library.library.business.abstracts.BookService;
import com.library.library.business.abstracts.PublisherService;
import com.library.library.core.config.modelMapper.ModelMapperService;
import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.core.utilities.ResultHelper;
import com.library.library.dto.request.book.BookSaveRequest;
import com.library.library.dto.response.book.BookResponse;
import com.library.library.entities.Author;
import com.library.library.entities.Book;
import com.library.library.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;
    private final ModelMapperService modelMapperService;
    private final PublisherService publisherService;
    private final AuthorService authorService;

    public BookController(BookService bookService, ModelMapperService modelMapperService, PublisherService publisherService, AuthorService authorService) {
        this.bookService = bookService;
        this.modelMapperService = modelMapperService;
        this.publisherService = publisherService;
        this.authorService = authorService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        Book saveBook = this.modelMapperService.forRequest().map(bookSaveRequest, Book.class);
        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        saveBook.setAuthor(author);
        this.bookService.save(saveBook);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveBook, BookResponse.class));
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookSaveRequest bookSaveRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        Book saveBook = this.modelMapperService.forRequest().map(bookSaveRequest, Book.class);
        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        saveBook.setPublisher(publisher);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        saveBook.setAuthor(author);
        this.bookService.save(saveBook);
        return ResultHelper.success(this.modelMapperService.forResponse().map(saveBook, BookResponse.class));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")int id){
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id")int id){
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(book, BookResponse.class));
    }

}
