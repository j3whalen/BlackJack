import java.util.ArrayList;
import java.util.Random;

public class Deck{
	private ArrayList<String> TheDeckOfCards= new ArrayList<String>();
	private ArrayList<String> ShuffledDeckofCards= new ArrayList<String>();
	public Deck()
	{
		TheDeckOfCards.add("2 of spades");
		TheDeckOfCards.add("3 of spades");
		TheDeckOfCards.add("4 of spades");
		TheDeckOfCards.add("5 of spades");
		TheDeckOfCards.add("6 of spades");
		TheDeckOfCards.add("7 of spades");
		TheDeckOfCards.add("8 of spades");
		TheDeckOfCards.add("9 of spades");
		TheDeckOfCards.add("10 of spades");
		TheDeckOfCards.add("jack of spades");
		TheDeckOfCards.add("queen of spades");
		TheDeckOfCards.add("king of spades");
		TheDeckOfCards.add("ace of spades");
		TheDeckOfCards.add("2 of hearts");
		TheDeckOfCards.add("3 of hearts");
		TheDeckOfCards.add("4 of hearts");
		TheDeckOfCards.add("5 of hearts");
		TheDeckOfCards.add("6 of hearts");
		TheDeckOfCards.add("7 of hearts");
		TheDeckOfCards.add("8 of hearts");
		TheDeckOfCards.add("9 of hearts");
		TheDeckOfCards.add("10 of hearts");
		TheDeckOfCards.add("jack of hearts");
		TheDeckOfCards.add("queen of hearts");
		TheDeckOfCards.add("king of hearts");
		TheDeckOfCards.add("ace of hearts");
		TheDeckOfCards.add("2 of diamonds");
		TheDeckOfCards.add("3 of diamonds");
		TheDeckOfCards.add("4 of diamonds");
		TheDeckOfCards.add("5 of diamonds");
		TheDeckOfCards.add("6 of diamonds");
		TheDeckOfCards.add("7 of diamonds");
		TheDeckOfCards.add("8 of diamonds");
		TheDeckOfCards.add("9 of diamonds");
		TheDeckOfCards.add("10 of diamonds");
		TheDeckOfCards.add("jack of diamonds");
		TheDeckOfCards.add("queen of diamonds");
		TheDeckOfCards.add("king of diamonds");
		TheDeckOfCards.add("ace of diamonds");
		TheDeckOfCards.add("2 of clubs");
		TheDeckOfCards.add("3 of clubs");
		TheDeckOfCards.add("4 of clubs");
		TheDeckOfCards.add("5 of clubs");
		TheDeckOfCards.add("6 of clubs");
		TheDeckOfCards.add("7 of clubs");
		TheDeckOfCards.add("8 of clubs");
		TheDeckOfCards.add("9 of clubs");
		TheDeckOfCards.add("10 of clubs");
		TheDeckOfCards.add("jack of clubs");
		TheDeckOfCards.add("queen of clubs");
		TheDeckOfCards.add("king of clubs");
		TheDeckOfCards.add("ace of clubs");		
		shuffle();
	}
	protected void shuffle()
	{
		Random index = new Random();
		int number;

		
		while (!TheDeckOfCards.isEmpty()){
			number = index.nextInt(TheDeckOfCards.size());
			ShuffledDeckofCards.add(TheDeckOfCards.get(number));
			TheDeckOfCards.remove(number);
		}
	}
	public static int getCardValue(String card)
	{	int valueOfCard = 0;
		char FirstLetter = card.charAt(0);
		switch(FirstLetter){
		case '2':
			valueOfCard = 2;
		break;
		case '3':
			valueOfCard = 3;
		break;
		case '4':
			valueOfCard = 4;
		break;
		case '5':
			valueOfCard = 5;
		break;
		case '6':
			valueOfCard = 6;
		break;
		case '7':
			valueOfCard = 7;
		break;
		case '8':
			valueOfCard = 8;
		break;
		case '9':
			valueOfCard = 9;
		break;
		case '1':
			valueOfCard = 10;
		break;
		case 'j':
			valueOfCard = 10;
		break;
		case 'q':
			valueOfCard = 10;
		break;
		case 'k':
			valueOfCard = 10;
		break;
		case 'a':
			valueOfCard = 11;
		break;
		}
		return valueOfCard;
	}
	
	public String GetCard(){
		return this.ShuffledDeckofCards.remove(0);
	}

}
