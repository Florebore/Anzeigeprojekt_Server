/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flopewsserver.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Florian
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByID", query = "SELECT u FROM User u WHERE u.userID = :userID")
    , @NamedQuery(name = "User.findByFirstname", query = "SELECT u FROM User u WHERE u.firstname = :firstname")
    , @NamedQuery(name = "User.findByLastname", query = "SELECT u FROM User u WHERE u.lastname = :lastname")
    , @NamedQuery(name = "User.findBypassword", query = "SELECT u FROM User u WHERE u.password = :password")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")})


//SqlResultsetmapping makes it possible to convert ResultSets to Entities or Pojos https://stackoverflow.com/questions/13012584/jpa-how-to-convert-a-native-query-result-set-to-pojo-class-collection
//https://docs.jboss.org/hibernate/orm/5.2/userguide/html_single/Hibernate_User_Guide.html#sql


@NamedNativeQuery(
    name ="find_person_username_and_ident_dto",
    query =
        "SELECT " +
        "   id,"     +
        "   Username, " +
        "   password "     +
        "FROM database_anzeige.user ",
    resultSetMapping = "UserResult"
)

@SqlResultSetMapping(name="UserResult", classes = {
@ConstructorResult(targetClass = User.class, 
  columns = {
      @ColumnResult(name="id"),
      @ColumnResult(name="username"), 
      @ColumnResult(name="password")})})



public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer userID;
    @Size(max = 45)
    @Column(name = "Firstname")
    private String firstname;
    @Size(max = 45)
    @Column(name = "Lastname")
    private String lastname;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "Username")
    private String username;
    


    public User() {
    }
    
    public User(Integer userID,String username, String ident) {
        
        this.userID = userID;
        this.username = username;
        this.password = password;
    }

    public User(Integer userID) {
        this.userID = userID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getIdent() {
        return password;
    }

    public void setIdent(String ident) {
        this.password = ident;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.flopewsserver.entities.User[ userID=" + userID + " username = "+ username+" ident= "+ password+" Firstname=" + firstname + " Lastname = "+ lastname+"  ]";
    }
    
}
