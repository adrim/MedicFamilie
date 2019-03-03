/**
 * 
 */
package data;

import java.util.ArrayList;

/**
 * @author adriana
 *
 */
public class Doctor extends Person {

	/**
	 * 
	 */
	private ArrayList<String> specializations;
	
	/**
	 * @param name Doctor full name
	 */
	public Doctor(String fullName) {
		super(fullName);
	}

	/**
	 * @param specializations
	 */
	public Doctor(String fullName, ArrayList<String> specializations) {
		super(fullName);
		this.specializations = specializations;
	}

	/**
	 * @return the specializations
	 */
	public ArrayList<String> getSpecializations() {
		return specializations;
	}

	/**
	 * @param specializations the specializations to set
	 */
	public void setSpecializations(ArrayList<String> specializations) {
		this.specializations = specializations;
	}
	
	public void addSpecialization(String specialization) {
		if (this.specializations == null) {
			this.specializations = new ArrayList<String>();
		}
		this.specializations.add(specialization);
	}

}
