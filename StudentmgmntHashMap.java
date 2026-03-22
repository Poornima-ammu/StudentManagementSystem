package StudentMngmentSystem;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class StudentmgmntHashMap {
	//**************************SHOW MENU***************
	public void showMenu() {
		System.out.println("1.ADD Student");
		System.out.println("2.View Student");
		System.out.println("3.Delete Student");
		System.out.println("4.Search Student");
		System.out.println("5.Update Student");
		System.out.println("6.Exit");
		
	}
	public boolean handleChoice(int choice, Scanner sc,HashMap<Integer,Student>map) {
		switch(choice) {
		case 1:
				addStudent(map,sc);
				break;
		case 2:
				viewStudent(map);
				break;
		case 3:
				deleteStudent(map,sc);
				break;
		case 4:
				searchStudent(map,sc);
				break;
		case 5:
				updateStudent(map,sc);
				break;
		case 6:
				System.out.println("Exiting.........");
				return false; 
		default:
				System.out.println("Invalid Choice");
		
		}
		return true;
		
	}
	//***********************ADD STUDENT*************
	public void addStudent(HashMap<Integer,Student>map, Scanner sc) {
		System.out.println("Enter Student id: ");
		int id=sc.nextInt();
		sc.nextLine();
		if(map.containsKey(id)) {
			System.out.println("Id already Exisits");
			return ;
		}
		
		System.out.println("Enter Student name: ");
		String name=sc.nextLine();
		
		System.out.println("Enter Student age: ");
		int age=sc.nextInt();
		
		
		
		map.put(id, new Student(id,name,age) );
		System.out.println("Student deatils added successfully");
			
		
	}
	
	// *****************VIEW STUDENT*********************
	public void viewStudent(HashMap<Integer,Student>map) {
		
		/* for(  Map.Entry<Integer,Student>entry:map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
			
		}*/
		
		if(map.isEmpty()) {
			System.out.println("Map is Empty");
			return;
		}
		else {
			for(Student s:map.values()) {
				System.out.println(s);
			}
		}
		
		
	}
	// ******************DELETE STUDENT******************
	public void deleteStudent(HashMap<Integer,Student>map,Scanner sc) {
		System.out.println("Enter id to delete:");
		int id=sc.nextInt();
		if(map.containsKey(id)) {
			map.remove(id);
			System.out.println("Deleted sucessfully");
		}
		else {
			System.out.println("Student data not found");
		}
	}
	//********************SEARCH STUDENT************************
	public void searchStudent(HashMap<Integer,Student>map,Scanner sc) {
		System.out.println("Enter student id to search: ");
		int id=sc.nextInt();
		if(map.containsKey(id)) {
			System.out.println(map.get(id));
			}
	
	else {
		System.out.println("Student not found");
	}
	}
	//************************UPDATE STUDENT*********************
	public void updateStudent(HashMap<Integer,Student>map,Scanner sc) {
		System.out.println("Enter  Student id to update: ");
	int id=sc.nextInt();sc.nextLine();
	if(map.containsKey(id)) {
		Student s=map.get(id);// to set name and age
		System.out.println("Enter new name: ");
		String newName=sc.nextLine();
		System.out.println("Enter new age ");
		int newAge=sc.nextInt();
		s.setName(newName);
		s.setAge(newAge);
		System.out.println("Updated Sucessfully");
	}
	else {
		System.out.println("Student not found");
	}
	}
	public static void main(String args[]) {
		HashMap<Integer,Student>map=new HashMap<>();
		Scanner sc=new Scanner(System.in);
		StudentmgmntHashMap  obj=new StudentmgmntHashMap ();
		
		while(true) {
			obj.showMenu();
			int choice=sc.nextInt();
			boolean continueProgram=obj.handleChoice(choice,sc,map);
			if(!continueProgram)
				break;
					
		}	
		
	}

}
