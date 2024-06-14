package com.library.library.api;

import com.library.library.business.abstracts.PublisherService;
import com.library.library.core.config.modelMapper.ModelMapperService;
import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.core.utilities.ResultHelper;
import com.library.library.dto.request.publisher.PublisherSaveRequest;
import com.library.library.dto.request.publisher.PublisherUpdateRequest;
import com.library.library.dto.response.CursorResponse;
import com.library.library.dto.response.publisher.PublisherResponse;
import com.library.library.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;
    private final ModelMapperService modelMapperService;

    public PublisherController(PublisherService publisherService, ModelMapperService modelMapperService) {
        this.publisherService = publisherService;
        this.modelMapperService = modelMapperService;
    }
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest){
        Publisher savePublisher = this.modelMapperService.forRequest().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(savePublisher);
        return ResultHelper.created(this.modelMapperService.forResponse().map(savePublisher, PublisherResponse.class));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id")int id){
        Publisher publisher = this.publisherService.get(id);
        return ResultHelper.success(this.modelMapperService.forResponse().map(publisher, PublisherResponse.class));
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false,defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ){
        Page<Publisher> publisherPage = this.publisherService.cursor(page,pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage.
                map(publisher -> this.modelMapperService.forResponse().map(publisher, PublisherResponse.class));

        return ResultHelper.cursor(publisherResponsePage);
    }
    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest ){ // burda valid category anatasyonlarini uyandirip gecerli bir obje mi diye kontrol ediyor
        Publisher updatePublisher = this.modelMapperService.forRequest().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(updatePublisher);
        return ResultHelper.success(this.modelMapperService.forResponse().map(updatePublisher, PublisherResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id")int id){
        this.publisherService.delete(id);
        return ResultHelper.ok();
    }
}
