import java.time.LocalDate;

public class Exam {
	short ID;
	String code;
	String title;
	categoryQuestion category;
	short duration;
	Account creator;
	LocalDate createDate;
	Question[] questions;
}
