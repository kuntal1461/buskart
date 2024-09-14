
 package com.buskart.search.responseVo;

 import lombok.AllArgsConstructor;
 import lombok.Builder;
 import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
 
 import java.time.LocalDate;
 
@Getter
@Builder
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
 public class BuskartBookingResponseVO {
    
    private  Long id;
    private  String bookingId;
    private String userId;
    private String customerName;
    private LocalDate bookingDate;
    private String status;
    private String amount;
    private String destination;
    private String source;
    private String seatNumber;
    private String busType;
   
}