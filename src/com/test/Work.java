package com.test;

import org.junit.Test;

public class Work {
	public int count = 0;
	
	@Test
	public void entry(){
		int num = 200;
		Work test = new Work();
		for(int index = 10;index < num;index+=10){
			test.countValue(index);
		}
	}
	
	//小于n的所有偶数
	public void countValue(int number){
		for(int index = 2;index < number;index = index + 2){
			analysis(index);
		}
		System.out.println(count);
		count = 0;
	}
	
	//一个偶数能否为两个素数之和
	public boolean analysis(int number){
		for(int index = 1;index < number;index++){
			int secNum = number - index;
			count++;
			if(isPrime(index) && isPrime(secNum)){
				return true;
			}
		}
		return false;
	}
	
	//一个数是不是素数
	public boolean isPrime(int number){
			for(int index = 2;index < Math.sqrt(number);index++){
				if(number % index == 0){
					return false;
				}
			}
		return true;
	}
}
