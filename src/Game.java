import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Game{
	ArrayList<Player> ListOfLosers = new ArrayList<Player>();
	ArrayList<Player> ListOfRemainingPlayers = new ArrayList<Player>();
	ArrayList<Player> ListOfWinners = new ArrayList<Player>();
	boolean dealerwins = false;
	boolean Tie = false;

	public void SetupGame()
	{
		//Deck cards = new Deck();
		//cards.shuffle();
		
		Dealer dealer = new Dealer();
		
		System.out.println("Welcome to Blackjack!");
		System.out.println();
		System.out.println("Type (hit) to hit and type (stand) to stand");
		System.out.println("Type (print) to see your hand");
		System.out.println("Ace is High");
		System.out.println("How many Players?");
		
		Scanner scanner = new Scanner(System.in);
		int NumberOfPlayers = scanner.nextInt();
		ArrayList<Player> listofplayers = CreatePlayers(NumberOfPlayers);
		System.out.println("____List of players____");
		PrintPlayers(listofplayers);
		StartGame(dealer, listofplayers, dealer.GetDeck());

	}
	private void sleep(){
		try {
		    Thread.sleep(1000);                 //1000 milliseconds is one second.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	private void StartGame(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		DealerGetsDealt(dealer, cards);
		PlayersGetDealt(dealer, listofplayers, cards);
		PlayersFinishGoing(listofplayers, cards, dealer);
		DealerFlipsLastCard(dealer);
		//CheckBustedPlayers(dealer, listofplayers,cards);
		CheckRemainingPlayers(dealer, listofplayers,cards);
		DealerFinishes(dealer, listofplayers,cards);
		FindLosers(dealer, listofplayers, cards);
		FindWinners(dealer, listofplayers, cards);
		PrintLosers();
		CheckAndPrintTies(dealer, listofplayers);
		PrintWinners();
	}
	private void CheckAndPrintTies(Dealer dealer, ArrayList<Player> listofplayers){
		for (int i = 0; i < listofplayers.size(); i++){
			if(listofplayers.get(i).GetPlayerScore() == dealer.GetDealerScore()){
				System.out.println(listofplayers.get(i).getNameOfPlayer() + " and the dealer tied!");
			}
		}
		
	}
	private void PrintLosers(){
		for (int i = 0; i < ListOfLosers.size(); i++){
			System.out.println(ListOfLosers.get(i).getNameOfPlayer() + " has lost");
			sleep();
		}
	}
private void PrintWinners(){
	for (int i = 0; i < ListOfWinners.size(); i++){
		System.out.println(ListOfWinners.get(i).getNameOfPlayer() + " has won!!!");
		sleep();
	}
		
	}
	private void FindLosers(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		for (int i = 0; i < listofplayers.size(); i++){
			if(listofplayers.get(i).isBusted() || (listofplayers.get(i).GetPlayerScore() < dealer.GetDealerScore() && dealer.isBusted() == false)){
				ListOfLosers.add(listofplayers.get(i));
			}
		}	
	}
	private void FindWinners(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		for (int i = 0; i < listofplayers.size(); i++){
			if(listofplayers.get(i).isStand() && listofplayers.get(i).GetPlayerScore() > dealer.GetDealerScore() && dealerwins == false){
				ListOfWinners.add(listofplayers.get(i));
			}
		}	
	}

	private void DealerFinishes(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		int highestscore = GetHighestScoreOfRemainingPlayers();
		if (highestscore == 0){
			dealerwins = true;
		}
		if (highestscore<dealer.GetDealerScore()){
			dealerwins = true;
		}
		while (highestscore>dealer.GetDealerScore() && dealer.GetDealerScore() < 17){
			dealer.DealersHand.add(dealer.GetDeck().GetCard());
			System.out.println("Dealer picked up a " + dealer.getDealersHand().get(dealer.getDealersHand().size()-1));
			sleep();
		}
		if (dealer.GetDealerScore()>=21){
			dealer.setBusted(true);
			dealerwins = false;
			System.out.println("Dealer has Busted...");
		}
	}
	private int GetHighestScoreOfRemainingPlayers(){
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i < ListOfRemainingPlayers.size(); i++){
			scores.add(ListOfRemainingPlayers.get(i).GetPlayerScore());
		}
		if (!ListOfRemainingPlayers.isEmpty()){
		return Collections.max(scores);}
		else {return 0;}
	}
//	private void CheckBustedPlayers(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
//		for (int i = 0; i < listofplayers.size(); i++){
//			if(listofplayers.get(i).isBusted()){
//				ListOfLosers.add(listofplayers.get(i));		
//			}
//		}	
//	}
	private void CheckRemainingPlayers(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		for (int i = 0; i < listofplayers.size(); i++){
			if(listofplayers.get(i).isStand()){
				ListOfRemainingPlayers.add(listofplayers.get(i));		
			}
		}	
	}
	private void DealerFlipsLastCard(Dealer dealer){
		sleep();
		System.out.println("Dealer Flips Last Card and its a : " +dealer.getDealersHand().get(1));
		System.out.println(" ____Dealers Hand____");
		sleep();
		System.out.println(dealer.getDealersHand().get(0));
		System.out.println(dealer.getDealersHand().get(1));
		
		
	}
	private void PlayersFinishGoing(ArrayList<Player> listofplayers, Deck cards, Dealer dealer){
		for(int i = 0; i < listofplayers.size(); i++){
			while (listofplayers.get(i).isStand()==false && listofplayers.get(i).isBusted()==false){
			System.out.println(listofplayers.get(i).getNameOfPlayer()+"'s Turn:");
			System.out.println("___________________");
			executeuserinput(listofplayers, dealer, cards, i);}
			
		}
	}
	private void executeuserinput(ArrayList<Player> listofplayers, Dealer dealer, Deck cards, int i){
		Scanner scanner = new Scanner(System.in);
		String UserInput = scanner.next();	
		switch (UserInput){
		case "hit":
			listofplayers.get(i).PlayersHand.add(dealer.GetDeck().GetCard());
			System.out.println("Player picked up a "+ listofplayers.get(i).getPlayersHand().get(listofplayers.get(i).getPlayersHand().size()-1));
			if (listofplayers.get(i).GetPlayerScore() > 21){
				System.out.println(listofplayers.get(i).getNameOfPlayer()+" Busted");
				System.out.println();
				listofplayers.get(i).setBusted(true);
				
		}
			break;
		case "print":
			listofplayers.get(i).printHand();
			System.out.println("Youre score: "+listofplayers.get(i).GetPlayerScore());
			break;
		case "stand":
			listofplayers.get(i).setStand(true);
			break;
		
	}
    }
	
	
	private void DealerGetsDealt(Dealer dealer, Deck cards){
		ArrayList<String> newdealerhand = new ArrayList<String>();
		newdealerhand.add(dealer.GetDeck().GetCard());
		newdealerhand.add(dealer.GetDeck().GetCard());
		dealer.setDealersHand(newdealerhand);
		System.out.println("______DEALER DRAWS______" );
		sleep();
		System.out.println("Face UP card: " + dealer.getDealersHand().get(0));
		sleep();
		System.out.println("Face DOWN card: **********" );
		System.out.println();
	}
	private void PlayersGetDealt(Dealer dealer, ArrayList<Player> listofplayers, Deck cards){
		for (int i = 0; i < listofplayers.size(); i++){
			ArrayList<String> newplayerhand = new ArrayList<String>();
			newplayerhand.add(dealer.GetDeck().GetCard());
			newplayerhand.add(dealer.GetDeck().GetCard());
			listofplayers.get(i).setPlayersHand(newplayerhand);
			sleep();
			System.out.println(listofplayers.get(i).getNameOfPlayer() + " is getting dealt:");
			sleep();
			System.out.println(listofplayers.get(i).getPlayersHand().get(0));
			sleep();
			System.out.println(listofplayers.get(i).getPlayersHand().get(1));
			System.out.println();
			}
	}
	
	private ArrayList<Player> CreatePlayers(int number){
		ArrayList<Player> listofplayers = new ArrayList<Player>();
		for (int i = 0; i < number; i ++){
			Player player = new Player();
			player.setNameOfPlayer("Player "+(1+i));
			listofplayers.add(player);
		}
		return listofplayers;		
	}
	private void PrintPlayers(ArrayList<Player> listofplayers){
		for (int i = 0; i < listofplayers.size(); i++){
			System.out.println(listofplayers.get(i).getNameOfPlayer());
		}
	}

}
