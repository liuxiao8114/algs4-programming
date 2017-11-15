import edu.princeton.cs.algs4.In;

public class BaseballElimination { 
  private final int V;
  private final ST<String, Team> teams;
  private final String[] names;
  private char[] isEliminated;
  
  private int[][] g;
  
  private class Team {
    String name;
    int index, win, lose, remain;
    
    public Team(int index, String name, int win, int lose, int remain) {
      this.index = index; this.name = name; this win = win; this.lose = lose; this.remain = remain;
    }
  }
  
  // create a baseball division from given filename in format specified below
  public BaseballElimination(String filename) {
    In in = new In(filename);
    V = Integer.parseInt(in.readLine());
    
    String[] teamsRaw = in.readAllLines();
    
    for(int i = 0; i < teamsRaw.length; i++) {
      //0: teamName, 1: win, 2: lose, 3: remain, 4~length-1: division 
      String rawData = teamsRaw[i].split("\\s+");
      int k = 4;
      for(int j = 0; j < teamsRaw.length; j++) {
        g[i][j] = rawData[k++];
      }
    }
  }
  
  // number of teams              
  public int numberOfTeams() {
    return V;
  }  
  
  // all teams                     
  public Iterable<String> teams() {
    
  }   
  
  // number of wins for given team                            
  public int wins(String team) {
    validateArgument(team);
  }      
  
  // number of losses for given team               
  public int losses(String team) {
    validateArgument(team);
  } 
  
   // number of remaining games for given team                  
  public int remaining(String team) {
    validateArgument(team);
  }           
  
  // number of remaining games between team1 and team2 
  public int against(String team1, String team2) {
    validateArgument(team1);
    validateArgument(team2);
  }    
  
  // is given team eliminated?
  public boolean isEliminated(String team) {
    validateArgument(team);
    char c = this.isEliminated[names.get(team)];
    if(c == null) {
      c = eliminate(team);
    } 
    
    return c == '1';
  }
  
  // subset R of teams that eliminates given team; null if not eliminated        
  public Iterable<String> certificateOfElimination(String team) {
    validateArgument(team);
  }
  
  private boolean eliminate(String team) {
    int vertices = V - 1 + V * (V - 1) / 2 + 2;
    FlowNetwork G = new FlowNetwork(vertices);
    Team tarTeam = teams.get(team);
    int curIndex = tarTeam.index;
    
    // build network
    for(int i = 0, VIndex = V + 1; i < V; i++) {
      if(i == curIndex) continue;
      Team curTeam = teams.get(names[i]);
      if(tarTeam.win + tarTeam.remain - curTeam.win < 0) {
        this.isEliminated[curIndex] = '1';
        return false;
      }
      
      // add every games FlowEdge
      for(int j = i + 1, gameIndex = 1; j < V; j++) {
          if(j == curIndex) continue;
          G.addEdge(new FlowEdge(0, gameIndex, g[i][j]));
      }
      
      // add vertices and compareTo  edge 
      G.addEdge(new FlowEdge(gameIndex, VIndex, 1);
    }
    
    FordFulkerson ff = new FordFulkerson(G);
    
    ff.value()
  }

  private void validateArgument(String s) {
    if(s == null) throw new IllegalArgumentException();
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

