/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Singleton Creational Design Patterns
 *
 * Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.
 * 
 * Ensure that a class has just a single instance. 
 * Provide a global access point to that instance.
 * 
 * Implementation:
 * 		Make the default constructor private, to prevent other objects from using the new operator with the Singleton class.
 * 		Create a static creation method that acts as a constructor.
 * 			Under the hood, this method calls the private constructor to create an object and saves it in a static field.
 * 			All following calls to this method return the cached object.
 *
 */


/**
 * Main Class for the Singleton Creational Design Patterns
 */
class Singleton {
	private static Singleton instance = null;

	private String str = "";

	private Singleton() {}

	public static Singleton getSingleton() {
		if (null == instance) {
			instance = new Singleton();
		}
		return instance;
	}

	public String getStr() {
		return str;
	}

	public void setStr(final String str) {
		this.str = str;
	}

}

class Main {
	public static void main(final String[] args) {
		Singleton intance1;
		Singleton intance2 = Singleton.getSingleton();

		intance2.setStr("Hello, World!");

		intance1 = Singleton.getSingleton();

		System.out.println(intance1.getStr());		// Output: Hola

	}

}

