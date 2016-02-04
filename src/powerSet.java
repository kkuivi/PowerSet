import java.util.ArrayList;

/*This program contains two methods that create and store a list of subsets of a set. listSubsetsIterative(int[] set)
 * does this iteratively while listSubsetsRecursive(int index, int[] set) does this recursively.*/
public class powerSet {
	public static void main (String[] args){
	
	}
	
	/*This method iteratively creates and stores all subsets of a set. This method does this by
	 * making the empty set the base case, iteratively copies the current list of subsets and then adds
	 * a new item/element to each of the copied subsets.*/
	static ArrayList<ArrayList<Integer>> listSubsetsIterative(int[] set){
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		subsets.add(new ArrayList<Integer>()); //base case --> add empty set to list of subsets
		
		for(int i = 0; i < set.length; i ++){
			addSubsets(set[i], subsets.size(), subsets); //copies all the elements currently in subsets and adds set[i] to them;
														//the subset.size() parameter will be used to ensure only the elements currently in subset are copied, not the newly added subsets.
		}
		return subsets;
	}

	/*Copies all the elements currently in subsets and adds num to them.*/
	static void addSubsets(int num, int subset_size, ArrayList<ArrayList<Integer>> subsets){
		for(int i = 0; i < subset_size; i ++){
			ArrayList<Integer> newSubset = new ArrayList<Integer>();
			newSubset.addAll(subsets.get(i)); //copy the subset at subsets.get(i)
			newSubset.add(num);
			subsets.add(newSubset);
		}
	}
	
	/*This method recursively creates and stores all subsets of a set. This method does this by
	 * making the empty set the base case, recursively copies the current list of subsets and then adds
	 * a new item/element to each of the copied subsets.*/
	static ArrayList<ArrayList<Integer>> listSubsetsRecursive(int index, int[] set){
		ArrayList<ArrayList<Integer>> allsubsets; //stores list of all subsets of set
		
		if(index == set.length){//base case --> add empty set to list of subsets
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>());
			return allsubsets;
		}
		else{
			allsubsets = listSubsetsRecursive(index + 1, set);
			ArrayList<ArrayList<Integer>> added_subsets = new ArrayList<ArrayList<Integer>>(); //stores new subsets created/found when set[index] is added to all the subsets in the allsubsets ArrayList
			for(ArrayList<Integer> subset : allsubsets){ 
				ArrayList<Integer> newSubset = new ArrayList<Integer>();
				newSubset.addAll(subset); //copy all elements in subset into newSubset
				newSubset.add(set[index]);
				added_subsets.add(newSubset);
			}
			allsubsets.addAll(added_subsets);
			return allsubsets;
		}
	}
	
	
	static void outputList(ArrayList<ArrayList<Integer>> subset_list){
		for(ArrayList<Integer> subset : subset_list){
			System.out.print("{");
			for(int i : subset){
				System.out.print(i + ",");
			}
			System.out.println("}");
			System.out.println("<----- ------>");
		}
	}
}
