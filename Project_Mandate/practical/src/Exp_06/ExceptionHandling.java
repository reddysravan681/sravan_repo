package Exp_06;
import java.io.*;
class MyCheckedException extends Exception{
	MyCheckedException(String msg){super(msg);}
}



public class ExceptionHandling {
	static void mayThrowChecked(boolean throwIt) throws MyCheckedException{
		if(throwIt) throw new MyCheckedException("Checked exception thrown!");
	}
static int divide(int a,int b) {
	return a/b;
}
	public static void main(String[]args) {
		System.out.println("2462634");
		try {
			System.out.println("Divide 10 by 2 ="+ divide(10,2));
			System.out.println("Divide 10 by 0 =(next)");
			System.out.println("Result="+ divide(10,0));
		}catch(ArithmeticException ae) {
			System.out.println("Caught ArithmeticException:"+ae.getMessage());
		}catch(RuntimeException re) {
			System.out.println("Other Runtime Exception:"+re);	
		}finally {
			System.out.println("Finally always runs");
		}
		try {
			mayThrowChecked(true);
		}catch (MyCheckedException e) {
			System.out.println("Caught Custom checked Exception:"+e.getMessage());
		}
		try(BufferedReader br=new BufferedReader(new StringReader("line1\nline2"))){
			System.out.println("First line:"+br.readLine());
		}catch (IOException ioe) {
			System.out.println("IO error:"+ioe.getMessage());
		}
		System.out.println("Program finished");
		

	}
}