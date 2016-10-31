package com.app.adsbooklet.model;

public class SellerBuyerInfo 
{
	private String you_are;
	private String name;
	private String email;
	private Long mobileno;
	
	private String address;
	private String city;
	private int stateid;
	private int districtid;
	private int pincode;
	private int mobile_adv_id;
	
	public Long getMobileno() {
		return mobileno;
	}
	public void setMobileno(Long mobileno) {
		this.mobileno = mobileno;
	}
	
	public String getYou_are() {
		return you_are;
	}
	public void setYou_are(String you_are) {
		this.you_are = you_are;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	public int getDistrictid() {
		return districtid;
	}
	public void setDistrictid(int districtid) {
		this.districtid = districtid;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public int getMobile_adv_id() {
		return mobile_adv_id;
	}
	public void setMobile_adv_id(int mobile_adv_id) {
		this.mobile_adv_id = mobile_adv_id;
	}
	
}
