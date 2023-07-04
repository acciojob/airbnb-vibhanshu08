package com.driver.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

//import org.springframework.web.bind.annotation.RequestBody;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;



@Repository
public class RepositoryRepo {

	public HashMap<String,Booking>bk=new HashMap<>();
	public HashMap<Integer,User>use=new HashMap<>();
	public HashMap<String,Hotel>hote=new HashMap<>();
	
//	public String addHotel(Hotel hotel){
//		if(hotel.getHotelName().length()==0 && hote.containsKey(hotel.getHotelName())==true) {
//			return "FAILURE";
//		}
//		 hote.put(hotel.getHotelName(),hotel);
//		 return "SUCCESS";
//	 }
//	 public Integer addUser(User user) {
//		 use.put(user.getaadharCardNo(),user);
//		 return user.getaadharCardNo();
//	 }
}
