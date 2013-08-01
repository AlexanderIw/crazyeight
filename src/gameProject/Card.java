package gameProject;
public class Card {
   
   private int value;
   //for crazy eight modification had to remove final
  // private final String suit;
   private String suit;

   public Card (int x, String y){
      
      value=x;
      suit=y;
      
   }
   
   public void setValue(int x){
	   value=x;
   }
   
   public void setSuit(String y){
	   suit=y;
   }
   
   public int getValue(){
      return value;
   }
   
   public String getSuit(){
      return suit;
   }
   
   public String toString(){
	   
	   if (value==1){
		   return ("Ace "+suit);
	   }
	   else if (value==11){
		   return ("Jack "+suit);
	   }
	   else if (value==12){
		   return ("Queen "+suit);
	   }
	   else if (value==13){
		   return ("King "+suit);
	   }
	   else {
		   return (value+suit);
	   }
	     
   }
   
}
