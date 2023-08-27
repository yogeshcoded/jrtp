package com.nt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Hotel;
import com.nt.exception.HotelNotFoundException;
import com.nt.repository.IHotelRepository;
import com.nt.service.IHotelService;

@Service("hotelService")
public class HotelBookingServiceImpl implements IHotelService {
	@Autowired
	private IHotelRepository hotelRepo;

	@Override
	public String registerHotel(Hotel hotel) {
		return "Hotel register sucess id "+ hotelRepo.save(hotel).getId();
	}

	@Override
	public Hotel updateHotel(Hotel hotel) {
		return hotelRepo.findById(hotel.getId())
				                      .orElseThrow(HotelNotFoundException::new);
	}

	@Override
	public List<Hotel> fetchAllHotel() {
		return hotelRepo.findAll();
	}

	@Override
	public Hotel fetchOneHotel(Long id) {
		return hotelRepo.findById(id)
				                      .orElseThrow(HotelNotFoundException::new);
				                      
	}

	@Override
	public void deleteHotelById(Long id) {
		hotelRepo.findById(id)
                          .ifPresentOrElse(cust -> hotelRepo.deleteById(id),() -> { throw new IllegalArgumentException(); } );
		
	}

}
