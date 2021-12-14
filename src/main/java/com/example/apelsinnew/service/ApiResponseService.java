package com.example.apelsinnew.service;

import com.example.apelsinnew.payload.ApiResponse;
import com.example.apelsinnew.utils.MessageConst;
import org.springframework.stereotype.Service;

@Service
public class ApiResponseService {
    public ApiResponse saveResponse() {
        return new ApiResponse(MessageConst.SAVED_MESSAGE, true);
    }

    public ApiResponse getResponse(Object object) {
        return new ApiResponse(MessageConst.GET_SUCCESS, true, object);
    }

    public ApiResponse tryErrorResponse() {
        return new ApiResponse(MessageConst.TRY_ERROR_MESSAGE, false);
    }

    public ApiResponse notEnoughErrorResponse() {
        return new ApiResponse(MessageConst.ENOUGH_ERROR_MESSAGE, false);
    }

    public ApiResponse failedResponse() {return new ApiResponse(MessageConst.FAILED,false);}

    public ApiResponse getSuccessResponse(Object object) {return new ApiResponse("SUCCESS", object);}
}
