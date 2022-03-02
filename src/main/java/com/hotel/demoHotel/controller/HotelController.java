package com.hotel.demoHotel.controller;

import java.util.List;
import java.util.Optional;

import com.hotel.demoHotel.model.Hotel;
import com.hotel.demoHotel.model.MessageResponse;
import com.hotel.demoHotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/hoteldemo")
public class HotelController {
	
	  @Autowired
      HotelService hotelService;
	  
	@GetMapping("/all")
    public ResponseEntity<List<Hotel>> getAllHotelDetails () {
        System.out.println("ye chal raja jao");
        List<Hotel> hotelList = hotelService.getAllHotel();
        return new ResponseEntity<>(hotelList, HttpStatus.OK);
    }
	
	@GetMapping("/find/{id}")
    public ResponseEntity<Hotel> getHotelDetailsById (@PathVariable("id") Integer id) {
        Hotel hotel = hotelService.getHotelDetailsById(id);
        return new ResponseEntity<>(hotel, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addHotel(@RequestBody Hotel hotel) {
        MessageResponse newEmployee = hotelService.createHotel(hotel);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public Optional<Hotel> updateHotel(@PathVariable Integer id, @RequestBody Hotel hotel) {
        return hotelService.updateHotel(id, hotel);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteHotel(@PathVariable("id") Integer id) {
    	hotelService.deleteHotel(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
