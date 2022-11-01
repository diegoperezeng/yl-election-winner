import winner.VoteBox;

public class ElectionWinnerMain {

public static void main(String[] args) {
		
		VoteBox voteBox = new VoteBox();
		
		voteBox.addVotesInMap("Anakin", "QuiGon", "ObiWan");
		voteBox.addVotesInMap("QuiGon", "Anakin", "ObiWan");
		voteBox.addVotesInMap("Anakin", "ObiWan", "QuiGon");
		voteBox.addVotesInMap("Anakin", "QuiGon", "");
		voteBox.addVotesInMap("QuiGon", "ObiWan", "");
		voteBox.addVotesInMap("ObiWan", "Anakin", "QuiGon");
		voteBox.addVotesInMap("Anakin", "", "");
		voteBox.addVotesInMap("ObiWan", "Anakin", "QuiGon");
		voteBox.addVotesInMap("ObiWan", "Anakin", "QuiGon");
		voteBox.addVotesInMap("ObiWan", "QuiGon", "Anakin");
		voteBox.addVotesInMap("ObiWan", "QuiGon", "Anakin");
		voteBox.addVotesInMap("ObiWan", "QuiGon", "Anakin");
		voteBox.addVotesInMap("ObiWan", "QuiGon", "Anakin");
		
		voteBox.findWinner(voteBox.voteMapToList());
			
		voteBox.printElectionComplete();
		
		voteBox.printElection();
		
	}

}