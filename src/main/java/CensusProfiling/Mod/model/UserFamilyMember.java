package CensusProfiling.Mod.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
//import java.util.*;

@Entity(name = "FamilyMembers")
@Table(name = "FamilyMembers")
public class UserFamilyMember {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memId;

	@Column(nullable = false)
	private String memFirstName;

	@Column
	private String memLastName;

	@Column(nullable = false)
	private String memGender;

	@Column(nullable = false)
	private String relationWithUser;

	@Column(nullable = false)
	private int ageOfMember;

	@Column(nullable = false)
	private String education;

	@JsonBackReference
	@ManyToOne						
	private User user;

	public UserFamilyMember() {
		super();
	}

	public UserFamilyMember(int memId, String memFirstName, String memLastName, String memGender,
			String relationWithUser, int ageOfMember, User user) {
		super();
		this.memId = memId;
		this.memFirstName = memFirstName;
		this.memLastName = memLastName;
		this.memGender = memGender;
		this.relationWithUser = relationWithUser;
		this.ageOfMember = ageOfMember;
		this.user = user;
	}

	public int getMemId() {
		return memId;
	}

	public void setMemId(int memId) {
		this.memId = memId;
	}

	public String getMemFirstName() {
		return memFirstName;
	}

	public void setMemFirstName(String memFirstName) {
		this.memFirstName = memFirstName;
	}

	public String getMemLastName() {
		return memLastName;
	}

	public void setMemLastName(String memLastName) {
		this.memLastName = memLastName;
	}

	public String getMemGender() {
		return memGender;
	}

	public void setMemGender(String memGender) {
		this.memGender = memGender;
	}

	public int getAgeOfMember() {
		return ageOfMember;
	}

	public void setAgeOfMember(int ageOfMember) {
		this.ageOfMember = ageOfMember;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRelationWithMember() {
		return relationWithUser;
	}

	public void setRelationWithMember(String relationWithMember) {
		this.relationWithUser = relationWithMember;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

}
