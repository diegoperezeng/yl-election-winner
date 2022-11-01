package winner;

public class Vote implements Comparable<Vote> {
	
	private String candidate;
	private Integer points;
	
	public Vote() {
	}	
	
	public Vote(String candidate, Integer points) {
		super();
		this.candidate = candidate;
		this.points = points;
	}

	public String getCandidate() {
		return candidate;
	}

	public void setCandidate(String candidate) {
		this.candidate = candidate;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public int compareTo(Vote o) {
		if(getPoints() == null || o.getPoints() == null) {
			return 0;
		}		
		return getPoints().compareTo(o.getPoints());
	}

	@Override
	public String toString() {
		return "Vote [candidate=" + candidate + ", points=" + points + "]";
	}
	
	
	
		

}
