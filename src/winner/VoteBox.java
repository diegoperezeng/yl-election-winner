package winner;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class VoteBox {
	
	private List<Vote> electionList = new ArrayList<Vote>();
	private Map<String, Integer> electionMap = new HashMap<String, Integer>();

	List<String> findWinner(List<Vote> votes){
		Collections.sort(votes);
		Collections.reverse(votes);		
		
		return votes.stream().map(v -> v.getCandidate()).collect(Collectors.toCollection(ArrayList::new));
		
	}	
	
	public void addVotesInMap(String candidateOne, String candidateTwo, String candidateThree) {
		
		String[] voteChoices = new String[3]; 
		
		voteChoices[0] = candidateOne;
		voteChoices[1] = candidateTwo;
		voteChoices[2] = candidateThree;
		
		int x = 0;
		Integer point = 0;
		
		while(x < voteChoices.length) {
			if(voteChoices[x] != null && voteChoices[x] != "") {
				point = this.electionMap.containsKey(voteChoices[x])?this.electionMap.get(voteChoices[x]) + 3 - x : 3 - x;
				this.electionMap. put(voteChoices[x], point);
			}
			x += 1;
		}
	}
	
	public List<Vote> voteMapToList(){
		int i = 0;
		ArrayList<String> list = new ArrayList<String>(this.electionMap.keySet());
		
		while(i < list.size()) {
			Vote a = new Vote();
			a.setCandidate(list.get(i));
			a.setPoints(electionMap.get(list.get(i)));
			this.electionList.add(a);
			i+=1;
		}
		
		return this.electionList;
	}
	
	public void printElectionComplete() {
		int i = 0;
		
		System.out.println("");
		System.out.println("");
		System.out.println("=========================Elections Results=========================");
		System.out.println("");
		
		while(i < this.electionList.size()){
			System.out.println(this.electionList.get(i));
			i+=1;
		}
		
		System.out.println("");
		System.out.println("============================End of List============================");
	}
	
	public void printElection() {
		for(int i = 0 ; i < this.electionList.size() ; i++ ) {
			System.out.println(this.findWinner(this.electionList).get(i));
		}
	}
	
	


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
	

/*
 * We are going to implement a function that determines the winner of a round of Shipit. Our function is going to look something like this:

 * For a list of votes, return an ordered set of candidate in descending order of their votes.

List<String> findWinner(List<Vote> votes)
We pass in a list of votes and we are returned a list of names in the descending order of the score that each candidate received.

Assume that we extract the candidates' names from the votes as we process them.

A voter is allowed to vote for up to three different candidates. The order of the votes is important. The first vote that a voter places is worth three points. The second vote is worth two points. The third vote is worth one point.

The function should return a list of candidates in descending order of the total number of points received by the candidate.
*/
