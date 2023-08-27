package com.nt.service;

import java.util.List;

import com.nt.entity.Hotel;

public interface IHotelService {

	String registerHotel(Hotel hotel);
	Hotel updateHotel(Hotel hotel);
	List<Hotel> fetchAllHotel();
	Hotel fetchOneHotel(Long id);
	void deleteHotelById(Long id);

}