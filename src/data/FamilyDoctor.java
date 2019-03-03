/**
 * 
 */
package data;


/**
 * @author adriana
 *
 */
public class FamilyDoctor extends Doctor {
	private String 	  address;
	private String 	  website;
	private String    phoneNumber;
	
	/**
	 * @param name
	 * @param address
	 * @param website
	 * @param phoneNumber
	 */
	public FamilyDoctor(String fullname, String address, String website, String phoneNumber) {
		super(fullname);
		this.address = address;
		this.website = website;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @param address
	 * @param website
	 * @param phoneNumber
	 */
	public FamilyDoctor(String fullname, String address, String phoneNumber) {
		super(fullname);
		this.address 	 = address;
		this.website 	 = "";
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
