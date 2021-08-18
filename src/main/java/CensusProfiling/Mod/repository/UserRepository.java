package CensusProfiling.Mod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import CensusProfiling.Mod.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	public abstract List<User> findUserByFirstName(String firstName);

	public abstract List<User> findUserByLastName(String lastName);

	public abstract List<User> findUserByGender(String gender);

	public abstract User findUserByEmail(String email);

	public abstract List<User> findUserBycity(String city);

	public abstract User findByuid(int uid);

	public abstract Object deleteAllByuid(int uid);

	public abstract List<User> findUserByage(int age);

	public abstract Object deleteUserByemail(String email);
	
	@Query("select u from Users u where u.age between 10 and 20")
	public abstract List<User> findTargetUsers();
}
