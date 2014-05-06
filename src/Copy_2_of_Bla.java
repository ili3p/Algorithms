public class Copy_2_of_Bla {

}

/**
 * Here are the rules:
 * A volleyball match is played in best of three sets.
 * A team wins the set when it gets 15 points and has at least 2 points more
 * than the opponent team.
 * If the difference between the two teams is less than 2, the game continues
 * until one of the teams has a lead by 2 points.
 * The first team serves the first game in the first set,
 * while the second team serves the first game of the second set.
 * If there is a need for a third set, again the first team is the one that
 * serves first.
 * According to the old rules, not every point is counted.
 * The team wins a point only if it's the one that had the serve. If not, then
 * only a change of serve will occur.
 * game with 3 sets: "15:10-5:15-15:13"
 * game with 2 sets: "18:16-15:1"
 */

/**
 * Cuts
 * You are given a string of digits. You must cut the string K times to separate
 * it in K+1 pieces.
 * Every piece must contain at least one digit. You need to cut the string in a
 * way that the
 * biggest number on one piece will be the smallest possible. Good luck!
 * e.g.
 * "123456789" K=2 (You need to do 2 cuts.)
 * 123|456|789 The answer is "789"
 * e.g.
 * "123456789" K=3
 * 123|45|67|89 The answer is "123"
 * Input parameters:
 * numbers - the digits in a string
 * numberOfCuts - number of cuts (K)
 * Constraints:
 * numbers - will contain between 1 and 100 characters inclusive
 * numbers - will consist only of digits '0' to '9'
 * numberOfCuts will be more than 0 and less then total number of characters in
 * the string
 */
