import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> result=new ArrayList<String>();
		HashMap<String,Boolean> dic=new HashMap<String, Boolean>();
		String key;
		for(int i=0;i<s.length()-9;i++){
			key=s.substring(i, i+10);
			if(!dic.containsKey(key)){
				dic.put(key, false);
			}else{
				dic.put(key, true);
			}
			
		}
		Iterator it = dic.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<String, Boolean> pairs = (Entry<String, Boolean>)it.next();
			if(pairs.getValue()==true){
				result.add(pairs.getKey());
			}
		}
		for(int i=0;i<s.length()-9;i++){
			key=s.substring(i, i+10);
			
		}
		return result;
    }
}