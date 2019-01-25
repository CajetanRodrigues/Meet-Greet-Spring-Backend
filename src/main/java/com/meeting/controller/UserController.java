package com.meeting.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.meeting.model.EmailOtp;
import com.meeting.model.User;
import com.meeting.repository.EmailOtpRepository;
import com.meeting.repository.UserRepository;
import com.meeting.controller.MailController;

/*All api's related to User in this controller */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("rest")
public class UserController {
	int  code;
	
	@Autowired
	MailController m;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EmailOtpRepository emailOtpRepository;
	
	Map<Integer,Integer> map = new HashMap<>();
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user) {
		//go to repo(User) and use save method to insert in DB
		System.out.println("User just saved is : " + userRepository.save(user));
		return userRepository.save(user);
	}
	@PostMapping("/checkcredentials")
	public User checkUser( @RequestBody User u) {
		//go to repo(User) and use save method to insert in DB
		List list = new ArrayList<User>();
		User user = new User();
		list = userRepository.findAll();
		System.out.println(list);
		Iterator<User> i = list.iterator();
		System.out.println(list);
		while(i.hasNext()) {
			 user = i.next();
			if(user.getEmail().equals(u.getEmail()) && user.getPassword().equals(u.getPassword())){
				return user;
				}
			
		}
		return null;
		
	}
	
	@GetMapping("/users")
	public List<User> getUsers() {
		//go to repo and fetch all users 
		return userRepository.findAll();
	}
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") int id) {
		//go to repo and fetch user based on id.
		return userRepository.getOne(id);
	}
	@GetMapping("/getId/{email}")
	public  User getIdEmail( String email) {
		
		//go to repo and fetch user based on id.
//		System.out.print((int) userRepository.getIdFromEmail(email));
		User u =  userRepository.getIdFromEmail(email);
		System.out.println("The user ID fetched from database : " + u.getId());
		return u;
	}
	
	@PutMapping("/user/{id}")
	public User updateUser(@RequestBody User user,@PathVariable("id") int id) {
		//go to repo and fetch existing user based on id
		User u = userRepository.getOne(id);//existing User
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		//save u in repo
		return userRepository.save(u);
		
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") int id) {
		//go to repo and delete based on id
		userRepository.deleteById(id);
	}
	
	
	@PostMapping("/user/generateOtp")
	public void  generateOtp(@RequestBody User user){
		//go to repo and fetch user based on userId
		String email = user.getEmail();
	
		m.sendEmail(email,user);
		//send code to email 
		
	}
	
	@PostMapping("/user/verifyOtp/{code}")
	public EmailOtp checkOtp(@PathVariable("code") 
	int code,@RequestBody User user){
		EmailOtp result = this.emailOtpRepository.checkEmailOtp(user.getEmail(), Integer.toString(code));
		if(result != null) {
			System.out.println(result.getEmail() + result.getOtp());
			return result;
		}
		else {
			System.out.println("false");
			return null;
		}
		
		
		
		

	}

}











//
//for(Map.Entry<Integer,Integer> e : map.entrySet()){
//	if(e.getKey()== user.getId()){
//		if(e.getValue()==code){
//			map.remove(user.getId());
//			return true;
//		}
//	}
//}
//return false;



