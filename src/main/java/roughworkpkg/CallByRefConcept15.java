package roughworkpkg;

public class CallByRefConcept15 {
	
	String name;
	int age;
	
	public static void getInfo(CallByRefConcept15 t1) {
		
	//	CallByRefConcept15 t1 = new CallByRefConcept15();//instead add param to the method - the classname
		
		System.out.println(t1.name);
		System.out.println(t1.age);
		
	}
	
	

	public static void main(String[] args) {
		CallByRefConcept15 obj = new CallByRefConcept15();
		obj.name = "Prateek";
		obj.age = 30;
		
		getInfo(obj);
		
		CallByRefConcept15 app = new CallByRefConcept15();
		getInfo(app);

	}

}
