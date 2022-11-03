/**
 * This file contains the Get The Groups Function.
 *
 * <p>Exercise:
 *
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main Class for the GetTheGroups
 */
class GetTheGroups {

	public static void main(final String[] args) {
		// int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		int n = 3;
		List<String> queryType = Arrays.asList("Friend","Friend","Total");
		List<Integer> students1 = Arrays.asList(1,2,3);
		List<Integer> students2 = Arrays.asList(2,3,4);

		// int n = 4;
		// List<String> queryType = Arrays.asList("Friend","Friend","Friend","Total");
		// List<Integer> students1 = Arrays.asList(1,2,5,3);
		// List<Integer> students2 = Arrays.asList(2,3,6,4);

		List<Integer> finalList = getTheGroups(n, queryType, students1, students2);

		System.out.println("Result List: " + finalList);
	}

	public static List<Integer> getTheGroups(int n, List<String> queryType, List<Integer> students1, List<Integer> students2) {
		List<Integer> finalList = new ArrayList<>();
		List<ArrayList<Integer>> studentList = new ArrayList<>();
		List<Integer> studentInList = new ArrayList<>();

		for (int i = 0; i<queryType.size(); i++) {
			if (queryType.get(i).toUpperCase().contentEquals("FRIEND")) {
				if (0 == studentList.size()){
					studentList.add(new ArrayList<>(Arrays.asList(students1.get(i), students2.get(i))));
					continue;
				}
				for (int j = 0; j<studentList.size(); j++) {
					System.out.println("for loop");
					if (studentList.get(j).contains(students1.get(i))){
						System.out.println("1");
						List<Integer> list = studentList.get(j);
						list.add(students2.get(i));
					}
					else if (studentList.get(j).contains(students2.get(i))){
						System.out.println("2");
						List<Integer> list = studentList.get(j);
						list.add(students1.get(i));
					}
					else{
						System.out.println("3");
						studentList.add(new ArrayList<>(Arrays.asList(students1.get(i), students2.get(i))));
					}
				}
			}
			if (queryType.get(i).toUpperCase().contentEquals("TOTAL")) {
				Integer Amount = 0;
				for (int j = 0; j<studentList.size(); j++) {
					Integer group1 = students1.get(i);
					Integer group2 = students2.get(i);

					if( studentList.get(j).contains(group1) || studentList.get(j).contains(group2)) {
						Amount += studentList.get(j).size();
					}
				}
				finalList.add(Amount);
			}
			else{
				//exception
			}
			System.out.println("studentList: " + studentList);
		}

		return finalList;
	}

}
