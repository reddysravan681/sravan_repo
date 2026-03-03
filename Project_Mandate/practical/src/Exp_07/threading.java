package Exp_07;
//generate random numbers. if even, display square; else, display cube.
import java.util.Random;//"Random" from "util" If you had a "*", it means "everything from util"
class NumberGenerator extends Thread{
	Random rand=new Random();
	int number;
	boolean runStatus=true;
	@Override
	public void run() {
		while (runStatus) {
			number=rand.nextInt(100); //generate 0-99
			System.out.println("\n[Generator] Number generated: "+number);
			
			if (number%2==0) {
				new EvenThread(number).start();
			}
			else {
				new OddThread(number).start();
			}
			try {
				Thread.sleep(1000);//wait 1 second
			}
			catch (InterruptedException e) {
				System.out.println("Generator stopped");
				
					}
				}
		
			}
}
class EvenThread extends Thread{
		int num;
		EvenThread(int num){
			this.num=num;
		}
	@Override
	public void run() {
		System.out.println("[EvenThread] Square of "+num+" = "+(num*num));
	}
}
class OddThread extends Thread{
		int num;
		OddThread(int num){
			this.num=num;
		}
	@Override
	public void run() {
		System.out.println("[OddThread] Cube of "+num+" = "+(num*num*num));
	}
	
	
}
class multithreading_exp7 {
	public static void main(String []args) {
		NumberGenerator generator = new NumberGenerator();
		generator.start();
	}
}

