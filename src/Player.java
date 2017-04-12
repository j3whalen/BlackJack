import java.util.ArrayList;

public class Player{
	
	private String NameOfPlayer;
	public ArrayList<String> PlayersHand= new ArrayList<String>();
	private int PlayerScore = 0;
	protected boolean Stand = false;
	protected boolean Busted = false;
	
	public boolean isBusted() {
		return Busted;
	}
	public void setBusted(boolean busted) {
		Busted = busted;
	}
	public boolean isStand() {
		return Stand;
	}
	public void setStand(boolean stand) {
		Stand = stand;
	}
	public String getNameOfPlayer() {
		return NameOfPlayer;
	}
	public void setNameOfPlayer(String nameOfPlayer) {
		NameOfPlayer = nameOfPlayer;
	}
	public ArrayList<String> getPlayersHand() {
		return PlayersHand;
	}
	public void setPlayersHand(ArrayList<String> playersHand) {
		PlayersHand = playersHand;
	}
	protected int GetPlayerScore()
	{
		PlayerScore = 0;
		for (int i = 0; i < PlayersHand.size(); i++)
		{
			PlayerScore = PlayerScore + Deck.getCardValue(PlayersHand.get(i));
		}
		return PlayerScore;
		
	}

	protected void printHand(){
		System.out.println("__YOUR HAND__");
		for (int i = 0; i < PlayersHand.size(); i++)
		{
			System.out.println(PlayersHand.get(i));
			
		}
	}

}
