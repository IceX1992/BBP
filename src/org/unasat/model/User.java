
package org.unasat.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name="USER_TABLE")
public class User implements Serializable {
    
    @Id @GeneratedValue
    private Long id;

    @Email
    private String email;
    
    @NotNull
    private String userId;
    
    @NotNull
	@Size(min = 2, max = 14)
    private String password;

    public User() {
    }

    
    public User(String email, String userId, String password) {
        this.email = email;
        this.userId = userId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        
}
