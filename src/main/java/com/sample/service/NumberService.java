package com.sample.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.model.Numbers;
import com.sample.repo.NumberRepository;



@Service
public class NumberService {
	
	
	@Autowired
	private NumberRepository numberRepo;
	
		public void addNumbers(Numbers numbers) {
			
			String number = numbers.getNumber();
			//String withoutspaces = str.replaceAll("\\s",""); // we can use this singleline code also

			String withoutspaces = " ";
			for (int i = 0; i < number.length(); i++) {
		        if (number.charAt(i) != ' ')
		            withoutspaces += number.charAt(i);
		    } 
			
			String regex = "\\d+";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(withoutspaces);
	        long MAX = 0;
	        while(m.find())
	        {
	            long num = Integer.parseInt(m.group());
	            if(num > MAX)
	                MAX = num;
	        }
	        
	        numbers.setNumber(String.valueOf(MAX));
	  
		/*	
			  String number = numbers.getNumber();
			  long max= Stream.of(number.replaceAll("^\\D+","").split("\\D+"))
			  .mapToLong(Long::parseLong) .max().orElse(-1); 
			  numbers.setNumber(String.valueOf(max));
			  System.out.println("LargeNumber======"+numbers.getNumber());
		*/	  
			  
		numberRepo.save(numbers);
	       
	}
	
	
	public Numbers getNumberById(Long numberId) {
		
		Numbers numbers = numberRepo.findById(numberId).get();
		return numbers;
	}

}
