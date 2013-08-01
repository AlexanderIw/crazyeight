package gameProject;

public class CPU extends Player{


	public CPU(String x){
		name = x;
	}

	//changes made here
	@Override
	public Card playCard(Card x){
		//check for null exception
		if(x==null)return null;
		
		playerHand.removeCard(x);
		return x;
	}

	//change made here
	public void drawCard(Card x){
		//check for null exception
		if(x==null)return;
		playerHand.addCard(x);

	}


	public boolean isHuman(){
		return false;
	}
}