/**
 * 
 */
package data;


/**
 * @author adriana
 *
 */
public class Person implements PersonInterface {
	private String firstname  = "";
	private String middlename = "";
	private String lastname   = "";
	private String domain     = "";
	private String occupation = "";
	private String address    = "";

	public Person(String fullName) {
		int idxFirst = fullName.indexOf(' ');
		int idxLast  = fullName.lastIndexOf(' ');
		
		if (idxFirst == -1) {
			firstname = fullName;
		} else {
			firstname = fullName.substring(0, idxFirst);
			if (idxLast == idxFirst) {
				lastname = fullName.substring(idxFirst + 1);
			} else {
				middlename = fullName.substring(idxFirst + 1, idxLast);
				lastname   = fullName.substring(idxLast  + 1);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Person [firstname=" + firstname + ", middlename=" + middlename + ", lastname=" + lastname + ", domain="
				+ domain + ", occupation=" + occupation + ", address=" + address + "]";
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * @param domain the domain to set
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
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
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}
	/**
	 * @param firstname the firstname to set
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	/**
	 * @return the surname
	 */
	public String getLastname() {
		return lastname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void getLastname(String surname) {
		this.lastname = surname;
	}
}
