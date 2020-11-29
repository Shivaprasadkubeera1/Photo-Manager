import java.util.LinkedList;
import java.util.Scanner;

public class DemoMain {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) throws Exception {

		Photo photo = new Photo();
		System.out.println("Hello! Welcome to Photo Manager");
		System.out.println("To add photo's to Album: Enter 1");
		System.out.println("To delete photo's from Album: Enter 2");
		System.out.println("To display photo's of Album: Enter 3");
		System.out.println("To Exit");


		while(true) {
			int choice = scan.nextInt();
			switch (choice) {
			case 1:		
				System.out.println("Enter the photo name");
				String apath = scan.next();
				photo.addPhoto(apath);
				break;
			case 2:
				System.out.println("Enter the photo name");
				String delpath = scan.next();
				photo.deletePhoto(delpath);
				break;
			case 3:
				photo.display();
				break;
			case 4:
				System.exit(0);

			default:System.out.println("We regret that you have entered wrong Choice!");
			break;
			}

		}
	}
}


