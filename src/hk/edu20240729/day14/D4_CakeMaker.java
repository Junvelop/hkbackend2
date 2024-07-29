package hk.edu20240729.day14;

public class D4_CakeMaker implements Runnable{
	
	private D4_CakePlate cake;
	
	public D4_CakeMaker() {
		// TODO Auto-generated constructor stub
	}
	
	
	public D4_CakeMaker(D4_CakePlate cake) {
		// TODO Auto-generated constructor stub
		this.cake = cake;
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 30; i++) {
			cake.makeBread();
		
	}
	
	
	
	

}}
