package gameProject;
import javax.swing.*;
public class CUI {
	private static void startGame(){
		int value=0;
		String suit="temp", tempS, tempTemp="not pass";
		Game gp= new Game();	//game play(GP)
		Deck theDeck = new Deck();
		Card playedCard=null;// current played card
		Player prevPlayer= null;// hold the previous player turn
		
		System.out.println("Welcome to the Game of Crazy Eights");
		
		do{
		gp.setTotalNumberPlayer(Integer.parseInt(JOptionPane.showInputDialog("Please enter the total number of players:")));
		}while (gp.getTotalNumberPlayer()>4||gp.getTotalNumberPlayer()<2);
		
		do{
		gp.setHumanPlayers(Integer.parseInt(JOptionPane.showInputDialog("Please enter the total number of human players:")));
		}while (gp.getHumanPlayers()<1||gp.getHumanPlayers()>gp.getTotalNumberPlayer());

		//set all Human players name
		for(int i=1;i<=gp.getHumanPlayers();i++){
			System.out.println("Please enter player "+i+"'s name:");
			gp.setPlayer(i);
		}
		//player are created and they have they hand
		switch(gp.getTotalNumberPlayer()){
		case 2:
			gp.createPlayers(gp.getTotalNumberPlayer(), gp.getHumanPlayers(), gp.getName1(), gp.getName2());
			theDeck.deal(gp.getPlayer1(), gp.getPlayer2());

			break;
		case 3:
			gp.createPlayers(gp.getTotalNumberPlayer(), gp.getHumanPlayers(), gp.getName1(), gp.getName2(), gp.getName3());
			theDeck.deal(gp.getPlayer1(), gp.getPlayer2(),gp.getPlayer3());
			break;
		case 4:
			gp.createPlayers(gp.getTotalNumberPlayer(), gp.getHumanPlayers(), gp.getName1(), gp.getName2(), gp.getName3(),gp.getName4());
			theDeck.deal(gp.getPlayer1(), gp.getPlayer2(), gp.getPlayer3(),gp.getPlayer4());
			break;
		}//end of case switch
		
		//create discard pile and the start of the first discarded of the deck 
		gp.setDiscardPile(theDeck.pop());
		
		//The first player is always first 
		gp.setCurPlayer(gp.getPlayer1());	
		
		//Game play start here
		while(!(gp.getCurPlayer().getPlayerHand().isEmpty())){

			System.out.println("["+gp.getCurPlayer().getName()+"]: It's your turn to play a card.");
			System.out.println("["+gp.getCurPlayer().getName()+"]'s Hand: "+ gp.getCurPlayer().getPlayerHand().getList()+".");
			System.out.println("The top card on the discard pile is "+ gp.getDiscardPile()+".");
			
			prevPlayer=gp.getCurPlayer();		// hold current player
			
			if(gp.getCurPlayer().isHuman()){
				do{
					value=	Integer.parseInt(JOptionPane.showInputDialog(gp.getCurPlayer().getName()+", please enter a value: '0' to pass turn, 1 for Ace, 2 for 2,..., 11 for Jack, 12 for Queen, 13 for King:"));
					suit= (JOptionPane.showInputDialog(gp.getCurPlayer().getName()+", please enter a suit: 'p' to pass turn, c for Clubs, h for Hearts, s for Spades, d for Diamonds, ")).toUpperCase();
					
					if(value==0 && suit.equalsIgnoreCase("p")){
						gp.getCurPlayer().drawCard(theDeck.pop());
						tempTemp= "pass";
						break;
					}
					playedCard= new Card(value,suit);
					
				}while((!gp.getCurPlayer().getPlayerHand().isInHand(playedCard)) || (!gp.isValid(playedCard, gp.getDiscardPile())));
				
				if(!tempTemp.equalsIgnoreCase("pass"))
					gp.setDiscardPile(gp.getCurPlayer().playCard(playedCard));//play CARD
			}
			else if( !gp.getCurPlayer().isHuman()){
				
				Card temp=gp.getCurPlayer().getPlayerHand().isValidInHand((gp.getDiscardPile()));
				
				if(temp==null){
					System.out.println("No valid move, please draw a card or pass your turn , "+ gp.getCurPlayer().name);
					gp.getCurPlayer().drawCard(theDeck.pop());
					tempTemp="pass";
				}
				else{
					gp.setDiscardPile(gp.getCurPlayer().playCard(temp));//play CARD
				}
			}//end of else-if cpu move
			else{
				//add new type of player later
			}
			
			
			if(!tempTemp.equalsIgnoreCase("pass")){
				System.out.println("["+gp.getCurPlayer().getName()+"]: You played "+gp.getDiscardPile()+". Smart move.");

				//Special cases: draw 2 and crazy eights
				if(gp.getDiscardPile().getValue()==2){
					System.out.println("["+gp.getCurPlayer().getName()+"] has played a 2. The next player will draw 2 cards.");
					gp.nextPlayer();		//switch to next player turn
	
					gp.getCurPlayer().drawCard(theDeck.pop());
					gp.getCurPlayer().drawCard(theDeck.pop());
					System.out.println("["+gp.getCurPlayer().getName()+"] has drawn 2 cards.");
		
					gp.setCurPlayer(prevPlayer);//back to the current player
				}
				
				if(gp.getDiscardPile().getValue()==8){
					
					System.out.println(gp.getCurPlayer().getName()+", you played a wild card.");
					
					if(gp.getCurPlayer().isHuman()){
						tempS=JOptionPane.showInputDialog("Would you like to change the suit of the card? yes or no");
						if(tempS.equalsIgnoreCase("yes")){
							tempS=JOptionPane.showInputDialog("Please enter the suit c for club, h for hearts, s for spades, d for diomonds");
							gp.getDiscardPile().setSuit(tempS);
						}

						
					}
					//else cpu
					
					else{
						System.out.println("The CPU has modified the suit of the last card played.");
						gp.getDiscardPile().setSuit(gp.getCurPlayer().getPlayerHand().searchForSuit());
							
					}
	
				}
			}//end of temp
			
			System.out.println("["+gp.getCurPlayer().getName()+"] Hand update: "+ gp.getCurPlayer().getPlayerHand().getList());
			System.out.println("Updated discard pile: "+ gp.getDiscardPile());
					
			//check to see if the game has ended
			if((gp.getCurPlayer().getPlayerHand().isEmpty())){
				System.out.println("Congratulations "+ gp.getCurPlayer().getName() + "!. You have won!");
				System.exit(0);
			}
			
			System.out.println("Please review your turn, the next player's turn will be starting soon...");
			tempS= JOptionPane.showInputDialog("Next player, please hit enter to take your turn.");
			for(int i =0;i<25;i++){System.out.println("\n");}

			tempTemp="not pass";
			gp.nextPlayer();//switch to next player turn
		}//End of main game loop
	}
	
	public static void main(String []args){
		startGame();
	}

}