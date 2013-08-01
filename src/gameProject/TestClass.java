package gameProject;

public class TestClass {

	public static void main(String[] args){

		Human first = new Human("Ryan");
		Human second = new Human("Gaynique");
		Human third = new Human("ItakeityouknowwhereRyan^_^");
		Human fourth = new Human("Soni");
		Deck newDeck = new Deck();
		newDeck.deal(first,second,third,fourth);
		int count=0;
		//System.out.println(first.playerHand.list.isEmpty());
		//System.exit(-1);
		while(count < first.playerHand.getList().size()){
			System.out.println(first.playerHand.getList().get(count));
			count++;
		}
		System.out.println(" 0000000000000000 \n");

		System.out.println("before while loop");
		count=0;
		while(count<8){
			

			//System.out.println("ahfdj");
			System.out.println(second.playerHand.getList().get(count));
			count++;
		}
		System.out.println(" 0000000000000000 \n");
		count=0;
		while(count<8){
			

			//System.out.println("ahfdj");
			System.out.println(third.playerHand.getList().get(count));
			count++;
		}
		System.out.println(" 0000000000000000 \n");
		count=0;
		while(count<8){
			

			//System.out.println("ahfdj");
			System.out.println(fourth.playerHand.getList().get(count));
			count++;
		}
		System.out.println("outside while loop");
		
		System.out.println(first.name);
		System.out.println(second.name);
		System.out.println(third.name);
		System.out.println(fourth.name);
		
		first.drawCard(newDeck.getDeckStack().pop());
		first.drawCard(newDeck.getDeckStack().pop());
		first.drawCard(newDeck.getDeckStack().pop());

		count=0;
		while(count<11){
			

			//System.out.println("ahfdj");
			System.out.println(first.playerHand.getList().get(count));
			count++;
		}
		first.playCard(first.playerHand.getList().get(0));
		System.out.println(" 0000000000000000 \n");
		count=0;
		while(count<10){
			

			//System.out.println("ahfdj");
			System.out.println(first.playerHand.getList().get(count));
			count++;
		}



	}
	
}
