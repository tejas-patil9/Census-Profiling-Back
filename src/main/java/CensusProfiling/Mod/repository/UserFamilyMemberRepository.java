package CensusProfiling.Mod.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import CensusProfiling.Mod.model.UserFamilyMember;



@Repository
public interface UserFamilyMemberRepository extends JpaRepository<UserFamilyMember, Integer> {
	// public abstract List<User> findByfirstName(String firstName);
	public abstract Long deleteBymemFirstName(String name);

	public abstract UserFamilyMember findBymemId(int mid);

	public abstract List<UserFamilyMember> findBymemFirstName(String memFirstName);

	public abstract List<UserFamilyMember> findByrelationWithUser(String relationWithUser);

	public abstract List<UserFamilyMember> findByageOfMember(int ageOfMember);

	public abstract List<UserFamilyMember> findByUser_uid(int user_uid);

	@Query("select u from FamilyMembers u where u.ageOfMember between 10 and 20")
	public abstract List<UserFamilyMember> findTargetMembers();
	
}
