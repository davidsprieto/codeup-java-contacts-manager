import java.util.List;
import java.util.Scanner;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ContactsManager {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path pathFileToRead = Paths.get("src", "contacts.txt");
        Path pathFileToWrite = Paths.get("src", "contacts.txt");

        System.out.println("1. View Contacts.");
        System.out.println("2. Add a new contact.");
        System.out.println("3. Search a contact by name.");
        System.out.println("4. Delete an existing contact.");
        System.out.println("5. Exit.");
        System.out.println("(Enter an option 1, 2, 3, 4, or 5): ");
        int chooseOperation = scanner.nextInt();

        if (chooseOperation == 1) {
            System.out.println("Name: | Phone Number: \n" + "---------------------");
            Files.lines(pathFileToRead)
                    .forEach(System.out::println);
        } else if (chooseOperation == 2) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter name and phone number: ");
            String newContact = scanner1.nextLine();
            Files.write(pathFileToWrite,
                    List.of(newContact),
                    StandardOpenOption.APPEND
            );
            System.out.println("File updated as follows...");
            Files.lines(pathFileToRead)
                    .forEach(System.out::println);
        } else if (chooseOperation == 3) {
            Scanner scanner2 = new Scanner(System.in);
            System.out.println("Enter name: ");
            String searchContact = scanner2.nextLine();
            Contacts.FileSearch fileSearch = new Contacts.FileSearch();
            fileSearch.parseFile(String.valueOf(pathFileToRead), searchContact);

        }

    }

}