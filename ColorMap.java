import java.lang.StringBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class ColorMap{

  public static Map<String,List<String>> graph;

  public static void main( String[] args ) throws IOException {

    graph = new HashMap<String,List<String>>();

    try{
      FileReader file = new FileReader( "contiguous-usa.dat" );
      BufferedReader reader = new BufferedReader( file );
      String s = "";
      while( ( s = reader.readLine() ) != null ) {
        StringTokenizer tokenizer = new StringTokenizer( s );
        String state1 = tokenizer.nextToken();
        String state2 = tokenizer.nextToken();
        List<String> listOfNeighbours = graph.get( state1 );
        if( listOfNeighbours == null ) {
          List<String> newList = new ArrayList<String>();
          newList.add( state2 );
          graph.put( state1, newList );
        }
        else {
          listOfNeighbours.add( state2 );
        }
      
        listOfNeighbours = graph.get( state2 );
        if( listOfNeighbours == null ) {
          List<String> newList = new ArrayList<String>();
          newList.add( state1 );
          graph.put( state2, newList );
        }
        else {
          listOfNeighbours.add( state1 );
        }


      }
    }
    catch( FileNotFoundException e) {
      e.printStackTrace();
    }

    System.out.println( graph );

    Map<String,Integer> color = new HashMap<String,Integer>();
    for( String state : graph.keySet() ){
      color.put( state, 0 );
    }

    System.out.println( color );

  }
  public static void pain( String state, Map<String,Integer> color ){
    if ( color.get( state ) != 0 ) return;
    List<String> neigbours = graph.get( state );
    for( String neighbour : neighbours ) {

    }
  } 

}