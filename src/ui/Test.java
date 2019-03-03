/**
 * 
 */
package ui;

import java.io.IOException;

import connection.Connection;

class Base {
public static void display() {
System.out.println("Static or class method from Base");
}
public void print() {
System.out.println("Non-static or instance method from Base");
}
}
class Derived extends Base {
	public static void display() {
System.out.println("Static or class method from Derived");
}
public void print() {
System.out.println("Non-static or instance method from Derived");
}}


/**
 * @author adriana
 *
 */
public class Test {

	private static void testWhatev() {
		Base obj1= new Derived();
		obj1.display();
		obj1.print();
	}
	public static void testConnection() {
		Connection conn = new Connection();
		
		try {
			conn.getCountyMFLink();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println(" Connection could not be established. Please try again later.");
			e.printStackTrace();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//testWhatev();
		testConnection();
	}

}
