package gameProject;
import javax.swing.*;
public class Game {
	
	private static int totalPlayers;
	private static int humanPlayers;
	private static Card discardPile;
	
	private Player currentPlayer;
	private static String suit8;
	
	private Player p1;
	private Player p2;
	private Player p3;
	private Player p4;
	
	private String name1;
	private String name2;
	private String name3;
	private String name4;
	
	//** change number 2, setter
	public void setTotalNumberPlayer(int numPlayers){totalPlayers=numPlayers;}
	public void setHumanPlayers(int humPlayers){humanPlayers= humPlayers;}
	public static void setDiscardPile(Card playedCard){discardPile=playedCard;}
	public void setCurPlayer(Player p){currentPlayer= p;}
	
	
	//** change number 3, getter 
	public String getName1(){return name1;}
	public String getName2(){return name2;}
	public String getName3(){return name3;}
	public String getName4(){return name4;}
	public int getTotalNumberPlayer(){return totalPlayers;}
	public int getHumanPlayers(){return humanPlayers;}
	public int getCPUPlayers(){return (totalPlayers-humanPlayers);}
	public Player getPlayer1(){return p1;}
	public Player getPlayer2(){return p2;}
	public Player getPlayer3(){return p3;}
	public Player getPlayer4(){return p4;}
	public Card getDiscardPile(){return discardPile;}
	public Player getCurPlayer(){return currentPlayer;}



	

	//** change number 4, modified by Lonique ^_^
	public void setPlayer(int i){		
		switch(i){
		case 1:name1=JOptionPane.showInputDialog("Input first player name:");
		break;
		
		case 2:name2=JOptionPane.showInputDialog("Input second player name:");
		break;
		
		case 3:name3=JOptionPane.showInputDialog("Input third player name:");
		break;
		
		case 4:name4=JOptionPane.showInputDialog("Input fourth player name:");
		break;
		}
	}
	
	public void createPlayers(int tp, int hp, String n1, String n2){
		if(hp==1){
			p1 = new Human(n1);
			p2 = new CPU("CPU1");
		}
		else {
			p1 = new Human(n1);
			p2 = new Human(n2);
		}
	}
	public void createPlayers(int tp, int hp, String n1, String n2, String n3){
		if(hp==1){
			p1 = new Human(n1);
			p2 = new CPU("CPU1");
			p3 = new CPU("CPU2");
		}
		else if (hp==2){
			p1 = new Human(n1);
			p2 = new Human(n2);
			p3 = new CPU("CPU1");
		}
		else{
			p1 = new Human(n1);
			p2 = new Human(n2);
			p3 = new Human(n3);
		}
	}
	public void createPlayers(int tp, int hp, String n1, String n2, String n3, String n4){
		if(hp==1){
			p1 = new Human(n1);
			p2 = new CPU("CPU1");
			p3 = new CPU("CPU2");
			p4 = new CPU("CPU3");
		}
		else if (hp==2){
			p1 = new Human(n1);
			p2 = new Human(n2);
			p3 = new CPU("CPU1");
			p4 = new CPU("CPU2");
		}
		else if (hp==3){
			p1 = new Human(n1);
			p2 = new Human(n2);
			p3 = new Human(n3);
			p4 = new CPU("CPU1");
		}
		else{
			p1 = new Human(n1);
			p2 = new Human(n2);
			p3 = new Human(n3);
			p4 = new Human(n4);
		}
	}
	
	// modified by nique ^_^~ second// gil you cause me great pain >.< but i fix it. cant use == on string objects
	//also forgot to add crazy eight exception
	public boolean isValid(Card x, Card y){
		
		if((x.getSuit().equalsIgnoreCase(y.getSuit())))return true;
		
		else if((x.getValue()==y.getValue())||x.getValue()==8)return true;
		
		else{ 
			System.out.println("Invalid Card, Please try again.");
			return false;
		}
	}
	
	public void nextPlayer(){
		
		if(totalPlayers==2){
			if(humanPlayers==1){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else{
					p2=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==2){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else{
					p2=currentPlayer;
					currentPlayer=p1;
				}
			}
		}
		else if (totalPlayers==3){
			if(humanPlayers==1){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name=="CPU1"){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else{
					p3=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==2){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name==name2){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else{
					p3=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==3){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name==name2){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else{
					p3=currentPlayer;
					currentPlayer=p1;
				}
			}
		}
		else if (totalPlayers==4){
			if(humanPlayers==1){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name=="CPU1"){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else if(currentPlayer.name=="CPU2"){
					p3=currentPlayer;
					currentPlayer=p4;
				}
				else{
					p4=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==2){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name==name2){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else if(currentPlayer.name=="CPU2"){
					p3=currentPlayer;
					currentPlayer=p4;
				}
				else{
					p4=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==3){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name==name2){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else if(currentPlayer.name==name3){
					p3=currentPlayer;
					currentPlayer=p4;
				}
				else{
					p4=currentPlayer;
					currentPlayer=p1;
				}
			}
			else if(humanPlayers==4){
				if(currentPlayer.name==name1){
					p1=currentPlayer;
					currentPlayer=p2;
				}
				else if(currentPlayer.name==name2){
					p2=currentPlayer;
					currentPlayer=p3;
				}
				else if(currentPlayer.name==name3){
					p3=currentPlayer;
					currentPlayer=p4;
				}
				else{
					p4=currentPlayer;
					currentPlayer=p1;
				}
			}
			
		}
	
		
	}
}