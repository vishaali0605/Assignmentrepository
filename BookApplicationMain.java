package com.src;

import java.util.List;
import java.util.Scanner;

public class BookApplicationMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Employee Management details");
		System.out.println("Enter your option");
		BookDAO b1 = new BookApplicationDAO();
		int ch = 0;
		do {
			System.out.println("1.AddBooks");
			System.out.println("2.Get Books");
			System.out.println("3.All Book Details");
			System.out.println("4.Delete Book");
			System.out.println("5.Update Book");
			System.out.println("6.Exit");
			System.out.println("Enter your choice");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter the book id,name,author's name,genre and cost");
				Book bo = new Book();
				bo.setBid(sc.nextInt());
				bo.setName(sc.next());
				bo.setBauthor(sc.next());
				bo.setBgenre(sc.next());
				bo.setBcost(sc.nextInt());
				b1.insertBooks(bo);
				System.out.println("Inserted sucessfully");
				break;
			case 2:
				System.out.println("Enter the book id");
				int id = sc.nextInt();
				Book bo1 = b1.selectBook(id);
				System.out.println(bo1.getBid() + " | " + bo1.getName() + " | " + bo1.getBauthor() + " | "
						+ bo1.getBgenre() + " | " + bo1.getBcost());
				break;
			case 3:
				List<Book> b3 = b1.SelectAllBook();
				for (Book books : b3) {
					System.out.println(books);
				}
				break;
			case 4:
				System.out.println("Enter the book id");
				int id1 = sc.nextInt();
				boolean res = b1.deleteBook(id1);
				if (res) {
					System.out.println("Deleted Sucessfully");
				} else {
					System.out.println("The ID is not present");
				}
				break;
			case 5:

				boolean res1 = false;
				Book b4 = new Book();
				System.out.println("Enter the id for updating");
				int id6 = sc.nextInt();

				System.out.println("Enter the name of book");
				b4.setBid(id6);
				b4.setName(sc.next());
				b4.setBauthor(sc.next());
				b4.setBgenre(sc.next());
				b4.setBcost(sc.nextInt());
				res1 = b1.updateBook(b4);

				if (res1) {
					System.out.println("Updates Sucessfully");
				} else {
					System.out.println("Book IDs doesn't Exist");
				}
				break;
			case 6:
				System.out.println("Goodbyee");
				break;
			default:
				System.out.println("Enter a correct option");
				break;
			}

		} while (ch != 6);

	}

}
