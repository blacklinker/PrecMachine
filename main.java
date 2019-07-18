
public class main{
	
	
	static public void main (String [] args) throws InterruptedException {
		boolean [][] precs = {
				{false, true, false, false, false,false },
				{false, false, true, true, true,false },
				{false, false, false, false, false,false },
				{false, false, false, false, true,true },
				{false, false, false, false, false,false },
				{false, false, true, false, false,false }
				
				/*{false, true, true, false, true,false, false},
				{false, false, false, false, false, true ,false},
				{false, false, false, true, false, true ,false},
				{false, false, false, false, false,false ,true},
				{false, false, false, true, false,false ,false},
				{false, false, false, false, false,false ,true},
				{false, false, false, false, false,false ,false}*/
				
		};
		
		Runnable job0,job1,job2,job3,job4,job5,job6;
		
		Runnable [] jobs = { 
				job0 = () -> {
				System.out.println("Task 0: ");},
				job1 = () -> {
				System.out.println("Task 1: ");},
				job2 = () -> {
				System.out.println("Task 2: ");},
				job3 = () -> {
				System.out.println("Task 3: ");},
				job4 = () -> {
				System.out.println("Task 4: ");},
				job5 = () -> {
				System.out.println("Task 5: ");},
				/*job6 = () -> {
				System.out.println("Task 6: ");	}*/
		};
		
		PrecMachine buildHouse = new PrecMachine (precs, jobs);
		buildHouse.run();
	
	
}}
