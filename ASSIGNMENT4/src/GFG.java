
	

	import java.io.*;
	import java.util.*;

	public class GFG {

		
		static class Pair {

			int index1;
			int index2;

		
			Pair(int x, int y)
			{
				index1 = x;
				index2 = y;
			}
		}

	
		public static void
		GetQuadruplets(ArrayList<Integer> nums,
					int target)
		{

			
			HashMap<Integer, ArrayList<Pair> > map
				= new HashMap<>();

			
			for (int i = 0;
				i < nums.size() - 1; i++) {

				for (int j = i + 1;
					j < nums.size(); j++) {

					
					int sum = nums.get(i)
							+ nums.get(j);

					// If the sum doesn't
					// exists then update
					// with the new pairs
					if (!map.containsKey(sum)) {

						ArrayList<Pair> temp
							= new ArrayList<>();
						Pair p = new Pair(i, j);
						temp.add(p);

						map.put(sum, temp);
					}

					else {

						ArrayList<Pair> temp
							= map.get(sum);

						Pair p = new Pair(i, j);
						temp.add(p);

						
						map.put(sum, temp);
					}
				}
			}

		
			HashSet<ArrayList<Integer> > ans
				= new HashSet<ArrayList<Integer> >();

			for (int i = 0;
				i < nums.size() - 1; i++) {

				for (int j = i + 1;
					j < nums.size(); j++) {

					int lookUp = target
								- (nums.get(i)
									+ nums.get(j));

					
					if (map.containsKey(lookUp)) {

						// Get the pair of
						// indices of sum
						ArrayList<Pair> temp
							= map.get(lookUp);

						for (Pair pair : temp) {

							// Check if i, j, k
							// and l are distinct
							// or not
							if (pair.index1 != i
								&& pair.index1 != j
								&& pair.index2 != i
								&& pair.index2 != j) {

								ArrayList<Integer> values
									= new ArrayList<>();
								values.add(
									nums.get(pair.index1));
								values.add(
									nums.get(pair.index2));
								values.add(nums.get(i));
								values.add(nums.get(j));

								// Sort the list to
								// avoid duplicacy
								Collections.sort(values);

								// Update the hashset
								ans.add(values);
							}
						}
					}
				}
			}

			// Print all the Quadruplets
			for (ArrayList<Integer> arr : ans) {
				System.out.println(arr);
			}
		}

		// Driver Code
		public static void main(String[] args)
		{
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(1);
			arr.add(0);
			arr.add(-1);
			arr.add(0);
			arr.add(-2);
			arr.add(2);
			int K = 0;
			GetQuadruplets(arr, K);
		}
	}


