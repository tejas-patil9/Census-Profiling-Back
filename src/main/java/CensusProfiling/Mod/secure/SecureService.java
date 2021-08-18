package CensusProfiling.Mod.secure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import CensusProfiling.Mod.model.User;
import CensusProfiling.Mod.repository.UserRepository;


@Service
public class SecureService {
	private final static Logger log = LoggerFactory.getLogger(User.class);
	
	@Autowired
	private UserRepository repository;
	
	private User currentUser;
	
	public User login(User user) {
		log.info("Current User");
		currentUser = repository.findUserByEmail(user.getEmail());
		return currentUser;
	}
	
	public User register(User user) {
		log.info("Register");
		return repository.save(user);
	}
	
	public String logout() {
		log.info("Logout");
		currentUser = null;
		return "You are logged Out";
	}
	
	public User loginStatus() {
		log.info("loginStatusService");
		return currentUser;
	}
}
