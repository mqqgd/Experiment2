import java.util.Random;

public class GetRandomDigit {
	private Random random;
	public GetRandomDigit(){
		random=new Random();
	}
	int oprator(){
		return random.nextInt(4)+1;
	}
	int Time(){
		return random.nextInt(3)+3;
	}
	int randomDigit(){
		return random.nextInt(100);
	}
	int probabilityQuestion(){
		return random.nextInt(200);
	}
	int BracketsIndex(int time){
		return random.nextInt(time-2);
	}
}
