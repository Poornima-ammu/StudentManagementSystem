package StudentMngmentSystem;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		ArrayList<Student>students=new ArrayList<>();
		while(true) {
			System.out.println("1. Add Student");
			System.out.println("2. View Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Search Student");
			System.out.println("5. Update Student");
			System.out.println("6. Exit\n");
			int choice =sc.nextInt();
			switch(choice) {
			case 1:
				//fetching details from user
				System.out.println("Enter ID: ");
				int id=sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter Name: ");
				String name=sc.nextLine();
				
				System.out.println("Enter Age: ");
				int age=sc.nextInt();
				
				//checking if id already exisits
				boolean exists=false;
				for(Student s:students) {
					if(s.getId()==id) {
						exists=true;
						break;
					}
				}
				if(exists) {
					System.out.println("Id already Exists!!!");
				}
				else {
				//adding details to student collection
				students.add(new Student(id,name,age));
				System.out.println("Student details added successfully");
				}
				break;
			case 2:
					if(students.isEmpty()) {
						System.out.println("No Students Found");
					}
					else {
						for(Student s:students) {
							System.out.println(s);
						}
					}
					break;
			case 3:
						System.out.println("Enter id to Delete: ");
						int dId=sc.nextInt();
						boolean deleted=false;
						for(int i=0;i<students.size();i++) {
							if(students.get(i).getId()==dId) {
								students.remove(i);
								System.out.println("Student with id :"+dId+" deleted Sucessfully" );
								deleted=true;
								break;
							}	
						}
						if(!deleted){
							System.out.println("Student not found");
						}
					    break;
			case 4:		System.out.println("Enter id to Search: ");
						int searchId=sc.nextInt();
						boolean found=false;
						for(int i=0;i<students.size();i++) {
							if(students.get(i).getId()==searchId) {
								found=true;
								System.out.println(students.get(i));
								break;
							}
						}
							if(!found) {
								System.out.println("Student Not Found");
							}
						
						break;
			case 5:
						System.out.println("Enter id to Update details: ");
						int uId=sc.nextInt();
						sc.nextLine();
						boolean updated=false;
						for(Student s:students ) {
							if(s.getId()==uId) {
								System.out.println("Enter new name: ");
								String newname=sc.nextLine();
								
								System.out.println("Enter new age: ");
								int newage=sc.nextInt();
								
								s.setName(newname);
								s.setAge(newage);
								updated=true;
								System.out.println("Student Details Updated Sucessfully");
							break;
							}
						}
						if(!updated) {
							System.out.println("Student not found");
						}
						break;
			case 6:
						System.out.println("Exiting...........");
						return;
			}
		}
	}

}
