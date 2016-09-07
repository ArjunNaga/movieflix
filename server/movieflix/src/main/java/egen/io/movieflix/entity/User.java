package egen.io.movieflix.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;



@Entity 
@Table
@NamedQueries({
	@NamedQuery(name = "User.findAll", query = "SELECT u from User u ORDER BY u.userEmail"),
	@NamedQuery(name = "User.findByEmail", query = "SELECT u from User u where u.userEmail=:puserEmail")
})
public class User {

	@Id
	@Column(name = "USER_ID")
	private String id;
	 
	@Column(unique = true, nullable = false)
	private String userEmail;
	private String userAccountType;
     
	
	public User(){
	id = UUID.randomUUID().toString();
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserAccountType() {
		return userAccountType;
	}
	public void setUserAccountType(String userAccountType) {
		this.userAccountType = userAccountType;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userEmail=" + userEmail + ", userAccountType=" + userAccountType + "]";
	}
}
