package gameProject;

public abstract class Player {
	
	protected String name;
	protected Hand playerHand = new Hand();
	
	protected Card playCard(Card x){
		return x;
	}

	
	protected void drawCard(Card x){
		
	}

	
	protected boolean isHuman(){
		return true;
	}
	
	// modification 1 for player
	public Hand getPlayerHand(){return playerHand;} 
	
	public String getName(){return name;}

}