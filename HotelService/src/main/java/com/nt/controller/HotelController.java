package com.nt.controller;

import java.util.List;

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

import com.nt.entity.Hotel;
import com.nt.service.IHotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {
	@Autowired
	private IHotelService hotelService;

	@PostMapping("/register")
	public ResponseEntity<String> createHotel(@RequestBody Hotel hotel) {
		String msgHotel = hotelService.registerHotel(hotel);
		return new ResponseEntity<>(msgHotel, HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Hotel> updateHotel(@RequestBody Hotel hotel) {
		Hotel updatedHotel = hotelService.updateHotel(hotel);
		return new ResponseEntity<>(updatedHotel, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Hotel> getOneHotel(@PathVariable Long id) {
		Hotel existHotel = hotelService.fetchOneHotel(id);
		return new ResponseEntity<>(existHotel, HttpStatus.OK);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Hotel>> getAllHotel() {
		List<Hotel> hotelList = hotelService.fetchAllHotel();
		return new ResponseEntity<>(hotelList, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletehotel(@PathVariable Long id) {
		hotelService.deleteHotelById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
