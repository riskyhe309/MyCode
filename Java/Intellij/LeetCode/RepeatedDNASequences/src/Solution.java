import java.util.*;

/**
 * Created by Risky on 2015/2/6.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {

        List<String> re = new LinkedList<String>();
        if(s.length() < 10)
            return re;

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        int dna = DNA2Int(s.substring(0,10));

        map.put(dna,1);

        for(int i = 10; i < s.length(); i++){

            dna = dna & 0x3ffff;  //just get the last 18 bit
            dna <<= 2;

            switch(s.charAt(i)){
                case 'A':
                    dna |= 0;
                    break;
                case 'C':
                    dna |= 1;
                    break;
                case 'T':
                    dna |= 2;
                    break;
                case 'G':
                    dna |= 3;
                    break;
                default:
                    break;
            }

            Integer value = map.get(dna);
            if(value == null)
                map.put(dna, 1);
            else
                map.put(dna, value + 1);
        }

        Iterator<Integer> it = map.keySet().iterator();

        while(it.hasNext()){
            int key = it.next();
            if(map.get(key) > 1)
                re.add(int2DNA(key));
        }

        return re;
    }

    int DNA2Int(String s){
        int dna = 0;
        for(int i = 0; i < 10; i++){
            dna <<= 2;
            switch(s.charAt(i)){
                case 'A':
                    dna|= 0;
                    break;
                case 'C':
                    dna |= 1;
                    break;
                case 'T':
                    dna |= 2;
                    break;
                case 'G':
                    dna |= 3;
                    break;
                default:
                    break;
            }
        }

        return dna;
    }

    String int2DNA(int key){

        StringBuilder sb = new StringBuilder();

        for(int i = 10; i > 0; i--){

            switch(key & 3){
                case 0:
                    sb.insert(0, "A");
                    break;
                case 1:
                    sb.insert(0, "C");
                    break;
                case 2:
                    sb.insert(0, "T");
                    break;
                case 3:
                    sb.insert(0,"G");
                    break;
                default:
                    break;
            }

            key >>= 2;
        }

        return sb.toString();

    }
}