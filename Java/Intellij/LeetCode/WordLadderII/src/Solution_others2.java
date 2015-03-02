import java.util.*;

/**
 * Created by Risky on 2015/1/19.
 */
public class Solution_others2 {

    static private class WordVertex implements Comparable<WordVertex>{

        private String word;
        private int dist;
        private List<WordVertex> prev;
        private HashSet<WordVertex> neighbors;

        private WordVertex(String w) {
            word = w;
            dist = Integer.MAX_VALUE;
            neighbors = new HashSet<WordVertex>();
            prev = new LinkedList<WordVertex>();
        }

        @Override
        public int compareTo(WordVertex o) {
            if (dist < o.dist) {
                return -1;
            } else if (dist > o.dist) {
                return 1;
            }
            return 0;
        }
    }

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {

        // Init vertices
        WordVertex startVertex = new WordVertex(start);
        WordVertex endVertex = new WordVertex(end);
        startVertex.dist = 0;
        List<WordVertex> vertices = new ArrayList<WordVertex>();
        vertices.add(startVertex);
        vertices.add(endVertex);
        for (String word:dict) {
            vertices.add(new WordVertex(word));
        }

        // Construct graph
        for(int i=0; i<vertices.size(); i++) {
            WordVertex vertex = vertices.get(i);
            for(int j=i+1; j<vertices.size(); j++) {
                WordVertex neighbor = vertices.get(j);
                int diff = 0;
                for (int k=0; k<vertex.word.length(); k++) {
                    if (vertex.word.charAt(k) != neighbor.word.charAt(k) && diff++ == 1) {
                        break;
                    }
                }
                if (diff == 1) {
                    vertex.neighbors.add(neighbor);
                    neighbor.neighbors.add(vertex);
                }

            }
        }

        // Find shortest path. Dijkstra's algorithm.
        PriorityQueue<WordVertex> queue = new PriorityQueue<WordVertex>();
        for (WordVertex v:vertices) {
            queue.add(v);
        }
        while(!queue.isEmpty()) {
            WordVertex v = queue.poll();
            if (v.dist == Integer.MAX_VALUE) continue;
            for (WordVertex n:v.neighbors) {
                if (v.dist + 1 <= n.dist) {
                    n.dist = v.dist + 1;
                    n.prev.add(v);   // as one of the previous candidates
                    queue.remove(n);
                    queue.add(n);
                }
            }
        }

        // Make result
        List<List<String>> seqs = new LinkedList<List<String>>();
        LinkedList<String> seq = new LinkedList<String>();
        constructSequences(endVertex, startVertex, seq, seqs);

        return seqs;
    }

    void constructSequences(WordVertex v, WordVertex start, LinkedList<String> seq, List<List<String>> seqs) {
        seq.addFirst(v.word);
        if (v == start) {
            seqs.add(new LinkedList<String>(seq));
        }
        for(WordVertex p:v.prev) {
            constructSequences(p, start, seq, seqs);
        }
        seq.removeFirst();
    }
}
