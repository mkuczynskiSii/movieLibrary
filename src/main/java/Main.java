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
                    System.out.println("Filmy z biblioteki wyprodukowane pomiędzy " + startDate + ", a " + finishDate + " rokiem to:");
                    Movie.printMoviesCreatedBetweenDates(movieLibrary, startDate, finishDate);
                    break;
                case 2:
                    Movie.printRandomMovieInfo(movieLibrary);
                    break;
                case 3:
                    System.out.println("Podaj imię aktora");
                    String actorFirstName = scanner.next();
                    System.out.println("Podaj nazwisko aktora");
                    String actorLastName = scanner.next();
                    System.out.println("Filmy w których wystąpił " + actorFirstName + " " + actorLastName + " to:");
                    Actor.printAllMoviesWhereActorPlayed(movieLibrary, actorFirstName, actorLastName);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Coś poszło nie tak");
            }
        } while (menuOption != 4);
    }
}
