package com.capgemini.java_dev.framework.hibernate_jpa.one_to_one.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
public class Student implements Serializable{
	@Id
	private Integer id;
	private String name;
	private String emailId;
	private Long contactNumber;
	@OneToOne(cascade = CascadeType.ALL)
	private Project project;
	public Student() {
	}
	public Student(Integer id, String name, String emailId, Long contactNumber, Project project) {
		this.id = id;
		this.name = name;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.project = project;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public int hashCode() {
		return Objects.hash(contactNumber, emailId, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(contactNumber, other.contactNumber) && Objects.equals(emailId, other.emailId)
				&& Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", emailId=" + emailId + ", contactNumber=" + contactNumber
				+ "]";
	}
	
}
