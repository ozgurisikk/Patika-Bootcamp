package com.library.library.core.utilities;

import com.library.library.core.result.Result;
import com.library.library.core.result.ResultData;
import com.library.library.dto.response.CursorResponse;
import org.springframework.data.domain.Page;

import static com.library.library.core.utilities.Msg.CREATED;
import static com.library.library.core.utilities.Msg.OK;


public class ResultHelper {
    public static <T> ResultData<T> created(T data){
        return new ResultData<>(true, CREATED, "201", data);
    }
    public static <T> ResultData<T> success(T data){
        return new ResultData<>(true, OK, "200", data);
    }
    public static Result ok(){
        return new Result(true, OK, "200");
    }
    public static Result notFoundError(String msg){
        return new Result(false, msg, "404");
    }
    public static <T> ResultData<CursorResponse<T>> cursor(Page<T> pageData){
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());
        return ResultHelper.success(cursor);
    }
}
