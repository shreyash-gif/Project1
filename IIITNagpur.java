public class IIITNagpur { 
	public static void main(String[] args) ;
          }

	 class Engineering 
	 { 
		String college = "IIIT Nagpur"; 
		int year = 4;
		 double cgpa = 8.0; 
		 void show()
		  { 
			System.out.println("College: " + college);
			 System.out.println("Year: " + year);
			  System.out.println("CGPA: " + cgpa);
			 }
			 } 
			 class Student extends Engineering 
			 { int rollNo = 12;
				 void show() 
				 { 
					super.show(); 
					System.out.println("Roll No: " + rollNo);
				 } 
				} 
				 class Result extends Student 
				 { 
					char grade = 'A'; 
					void show()
					 { super.show();
						 System.out.println("Grade: " + grade);
						 } 
						} 
						class Main
						 { 
							public static void main(String[] args)
							 {
								 Result obj = new Result(); obj.show();
								 }
							} 
						
					
