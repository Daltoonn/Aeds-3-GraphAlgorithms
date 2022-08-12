//private count Nodes int
//private count Edges int
//private adj Matrix [][]int
//public add Edge (source:int,sink:int,weight:int)

public class Graph {
    
private int countNodes;
private int countEdges;
private int[][] adjMatrix;
private int maior;

public Graph(int countNodes){
 this.countNodes = countNodes;
 this.adjMatrix = new int [countNodes][countNodes];


}
   
public int getCountNodes() {
    return this.countNodes;
  }
 
  public int getCountEdges() {
    return this.countEdges;
  }

  public int[][] getAdjMatrix() {
    return this.adjMatrix;
  }
public String toString() {
    String str = "";
    for (int i = 0; i < this.adjMatrix.length; ++i) {
      for (int j = 0; j < this.adjMatrix[i].length; ++j) {
        str += this.adjMatrix[i][j] + "\t";
      }
      str += "\n";
    }
    return str;
  }

  public void addEdge(int source, int sink, int weight) {
    if (source < 0 || source > this.countNodes - 1 
        || sink < 0 || sink > this.countNodes - 1 || weight <= 0) {
       
      System.err.println("Invalid value for source, sink or weight!");
      return;
    }
    this.adjMatrix[source][sink] = weight;
    this.countEdges++;
  }


  public int degree(int node){

    if(node < 0 || node > this.countNodes -1)
        System.err.print("Invalid node: " + node);
   int degree = 0;
   for (int j = 0; j < this.adjMatrix[node].length;++j){
       if(this.adjMatrix[node][j] != 0)
       ++degree;
   }
    return degree;

  }


  public int highestDegree(){

   int highestDegree = 0;
   
   for (int j = 0; j < this.adjMatrix.length;++j){
        int degreeNodeJ = degree(j);
        if(highestDegree<degreeNodeJ)
            highestDegree = degreeNodeJ;

   }
    return highestDegree;

  }

  public int lowestDegree(){

    int lowestDegree = 0;
    
    for (int j = 0; j < this.adjMatrix.length;++j){
         int degreeNodeJ = degree(j);
         if(lowestDegree>degreeNodeJ)
         lowestDegree = degreeNodeJ;
 
    }
     return lowestDegree;
 
   }

   public Graph comporplement(){
            Graph gc = new Graph(this.countEdges);
            for(int i =0;i<countNodes;i++){
              for(int j =0;j<countNodes;j++){
                if(adjMatrix[i][j]== 0 && i!= j){
                  gc.addEdge(i, j, 1);
                }
              }

            }




return gc;

   } 









}


