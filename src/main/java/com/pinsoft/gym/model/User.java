package com.pinsoft.gym.model;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pinsoft.gym.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","meal"})
@Entity
@Builder
@Table(name="user",schema = "public")
public class User implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -651208478837681514L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
	
	@Column(name="username")
    private String username;
	
	@Column(name="password")
	private String password;
	
    @Column(name="firstname")
    private String firstName;
    
    @Column(name="lastname")
    private String lastName;
    
    @Column(name="address")
    private String address;
    
    @Column(name="phonenumber")
    private String phone;

    @OneToOne(mappedBy = "user")
    private UserInfo userInfo;
    
    @OneToMany(mappedBy = "user")
    private List<Meal> meal;
    
    @Enumerated(EnumType.STRING)
    private Role role;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of(new SimpleGrantedAuthority(role.name()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public User(String username, String password, String firstName, String lastName) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;

	}
}
