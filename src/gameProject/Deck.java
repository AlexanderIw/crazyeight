package gameProject;
import java.util.Random;
import java.util.Stack;
public class Deck {
   
   private static Stack<Card> deckStack = new Stack<Card>();

   private Card shuffleArray[] = new Card[52];
   
   public Deck(){
      int count=0;
      for(int i=1;i<14;i++){
         for(int j=1;j<5;j++){
          
            if(j==1){
               shuffleArray[count] = new Card(i,"D");
            }
            else if (j==2){
               shuffleArray[count] = new Card(i,"C");
            }
            else if (j==3){
               shuffleArray[count] = new Card(i,"H");
            }
            else if (j==4){
               shuffleArray[count] = new Card(i,"S");
            }
            count++;
            
         }
      }
      shuffle();
      for(int i=0;i<52;i++){
          getDeckStack().push(shuffleArray[i]);
      }
   }
   
   public void shuffle(){
      
      int swap1;
      int swap2;
      Card temp;
      for(int i=0;i<1000;i++){
         Random generator = new Random();
         swap1 = generator.nextInt(52);
         swap2 = generator.nextInt(52);
         temp = shuffleArray[swap1];
         shuffleArray[swap1] = shuffleArray[swap2];
         shuffleArray[swap2] = temp;
      }
      
   }
   
   public void deal(Player a, Player b){
	   for(int i=0;i<8;i++){
		   a.playerHand.addCard(getDeckStack().pop()); 
		   b.playerHand.addCard(getDeckStack().pop());
	   }
   }
   public void deal(Player a, Player b, Player c){
	   for(int i=0;i<8;i++){
		   a.playerHand.addCard(getDeckStack().pop());
		   b.playerHand.addCard(getDeckStack().pop());
		   c.playerHand.addCard(getDeckStack().pop());
	   }
   }
   public void deal(Player a, Player b, Player c, Player d){
	   for(int i=0;i<8;i++){
		   a.playerHand.addCard(getDeckStack().pop());
		   b.playerHand.addCard(getDeckStack().pop());
		   c.playerHand.addCard(getDeckStack().pop());
		   d.playerHand.addCard(getDeckStack().pop());
	   }
   }
   
   //add changes here
   public Card pop(){
	   if(deckStack.isEmpty()){
		   System.out.println("The deck is empty");
		   return null;
	   }
	   
	   return deckStack.pop();   
   }

   public static void setDeckStack(Stack<Card> deckStack) {
	Deck.deckStack = deckStack;
   }

	public static Stack<Card> getDeckStack() {
		return deckStack;
	} 
}