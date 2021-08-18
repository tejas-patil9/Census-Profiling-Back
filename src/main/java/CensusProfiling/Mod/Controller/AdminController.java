package CensusProfiling.Mod.Controller;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import CensusProfiling.Mod.exception.NoAccessException;
import CensusProfiling.Mod.model.User;
import CensusProfiling.Mod.model.UserFamilyMember;
import CensusProfiling.Mod.secure.SecureService;
import CensusProfiling.Mod.services.AdminService;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.Authorization;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
	
public static final Logger LOG = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private AdminService service ;
												
	@Autowired
	SecureService appUserService;
	
	/// Admin can add Users
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		LOG.info("addUser");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.addUser(user);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	////Get All Users
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		LOG.info("AllUsers");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.findAllUsers();
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	@GetMapping("/getAllFamilyMembers")
	public List<UserFamilyMember> getAllFamilyMembers() {
		LOG.info("AllUsers");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.getAllFamilyMembers();
		}
		return null;
	}
	
	
	///////Get Users by First Name
	@GetMapping("/getUsersByfirstname/{firstName}")
	public List<User> getByFirstName(@PathVariable("firstName") String firstName) {
		LOG.info("getByFirstName");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.findUsersByFirstName(firstName);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	/////Get Users by User ID
	@GetMapping("/getUserById/{id}")
	public User getUserById(@PathVariable("id") int id) {
		LOG.info("getByFirstName");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.getUserById(id);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	////Get Users by Last Name
	@GetMapping("/getUsersByLastName/{lastName}")
	public List<User> getByLastName(@PathVariable("lastName") String lastName) {
		LOG.info("getBylastName");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.findUsersByLastName(lastName);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}

	@GetMapping("/getUsersByAge/{age}")
	public List<User> getUsersByAge(@PathVariable("age") int age) {
		LOG.info("getByFirstName");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.getUsersByAge(age);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	//Get user by Email
	@GetMapping("/getUserByEmail/{email}")
	public User getByEmail(@PathVariable("email") String email) {
		LOG.info("getByEmail");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			return service.findUserByEmail(email);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	
	@GetMapping("/getUsersByCity/{City}")
	public List<User> getUserByCity(@PathVariable("City") String city) {
		LOG.info("getByEmail");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.findUsersByCity(city);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	
	///Admin can get All users by their Gender
	@GetMapping("/getByGender/{gender}")
	public List<User> getByGender(@PathVariable("gender") String gender) {
		LOG.info("getByEmail");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
		return service.findUsersByGender(gender);
		}
		else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	@GetMapping("/getUsersByAgeGroup")
	public List<User> getTargetedUsers(){
		LOG.info("Targeted Age Gorup");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			return service.findUsersByAgeGroup();
		}else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	@GetMapping("/getMembersByAgeGroup")
	public List<UserFamilyMember> getTargetedMembers(){
		LOG.info("Targeted Age Gorup");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			return service.findMembersByAgeGroup();
		}else {
			throw new NoAccessException("You dont have access");
		}
	}
	
	////Admin Can Delete User by ID
	@Transactional
	@DeleteMapping("/deleteUserById/{id}")
	public void deleteUsersById(@PathVariable("id") int id) {
		LOG.info("Delte User by ID");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			service.deleteUserById(id);
		}
	}
	
	@Transactional
	@DeleteMapping("/deleteUserByEmail/{email}")
	public void deleteUserById(@PathVariable("email") String email) {
		LOG.info("Delte User by First Name");
		if (appUserService.loginStatus().getRole().toString().equals("ADMIN")) {
			service.deleteUserByEmail(email);
		}
	}
	

	
}
