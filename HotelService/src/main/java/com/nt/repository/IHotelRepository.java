package com.nt.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Hotel;

public interface IHotelRepository extends JpaRepository<Hotel, Long> {

}
