package com.rakuten.threads;

public class PrimeCounter implements Runnable{

	long start,end,count;
	
	public PrimeCounter(long start, long end) {
		super();
		this.start = start;
		this.end = end;
	}



	@Override
	public void run() {
		for(long i = start; i <= end ; i++) {
			if(isPrime(i)) {
				count++;
			}
		}
		
	}

	private boolean isPrime(long num) {
		if(num <= 2) {
			return true;
		}
		for(long i=2;i<num;i++) {
			if((num % i) == 0) {
				return false;
			}
		}
		return true;
	}


	public long getCount() {
		return count;
	}
	
	

}
