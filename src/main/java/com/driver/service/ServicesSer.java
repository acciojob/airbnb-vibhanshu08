package com.driver.service;
import java.util.UUID; 
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Repository;
//import org.springframework.web.bind.annotation.RequestBody;

import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.model.User;
import com.driver.repository.RepositoryRepo;

@Repository
public class ServicesSer {
	@Autowired
	RepositoryRepo rp;
	
	
//	
	
	
	public String addHotel(Hotel hotel){
		if(hotel.getHotelName().length()==0 && rp.hote.containsKey(hotel.getHotelName())==true) {
			return "FAILURE";
		}
		 rp.hote.put(hotel.getHotelName(),hotel);
		 return "SUCCESS";
	 }
	 public Integer addUser(User user) {
		 rp.use.put(user.getaadharCardNo(),user);
		 return user.getaadharCardNo();
	 }
//	
	 public String getHotelWithMostFacilities(){
		 int m=0;
		 
		 String cur="";
//		 Hotel any=null;
		 for(Hotel a:rp.hote.values()) {
//			 any=a;
			 if(m<a.getFacilities().size()) {
				 
			  cur=a.getHotelName();
			  m=a.getFacilities().size();
			 }
			 else if(m==a.getFacilities().size() && m!=0) {
				int j= cur.compareTo(a.getHotelName());
				if(j<0) {
				   cur=a.getHotelName();
				}
			 }
		 }
		 return cur;
	 }
//	 
	 public int bookARoom(Booking booking){
		 UUID uuid = UUID.randomUUID();  
		 booking.setBookingId(uuid.toString());
		 
		 int room=booking.getNoOfRooms();
		 String name=booking.getHotelName();
		 
		 Hotel cur=rp.hote.get(name);
		 int price=cur.getPricePerNight();
		 int avail=cur.getAvailableRooms();
		 if(avail==0) {
			 return -1;
		 }
		 else {
			 booking.setAmountToBePaid(room*price);
			 return booking.getAmountToBePaid();
		 }
		 
	     //The booking object coming from postman will have all the attributes except bookingId and amountToBePaid;
	        
	        //save the booking Entity and keep the bookingId as a primary key
	        //Calculate the total amount paid by the person based on no. of rooms booked and price of the room per night.
	        //If there arent enough rooms available in the hotel that we are trying to book return -1 
	        //in other case return total 
	 }
   
	 

}
