
We are going to implement a function that determines the winner of a round of Shipit. Our function is going to look something like this:
List<String> findWinner(List<Vote> votes)


For a list of votes, return an ordered set of candidate in descending order of their votes.

We pass in a list of votes and we are returned a list of names in the descending order of the score that each candidate received.

Assume that we extract the candidates' names from the votes as we process them.

A voter is allowed to vote for up to three different candidates. The order of the votes is important. The first vote that a voter places is worth three points. The second vote is worth two points. The third vote is worth one point.

The function should return a list of candidates in descending order of the total number of points received by the candidate.
