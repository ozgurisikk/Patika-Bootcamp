package com.library.library.api;

import com.library.library.business.abstracts.AuthorService;
import com.library.library.core.config.modelMapper.ModelMapperService;
import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.core.utilities.ResultHelper;
import com.library.library.dto.request.author.AuthorSaveRequest;
import com.library.library.dto.request.author.AuthorUpdateRequest;
import com.library.library.dto.response.CursorResponse;
import com.library.library.dto.response.author.AuthorResponse;
import com.library.library.entities.Author;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final ModelMapperService modelMapperService;

    public AuthorController(AuthorService authorService, ModelMapperService modelMapperService) {
        this.authorService = authorService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest){
        Author saveAuthor = this.modelMapperService.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(saveAuthor);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveAuthor, AuthorResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id")int id){
        Author author = this.authorService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(author, AuthorResponse.class));
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Author> authorPage = this.authorService.cursor(page,pageSize);
        Page<AuthorResponse> authorResponsePage = authorPage.
                map(author -> this.modelMapperService.forResponse().map(author, AuthorResponse.class));

        return ResultHelper.cursor(authorResponsePage);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest categoryUpdateRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        Author updateAuthor = this.modelMapperService.forRequest().map(categoryUpdateRequest, Author.class);
        this.authorService.update(updateAuthor);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateAuthor, AuthorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")int id){
        this.authorService.delete(id);
        return ResultHelper.ok();
    }

}
