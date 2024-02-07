package be.intecbrussel;

import be.intecbrussel.model.book.Book;
import be.intecbrussel.model.book.ChildrenBooks;
import be.intecbrussel.model.book.FindAndSortKeys;
import be.intecbrussel.repository.BookRepository;
import be.intecbrussel.service.BookService;

import java.util.Optional;
import java.util.Scanner;

public class MainLibraryApp {


    public static void main(String[] args) {
        char ans = 'y';
        Scanner myScanner = new Scanner(System.in);
        BookService bookService = new BookService(new BookRepository());
        FindAndSortKeys findAndSortKeys;
        System.out.println("Welcome to Alexendria.");
        System.out.println("Enter your status admin/user");
        String status = myScanner.nextLine().toLowerCase();
        do
        {
            System.out.println("Kindly choose the method you want to perform");
            switch (status) {
                case "admin": {
                    System.out.println("1.Add Book");
                    System.out.println("2.Find Book");
                    System.out.println("3.Remove Book");
                    System.out.println("4.Sort Book");
                    System.out.println("5.update Book Record");
                    System.out.println("6.Count Book");
                    System.out.println("7.Issue Book");
                    System.out.println("8.Renew Book");
                    System.out.println("9.Return Book");
                    System.out.println("9.Browse Books");
                    System.out.println("10. Add Member");
                    System.out.println("11.Remove Member");
                    System.out.println("12.Search Member");
                    System.out.println("13. Update member info");
                    System.out.println("14.List Member");
                    System.out.println("15. Send warning");
                    System.out.println("16.Exit");
                    break;
                }
                case "member": {
                    System.out.println("17.Find Book");
                    System.out.println("18.Browse member info");
                    System.out.println("19.Browse Book");
                    System.out.println("20.Reserve Book");
                    System.out.println("21.Exit");
                    break;
                }
                default: {
                    System.out.println("Enter valid choice");
                }

            }

            System.out.println("Kindly Enter your choice");
            int choice = myScanner.nextInt();
            switch (choice) {
                case 1: {
                    try {
                        Book childrenBook = new ChildrenBooks(0, "The Lion Inside", "Rachel Bright", 2016, true);
                        bookService.addBook(childrenBook);
                    } catch (Exception e) {
                        System.out.println("Book info can not be null");
                    }
                    break;

                }
                case 2:
                {
                    System.out.println("How do you want to find a book Book Title/ Book Author/Book No");
                    System.out.println("Enter your choice");
                    System.out.println("1. Book Title");
                    System.out.println("2. Book Author");
                    System.out.println("3. Book No");
                    choice = myScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            findAndSortKeys = FindAndSortKeys.TITLE;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        case 2: {
                            findAndSortKeys = FindAndSortKeys.AUTHOR;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        case 3: {
                            findAndSortKeys = FindAndSortKeys.ID;
                            bookService.findTypeControl(findAndSortKeys);
                            break;
                        }
                        default: {
                            System.out.println("Invalid choice");
                            break;

                        }
                    }


                }
                case 4:
                {


                    //Sort method
                    System.out.println("How do you want to sort books Book Author/ Publishing year");
                    System.out.println("Enter your choice");
                    System.out.println("1. Book Author");
                    System.out.println("2. Publishing Year");
                    choice = myScanner.nextInt();
                    switch (choice) {
                        case 1: {
                            findAndSortKeys = FindAndSortKeys.AUTHOR;
                            bookService.sortTypeControl(findAndSortKeys);
                            break;
                        }
                        case 2: {
                            findAndSortKeys = FindAndSortKeys.PUBLISHING_YEAR;
                            bookService.sortTypeControl(findAndSortKeys);
                            break;
                        }

                        default: {
                            System.out.println("Invalid choice");
                            break;

                        }
                    }
                }
                case 5:
                {
                    //Update book Record
                    System.out.println("Enter book Id to update info");
                    int bookNo = myScanner.nextInt();
                    try {
                        bookService.updateBookInfo(bookNo);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Book info can not be null");
                    }

                }
                case 6:
                {
                    //count books method
                  int countOfBooks =  bookService.countBooks();
                  System.out.println("Total no of books are   "+countOfBooks);
                }



            }
            System.out.println("Do you want to continue again (y/n)");
             ans = myScanner.next().charAt(0);
        }
        while (ans == 'y'|| ans == 'Y');
    }
}