package com.buskart.search.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.buskart.search.exception.SystemException;
import com.buskart.search.responseVo.ApiResponse;
import com.buskart.search.responseVo.BuskartBookingResponseVO;
import com.buskart.search.service.BuskartBookingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/buskart/search")
@Slf4j
public class BuskartBookingSearchRestController {
    
    @Autowired
    private  BuskartBookingService buskartBookingService;
    

    @GetMapping("/{bookingId}")
    public ResponseEntity<ApiResponse<BuskartBookingResponseVO>> getBookingByBookingId(@PathVariable String bookingId) throws SystemException {
        try {
            BuskartBookingResponseVO bookingVO = buskartBookingService.getBookingByBookingId(bookingId);
            ApiResponse<BuskartBookingResponseVO> response = new ApiResponse<>(HttpStatus.OK.value(), "Booking found", bookingVO);
            return ResponseEntity.ok(response);
                } catch (Exception e) {
            log.error("the error for this booking id",bookingId);
        }
        return null;
    }
}
