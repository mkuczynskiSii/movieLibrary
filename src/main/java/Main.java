import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int menuOption;
        MovieLibrary movieLibrary = DeserializerJSON.getMovieLibraryFromJSON();
        do {
            Menu.printMenu();
            Scanner scanner = new Scanner(System.in);
            menuOption = scanner.nextInt();
            switch (menuOption) {
                case 1:
                    System.out.println("Podaj początkowy rok produkcji");
                    int startDate = scanner.nextInt();
                    System.out.println("Podaj końcowy rok produkcji");
                    int finishDate = scanner.nextInt();
                    Movie.printMoviesCreatedBetweenDates(movieLibrary, startDate, finishDate);
                    break;
                case 2:
                    Movie.printRandomMovieInfo(movieLibrary);
                    break;
                case 3:
                    System.out.println("Podaj imię aktora");
                    String actorsFirstName = scanner.next();
                    System.out.println("Podaj nazwisko aktora");
                    String actorsLastName = scanner.next();
                    Actor.printAllMoviesWhereActorPlayed(movieLibrary, actorsFirstName, actorsLastName);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Coś poszło nie tak");
            }
        } while (menuOption != 4);
    }
}
