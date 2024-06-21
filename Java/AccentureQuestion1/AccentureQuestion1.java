/**
 * @since 0.0.1
 * @author ichi0915
 * @version 0.0.1
 *
 * Accenture code challenge, convert the CSV file to another format.
 *
 * Format the output from:
 * 		S, 3, A, 24, David
 * 		N, Espaniol, 75
 * 		N, Matematicas, 43
 * 		S, 3, A, 22, Laura
 * 		N, Espaniol, 96
 * 		N, Matematicas, 75
 * 		N, Ciencias, 90
 * 		S, 3, B, 06, Jorge
 * 		N, Espaniol, 55
 * 		N, Matematicas, 67
 * 		S, 4, A, 06, Maria
 * 		N, Ciencias, 54
 *
 * To:
 *		Nombre: David, Grupo: 3 - A, Numero de lista: 24
 *		Materia 1: Espaniol 75
 *		Materia 2: Matematicas 43
 *		Nombre: Laura, Grupo: 3 - A, Numero de lista: 22
 *		Materia 1: Espaniol 96
 *		Materia 2: Matematicas 75
 *		Materia 3: Ciencias 90
 *		etc...
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Main Class for the AccentureQuestion1
 */
class AccentureQuestion1 {

	// Entity class that contains the student data
	public static class Student {
		public String name;
		public String group;
		public int listNumber;
		public List<Assignment> assignments = new ArrayList<Assignment>();
	}

	// Entity class that contains the student assignment data
	public static class Assignment {
		public String name;
		public int grade;
	}

	/* Use the following command to run and compile the code:
	 * 		javac -d classes AccentureQuestion1.java && java -cp classes AccentureQuestion1
	 */
	public static void main(final String[] args) {
		final String studentsNotes = getNotes();

		System.out.println("==== Original CSV format ====");
		System.out.println(studentsNotes);

		final List<Student> students = formatGrades(studentsNotes);
		// final List<Student> students = formatGrades("F, 23, Jose");					// Testing on bad data
		// final List<Student> students = formatGrades("");								// Testing on empty string
		// final List<Student> students = formatGrades(null);							// Testing on null value

		System.out.println("==== New format ====");
		printStudents(students);
	}

	// This Method converts the students CSV into a Java Class
	public static List<Student> formatGrades(final String studentsNotes) {
		final List<Student> students = new ArrayList<>();
		Student student = null;

		List<Assignment> assignments = null;
		Assignment assignment = null;

		if (null != studentsNotes && !studentsNotes.isEmpty()) {
			String[] studentsNotesArray = studentsNotes.split("\n");

			for(int i = 0; i < studentsNotesArray.length; i++) {
				// We add a space after the comma ", " to avoid trimming the csvLine
				final String[] csvLine = studentsNotesArray[i].split(", ");

				if (csvLine[0].equals("S")) {
					// If null we are in the first student
					if (null != student) {
						students.add(student);
					}
					student = new Student();
					assignments = new ArrayList<>();

					student.group = csvLine[1] + " - " + csvLine[2];
					student.listNumber = Integer.parseInt(csvLine[3]);
					student.name = csvLine[4];
					student.assignments = assignments;
				}
				else if (csvLine[0].equals("N")) {
					// Should never be null but just to be sure
					if (null != assignments) {
						assignment = new Assignment();
						assignment.name = csvLine[1];
						assignment.grade = Integer.parseInt(csvLine[2]);

						assignments.add(assignment);
					}
				}
				else {
					// Throw Exception or something
					System.out.println("CSV line has a wrong format");
				}
			}

			// Adding last student
			students.add(student);
		}

		return students;
	}

	/* Method that prints the data using the following format:
	 *     Nombre: David, Grupo: 3 - A, Numero de lista: 24
	 *     Materia 1: Espaniol 75
	 *     Materia 2: Matematicas 43
	 */
	public static void printStudents(final List<Student> students) {
		for (final Student student : students) {
			if (null != student) {
				final int assignmentLen = student.assignments.size();

				System.out.println("\nNombre: " + student.name + ", Grupo: " + student.group + ", Numero lista: " + student.listNumber);

				for (int i = 0; i < assignmentLen; i++ ) {
					final Assignment assignment = student.assignments.get(i);
					System.out.println(String.format("Materia %d: %s %s", i+1, assignment.name, assignment.grade));
				}
			}
		}
	}

	// This returns a CSV from a Database
	public static String getNotes() {
		StringBuilder studentsNotes = new StringBuilder();

		/*
		* S = Student; Where the second value is the school grade,
		*       third is the group, fourth is the number list,
		*       and fifth is the student's name
		*
		* N = Note; Where the second value is the subject's name,
		*       and the third value is the final grade
		*/
		studentsNotes.append("S, 3, A, 24, David\n");
		studentsNotes.append("N, Espaniol, 75\n");
		studentsNotes.append("N, Matematicas, 43\n");
		studentsNotes.append("S, 3, A, 22, Laura\n");
		studentsNotes.append("N, Espaniol, 96\n");
		studentsNotes.append("N, Matematicas, 75\n");
		studentsNotes.append("N, Ciencias, 90\n");
		studentsNotes.append("S, 3, B, 06, Jorge\n");
		studentsNotes.append("N, Espaniol, 55\n");
		studentsNotes.append("N, Matematicas, 67\n");
		studentsNotes.append("S, 4, A, 06, Maria\n");
		studentsNotes.append("N, Ciencias, 54\n");

		return studentsNotes.toString();
	}

}
