package net.guides.springboot2.springboot2jpacrudexample.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "canteen")
public class Canteen {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private int Id;
	private String  place;
	private String  companyName;
	private long phoneNo;
	private String emailId;
	private String date;
	private String shopName;
	
	 
	public Canteen(int id, String place, String companyName, long phoneNo, String emailId, String date,
			String shopName) {
		super();
		Id = id;
		this.place = place;
		this.companyName = companyName;
		this.phoneNo = phoneNo;
		this.emailId = emailId;
		this.date = date;
		this.shopName = shopName;
	}


	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}

	public String getPlace() {
		return place;
	}


	public void setPlace(String place) {
		this.place = place;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public long getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	public String getEmailId() {
		return emailId;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getShopName() {
		return shopName;
	}


	public void setShopName(String shopName) {
		this.shopName = shopName;
	}


	public Canteen() {
		super();
	}

	@Override
	public String toString() {
		return "Canteen [  place=" + place + ", companyName=" + companyName + ", phoneNo=" +phoneNo + ", emailId=" + emailId+ " ,"
				+ "date=" + date + ", shopName=" +shopName
				+ "]";	
	}
	
	}
	

