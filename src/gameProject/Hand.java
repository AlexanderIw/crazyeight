package gameProject;
import java.util.LinkedList;

public class Hand {

    private LinkedList<Card> list = new LinkedList<Card>();

	/**
	 * Returns true if the linked list is empty. False otherwise.
	 * @return
	 */
	public boolean isEmpty() {
		return getList().isEmpty();
	}

	/**
	 * This method will add a card to the end of the list.
	 * 
	 * @param x The card to be added.
	 * 
	 */
	public void addCard(Card x) {
		getList().add(x);
	}
	
	/**
	 * Iterates through the list and removes the selected card.
	 * @param x The card to be removed.
	 */
	// modified and fix by LOnique. damn u gil ^_^~
	public void removeCard(Card x){
		for (int i=0;i<getList().size();i++){
			if((getList().get(i).getSuit().equalsIgnoreCase(x.getSuit()))&& getList().get(i).getValue()==x.getValue()){
				getList().remove(i);
			}
		}
	}
	//for user to check if he played invalid move
	public boolean isInHand(Card x){
		for (int i=0;i<getList().size();i++){
			if((getList().get(i).getSuit().equalsIgnoreCase(x.getSuit()))&& getList().get(i).getValue()==x.getValue()){
				return true;
			}
		}
		System.out.println("Invalid move, This card is not in your hand.");
		return false;
	}
	
	//for the CPU for to have an auto play a valid move or pass his turn
	public Card isValidInHand(Card x){
		for (int i=0;i<getList().size();i++){
			if((getList().get(i).getSuit().charAt(0)==x.getSuit().charAt(0))|| getList().get(i).getValue()==x.getValue()){
				return getList().get(i);		
			}
		}
		
		return null;
	}
	//for when the cpu play crazy eight
	// note. it not smart but we can make smart by add up the sum of the must suit in the hand.
	//but for now it will select the first suit in its hand
	public String searchForSuit(){
		int i=0;
		while(getList().get(i)!= null){
			return getList().get(i).getSuit();
		}
		System.out.println("hand is empty");
		return null;
	}

	public void setList(LinkedList<Card> list) {
		this.list = list;
	}

	public LinkedList<Card> getList() {
		return list;
	}
	
	

}
