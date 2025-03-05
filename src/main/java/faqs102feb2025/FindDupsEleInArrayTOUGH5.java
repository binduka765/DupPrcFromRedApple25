package faqs102feb2025;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Set;

public class FindDupsEleInArrayTOUGH5 {

	public static void main(String[] args) {
		
		String names[] = {"java","javascript","ruby","C","python","java","C"};
		
		//comparing adjacent eles - and finding the dup
		//1.compare each ele - worst soln-TimeComplexity O(n^2)
		for(int i =0;i<names.length;i++) {
			
			for(int j=i+1;j<names.length;j++) {
				if(names[i].equals(names[j])) {
					System.out.println("duplicate ele: "+names[i]);
				}
				
			}
		}
		System.out.println("------------------");
		//2.using HashSet: java collection-property:stores unique values TC:O(n)
		
		HashSet<String> store = new HashSet<String>();
		for(String e: names) {
			if(store.add(e)==false) {
				System.out.println("duplicate::"+e);
			}
		}
		System.out.println("------------------");
		//3.using HashMap:java collection-stores in key, value format-dups r allowed
		HashMap<String, Integer> storemap = new HashMap<String, Integer>();
		
		for(String n:names) {
			Integer count = storemap.get(n);
			if(count==null) {
				storemap.put(n, count);
			}
			else {
				storemap.put(n, ++count);
			}
		}
        //get values from this hashmap
		Set<Entry<String, Integer>> entryset = storemap.entrySet();
		for(Entry<String, Integer> entry:entryset) {
			System.out.println("duplicate ele is "+entry.getKey());
		}
	}

}
