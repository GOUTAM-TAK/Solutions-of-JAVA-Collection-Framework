package tester;

import utils.*;
import static utils.PublicationValidationRules.*;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import static utils.PublicationUtils.*;
import core.Publication;

public class TestPublication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try (Scanner sc = new Scanner(System.in)) {
			List<Publication> publications = populatedList();
			boolean exit = false;

			while (!exit) {
				try {
					System.out.println("Choose option : \n" + "1)Publish new Book \n2)Publish new Tape \n"
							+ "3)List all publications ordered by publish date desending order\n"
							+ "4)List top 5 publications of current year based upon ratings\n"
							+ "5)Remove all publications which are 5 years old\n" + "6)Exit");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("enter Book details as respectively : "
								+ "\nPublisher name,price,publicsh date(yyyy-mm-dd),rating(1-10),total page count");
						publications.add(checkAllInputBook(sc.next(), sc.nextInt(), sc.next(), sc.nextInt(),
								sc.nextInt(), publications));
						System.out.println("successfully publish book!!");
						break;
					case 2:
						System.out.println("Enter Tape details as respectively :\n"
								+ "Publisher's name,price,publish date(yyyy-mm-dd),rating(1-10),total time(in mins<60)");
						publications.add(checkAllInputTape(sc.next(), sc.nextInt(), sc.next(), sc.nextInt(),
								sc.nextInt(), publications));
						System.out.println("succussfully publish tape!!!");
						break;
					case 3:
						/*System.out.println("before sorting ....");
						for (Publication p : publications)
							System.out.println(p);*/
						System.out.println("After sorting according Date descending order...");
						Collections.sort(publications, new PublicationUtils());
						for (Publication p : publications)
							System.out.println(p);
						break;
					case 4:System.out.println("list top 5 rating Publication of current year...: ");
					List<Publication> temp = curntRatingOrder(publications);
					for(int i=0;i<temp.size()&&i<5;i++)
						System.out.println(temp.get(i));
					break;
					case 5:System.out.println("remove 5 year old records ");
					publications = oldRecordRemove(publications);
					for(Publication p : publications)
						System.out.println(p);
						break;
					case 6:
						System.out.println("Thank you!!!");
						exit = true;
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
					sc.nextLine();
				}
			}
		}
	}

}
