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

	public List<String> findWinner(List<Vote> votes){
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
	
}
