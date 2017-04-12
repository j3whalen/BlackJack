import java.util.ArrayList;

public class Dealer extends Player{

	public ArrayList<String> DealersHand= new ArrayList<String>();
	protected int DealerScore = 0;
	protected boolean Busted = false;
	
	Deck cards = new Deck();

	public boolean isBusted() {
		return Busted;
	}

	public void setBusted(boolean busted) {
		Busted = busted;
	}

	public ArrayList<String> getDealersHand() {
		return DealersHand;
	}

	public void setDealersHand(ArrayList<String> dealersHand) {
		DealersHand = dealersHand;
	}
	protected int GetDealerScore()
	{
		DealerScore = 0;
		for (int i = 0; i < DealersHand.size(); i++)
		{
			DealerScore = DealerScore + Deck.getCardValue(DealersHand.get(i));
		}
		return DealerScore;
		
	}
	
	public Deck GetDeck(){
		return cards;
	}
	
}
