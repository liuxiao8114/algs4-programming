import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.FlowEdge;
import edu.princeton.cs.algs4.FlowNetwork;
import edu.princeton.cs.algs4.FordFulkerson;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;
import edu.princeton.cs.algs4.StdOut;

public class BaseballElimination {
  private final int V;
  private final ST<String, Team> teams;
  private final String[] names;
  private final int[] isEliminated;
  private final ST<String, Bag<String>> eliminateTeams;

  private final int[][] g;

  private class Team {
    int index, wins, losses, remain;

    public Team(int index, int wins, int losses, int remain) {
      this.index = index; this.wins = wins; this.losses = losses; this.remain = remain;
    }
  }

  // create a baseball division from given filename in format specified below
  public BaseballElimination(String filename) {
    In in = new In(filename);
    V = Integer.parseInt(in.readLine());
    g = new int[V][V];
    teams = new ST<String, Team>();
    names = new String[V];
    isEliminated = new int[V];
    eliminateTeams = new ST<String, Bag<String>>();

    String[] teamsRaw = in.readAllLines();

    for(int i = 0; i < teamsRaw.length; i++) {
      //0: teamName, 1: win, 2: lose, 3: remain, 4~length-1: division
      String[] rawDatas = teamsRaw[i].split("\\s+");
      int n = 0;
      if(rawDatas[n].equals("")) n++;
      teams.put(rawDatas[n], new Team(i, Integer.parseInt(rawDatas[n + 1]), Integer.parseInt(rawDatas[n + 2]), Integer.parseInt(rawDatas[n + 3])));
      names[i] = rawDatas[n];
      int k = n + 4;
      for(int j = 0; j < teamsRaw.length; j++) {
        g[i][j] = Integer.parseInt(rawDatas[k++]);
      }
    }
  }

  // number of teams
  public int numberOfTeams() {
    return V;
  }

  // all teams
  public Iterable<String> teams() {
    return teams.keys();
  }

  // number of wins for given team
  public int wins(String team) {
    validateArgument(team);
    return teams.get(team).wins;
  }

  // number of losses for given team
  public int losses(String team) {
    validateArgument(team);
    return teams.get(team).losses;
  }

   // number of remaining games for given team
  public int remaining(String team) {
    validateArgument(team);
    return teams.get(team).remain;
  }

  // number of remaining games between team1 and team2
  public int against(String team1, String team2) {
    validateArgument(team1);
    validateArgument(team2);

    return g[teams.get(team1).index][teams.get(team2).index];
  }

  // is given team eliminated?
  public boolean isEliminated(String team) {
    validateArgument(team);
    int x = isEliminated[teams.get(team).index];
    if(x == 0) {
      return eliminate(team);
    }

    return x == 1;
  }

  // subset R of teams that eliminates given team; null if not eliminated
  public Iterable<String> certificateOfElimination(String team) {
    validateArgument(team);
    int v = teams.get(team).index;
    if(isEliminated[v] == 0)
      eliminate(team);

    return eliminateTeams.get(team);
  }

  private boolean eliminate(String team) {
    int vertices = V - 1 + (V - 1) * (V - 2) / 2 + 2;
    FlowNetwork G = new FlowNetwork(vertices);
    Team tarTeam = teams.get(team);
    int tarIndex = tarTeam.index;
    int sum = 0, gameIndex = 1;

    // build network
    for(int i = 0, indexlog1 = vertices - V; i < V; i++) {
      if(i == tarIndex) continue;
      Team curTeam = teams.get(names[i]);
      if(tarTeam.wins + tarTeam.remain - curTeam.wins < 0) {
        isEliminated[tarIndex] = 1;
        Bag<String> b =  new Bag<String>();
        b.add(names[i]);
        eliminateTeams.put(team, b);;
        return true;
      }

      // add every games FlowEdge
      for(int j = i + 1, indexlog2 = j > tarIndex ? j - 1 : j; j < V; j++) {
        if(j == tarIndex) continue;
        G.addEdge(new FlowEdge(0, gameIndex, g[i][j]));
        sum += g[i][j];
        // add vertices, when (vertices - v) is the start index at team
        G.addEdge(new FlowEdge(gameIndex, indexlog1, Double.POSITIVE_INFINITY));
        G.addEdge(new FlowEdge(gameIndex, (indexlog2++) + vertices - V, Double.POSITIVE_INFINITY));
        gameIndex++;
      }

      G.addEdge(new FlowEdge(indexlog1++, vertices - 1, tarTeam.wins + tarTeam.remain - curTeam.wins));
    }

    FordFulkerson ff = new FordFulkerson(G, 0, vertices - 1);

    if(ff.value() == sum) {
      isEliminated[tarIndex] = 2;
      eliminateTeams.put(team, null);
      return false;
    } else if(ff.value() < sum){
      isEliminated[tarIndex] = 1;
      Bag<String> b = new Bag<String>();

      for(int i = gameIndex; i < vertices - 1; i++) {
        if(ff.inCut(i)) {
        	if(i - gameIndex < tarIndex) b.add(names[i - gameIndex]);
        	else b.add(names[i - gameIndex + 1]);
        }
      }

      eliminateTeams.put(team, b);
      return true;
    } else {
      throw new IllegalArgumentException("this is impossible! check the sum calculation");
    }
  }

  private void validateArgument(String s) {
    if(s == null || !teams.contains(s)) throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    BaseballElimination division = new BaseballElimination(args[0]);

    for (String team : division.teams()) {
        if (division.isEliminated(team)) {
            StdOut.print(team + " is eliminated by the subset R = { ");
            for (String t : division.certificateOfElimination(team)) {
                StdOut.print(t + " ");
            }
            StdOut.println("}");
        }
        else {
            StdOut.println(team + " is not eliminated");
        }
    }
  }
}
