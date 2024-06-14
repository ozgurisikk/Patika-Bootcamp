package com.library.library.api;

import com.library.library.business.abstracts.BorrowBookService;
import com.library.library.core.config.modelMapper.ModelMapperService;
import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.core.utilities.ResultHelper;
import com.library.library.dto.request.borrowBook.BorrowBookSaveRequest;
import com.library.library.dto.request.borrowBook.BorrowBookUpdateRequest;
import com.library.library.dto.response.CursorResponse;
import com.library.library.dto.response.borrowBook.BorrowBookResponse;
import com.library.library.entities.BorrowBook;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/borrowbooks")
public class BorrowBookController {
    private final BorrowBookService borrowBookService;
    private final ModelMapperService modelMapperService;

    public BorrowBookController(BorrowBookService borrowBookService, ModelMapperService modelMapperService) {
        this.borrowBookService = borrowBookService;
        this.modelMapperService = modelMapperService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BorrowBookResponse> save(@Valid @RequestBody BorrowBookSaveRequest borrowBookSaveRequest){
        BorrowBook saveBorrowBook = this.modelMapperService.forRequest().map(borrowBookSaveRequest, BorrowBook.class);
        this.borrowBookService.save(saveBorrowBook);
        return ResultHelper.created(this.modelMapperService.forResponse().map(saveBorrowBook, BorrowBookResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BorrowBookResponse> get(@PathVariable("id")int id){
        BorrowBook borrowBook = this.borrowBookService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(borrowBook, BorrowBookResponse.class));
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BorrowBookResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<BorrowBook> borrowBookPagePage = this.borrowBookService.cursor(page,pageSize);
        Page<BorrowBookResponse> borrowBookResponsePage = borrowBookPagePage.
                map(borrowBook -> this.modelMapperService.forResponse().map(borrowBook, BorrowBookResponse.class));

        return ResultHelper.cursor(borrowBookResponsePage);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BorrowBookResponse> update(@Valid @RequestBody BorrowBookUpdateRequest borrowBookUpdateRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        BorrowBook updateBorrowBook = this.modelMapperService.forRequest().map(borrowBookUpdateRequest, BorrowBook.class);
        this.borrowBookService.update(updateBorrowBook);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updateBorrowBook, BorrowBookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")int id){
        this.borrowBookService.delete(id);
        return ResultHelper.ok();
    }
}
