package CensusProfiling.Mod.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import CensusProfiling.Mod.exception.DuplicateRecordException;
import CensusProfiling.Mod.exception.RecordNotFoundException;
import CensusProfiling.Mod.model.User;
import CensusProfiling.Mod.model.UserFamilyMember;
import CensusProfiling.Mod.repository.UserFamilyMemberRepository;
import CensusProfiling.Mod.repository.UserRepository;


@Service
public class AdminService {
	public static final Logger LOG = LoggerFactory.getLogger(UserFamilyMember.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFamilyMemberRepository userFamilyMemberRepository;

	/// Add User
	public User addUser(User user) {
		User optionalUser = userRepository.findUserByEmail(user.getEmail());
		if (optionalUser == null) {
			return userRepository.save(user);
		} else {
			throw new DuplicateRecordException("User Already exists");
		}
	}

	/// Find users by First Name
	public List<User> findUsersByFirstName(String firstName) {
		LOG.info("findUserByFirstName");

		List<User> user = userRepository.findUserByFirstName(firstName);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record with given first name Not Found");
		} else {
			return user;
		}

	}

	/// Find users by Last Name
	public List<User> findUsersByLastName(String lastName) {

		LOG.info("findUserByLastName");
		List<User> user = userRepository.findUserByLastName(lastName);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record Not Found of given last name");
		} else {
			return user;
		}

	}

	/// Get Users By Gender
	public List<User> findUsersByGender(String gender) {
		LOG.info("findUserByGender");
		List<User> user = userRepository.findUserByGender(gender);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("Record does not exists of given gender type");
		} else {
			return user;
		}

	}

	/// Get users of Age 10 - Age 20
	public List<User> findUsersByAgeGroup() {
		List<User> user = userRepository.findTargetUsers();
		if (user.isEmpty()) {
			throw new RecordNotFoundException("No Users Available of this age group");
		} else {
			return user;
		}
	}

	/// Get members of Age 10 - Age 20
	public List<UserFamilyMember> findMembersByAgeGroup() {
		List<UserFamilyMember> user = userFamilyMemberRepository.findTargetMembers();
		if (user.isEmpty()) {
			throw new RecordNotFoundException("No Users Available of this age group");
		} else {
			return user;
		}
	}

	/// Find User by Email
	public User findUserByEmail(String email) {
		LOG.info("findUserByEmail");
		User user = userRepository.findUserByEmail(email);
		if (user == null) {
			throw new RecordNotFoundException("User With given Email does not Exist");
		} else {
			return user;
		}
	}

	/// Get All Users
	public List<User> findAllUsers() {
		List<User> user = userRepository.findAll();
		if (user.isEmpty()) {
			throw new RecordNotFoundException("No user exists in Database");
		} else {
			return user;
		}
	}

	/// Get All Family Members added by all Users
	public List<UserFamilyMember> getAllFamilyMembers() {
		List<UserFamilyMember> members = userFamilyMemberRepository.findAll();
		if (members.isEmpty()) {
			throw new RecordNotFoundException("No record exists in Database");
		} else {
			return members;
		}
	}

	/// Delete User by ID
	public void deleteUserById(int id) {
		User user = userRepository.findByuid(id);
		if (user == null) {
			throw new RecordNotFoundException("User you are trying to delete does not exists");
		} else {
			userRepository.deleteAllByuid(id);
		}
	}

	/// Delete User by Email
	public void deleteUserByEmail(String email) {
		User user = userRepository.findUserByEmail(email);
		if (user == null) {
			throw new RecordNotFoundException("User you are trying to delete does not exists");
		} else {
			userRepository.deleteUserByemail(email);
		}
	}

	// Get User by ID
	public User getUserById(int id) {
		User user = userRepository.findByuid(id);
		if (user == null) {
			throw new RecordNotFoundException("User Does not Exists");
		} else {
			return user;
		}
	}

	/// Get Users by City
	public List<User> findUsersByCity(String city) {
		List<User> user = userRepository.findUserBycity(city);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("NO User available from given city");
		} else {
			return user;
		}
	}

	/// Get Users by Age
	public List<User> getUsersByAge(int age) {
		List<User> user = userRepository.findUserByage(age);
		if (user.isEmpty()) {
			throw new RecordNotFoundException("NO User available of given Age");
		} else {
			return user;
		}
	}
}
