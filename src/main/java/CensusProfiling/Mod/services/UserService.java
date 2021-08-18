package CensusProfiling.Mod.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import CensusProfiling.Mod.exception.DuplicateRecordException;
import CensusProfiling.Mod.exception.RecordNotFoundException;
import CensusProfiling.Mod.model.User;
import CensusProfiling.Mod.model.UserFamilyMember;
import CensusProfiling.Mod.repository.UserFamilyMemberRepository;
import CensusProfiling.Mod.repository.UserRepository;


@Service
public class UserService {
	public static final Logger LOG = LoggerFactory.getLogger(UserFamilyMember.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserFamilyMemberRepository memRepository;

	/// User Register
	public User userRegister(User user) {
		User optionalUser = userRepository.findUserByEmail(user.getEmail());
		if (optionalUser == null) {
			return userRepository.save(user);
		} else {
			throw new DuplicateRecordException("User Already exists");
		}
	}

	/// Add Family Member
	public UserFamilyMember addMember(UserFamilyMember member) {
		return memRepository.save(member);
	}

	@Transactional
	public void deleteMember(String name) {
		List<UserFamilyMember> famMem = memRepository.findBymemFirstName(name);
		if (famMem == null) {
			throw new RecordNotFoundException("Record with given first name Not Found");
		} else {
			memRepository.deleteBymemFirstName(name);
		}
	}

	public void deleteMemberById(int mem_id) {
		UserFamilyMember famMem = memRepository.getById(mem_id);
		if (famMem == null) {
			throw new RecordNotFoundException("Record with given ID Not Found");
		} else {
			memRepository.deleteById(mem_id);
		}
	}

	public List<UserFamilyMember> findMemberByFirstName(String firstName) {

		List<UserFamilyMember> famMem = memRepository.findBymemFirstName(firstName);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("Record with given Name Does Not Exists");
		} else {
			return famMem;
		}
	}

	public UserFamilyMember findMemberById(int id) {
		UserFamilyMember famMem = memRepository.findBymemId(id);
		if (famMem == null) {
			throw new RecordNotFoundException("Record with passed ID does not exists in Database");
		} else {
			return famMem;
		}
	}

	// Get All family Members of Single User
	public List<UserFamilyMember> findFamilyMembersByUserId(int user_uid) {
		List<UserFamilyMember> famMem = memRepository.findByUser_uid(user_uid);
		if (famMem.isEmpty()) {
			throw new RecordNotFoundException("No Record found");
		} else {
			return famMem;
		}
	}

	// Update User Profile
	public User updateUserProfile(User user) {
		if (user == null) {
			throw new RecordNotFoundException("Record to be updated Not Found");
		} else {
			return userRepository.save(user);
		}
	}

	// Update Family Member Details
	public UserFamilyMember updateMemberInfo(UserFamilyMember member) {
		return memRepository.save(member);
	}


}
