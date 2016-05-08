package student;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Display reminders of students having a birthday soon.
 * @author Palita
 */
public class StudentApp {

	/**
	 * Print the names (and birthdays) of students having a birtday in the
	 * specified month.
	 * @param students list of students
	 * @param month the month to use in selecting bithdays
	 */
	public void filterAndPrint( List<Student> students, Predicate<Student> fillter , Consumer<Student> action) {
		for(Student s : students ) {
			if (fillter.test(s)) {
				action.accept(s);
			}
		}
	}
	
	public static void main(String[] args) {
		List<Student> students = Registrar.getInstance().getStudents();
		StudentApp app = new StudentApp();
		LocalDate local = LocalDate.now();
		Predicate<Student> fillter = a -> a.getBirthdate().getMonthValue() == local.getMonthValue() ;
		Consumer<Student> action = a -> System.out.println(a.getFirstname() + " " + a.getLastname() + " will have birthday on " + a.getBirthdate().getDayOfMonth() + " " + a.getBirthdate().getMonth() + ".");
		Comparator<Student> byName = (first,second) -> first.getFirstname().charAt(0) - second.getFirstname().charAt(0);
		app.filterAndPrint(students, fillter , action);
		
	}
}
