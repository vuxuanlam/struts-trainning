package actionform;

import java.io.Serializable;

public class Address implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String address1;
	private String address2;
	private String state;
	private String zip;
	private String city;

	public void setAddress1(String address) {
		this.address1 = address;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress2(String address) {
		this.address2 = address;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return this.state;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getZip() {
		return this.zip;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

}