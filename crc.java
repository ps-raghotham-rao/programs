import java.util.*;
import java.net.*;
import java.io.*;
import java.math.*;
import java.security.*;

public class CRCT{
	public static void main(String args[]) throws Exception {
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		String message,generator;

		System.out.println("Enter message bits");
		message = sc.readLine();

		int messageLength = message.length();

		System.out.println("Enter generator bits");
		generator = sc.readLine();

		int generatorLength = generator.length();
		int data[] = new int[messageLength+generatorLength-1];
		int divisor[] = new int[generatorLength];
		int totalLength = messageLength+generatorLength-1;

		for(int i = 0;i<messageLength;i++){
			data[i] = Integer.parseInt(message.charAt(i)+"");
		}
		

		for(int i = 0;i<generatorLength;i++){
			divisor[i] = Integer.parseInt(generator.charAt(i)+"");
		}


		//CRCT Calc
		for(int i = 0;i<messageLength;i++)
			if (data[i] == 1)
				for(int j = 0;j<generatorLength;j++)				
					data[i+j]=data[i+j]^divisor[j];
		
		System.out.println("Here is the checksum code");
		for(int i = 0;i<messageLength;i++){
			data[i]=Integer.parseInt(message.charAt(i)+"");
		}
		for(int i = 0;i<totalLength;i++){
			System.out.print(data[i]);
		}
		System.out.println();
		System.out.println();
		
		System.out.println("Enter the checksum code");
		String checksumcode1 = sc.readLine();
		
		System.out.println("Enter generator bits");
		String generator1 = sc.readLine();

		int generatora[] = new int[generator1.length()];
		int totalLength1 = checksumcode1.length()+generator.length()-1;
		
		int checksumcode[] = new int[totalLength1];


		for(int i = 0;i<checksumcode1.length();i++){
			checksumcode[i] = Integer.parseInt(checksumcode1.charAt(i)+""); 
		}

		for(int i = 0;i<generator1.length();i++){
			generatora[i] = Integer.parseInt(generator1.charAt(i)+""); 
		}
		
		for(int i = 0;i<checksumcode1.length();i++)
			if (checksumcode[i] == 1)
				for(int j = 0;j<generator1.length();j++)
					checksumcode[i+j]=checksumcode[i+j]^generatora[j];
		
		for(int i =0;i<totalLength1;i++){
			System.out.print(checksumcode[i]);
		}


		Boolean value = true;
		for(int i = 0;i<totalLength1;i++){
			if (checksumcode[i] == 1){
				value=false;
				break;
			}
		}
		if (value == true)
			System.out.println("Valid");
		else
			System.out.println("Not Valid");		
	}
}
