package logic;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

/*
Application class has main method that controls the flow of this program.
It reads a text file to create all necessary information to get this app up and running.
After that, it shows main menu and asks users what they want to do. 
When received order from users, it calls methods in CinemaComplex to the task.
After the task is done, it brings users back to main menu.
*/

public class Application {
	
	public static CinemaComplex CINEMACOMPLEX = new CinemaComplex();
	public static Scanner KEYBOARD = new Scanner(System.in);
	public static String inputFile = "src/MovieProgram.txt";

	public static void main(String[] args) {
		int menuInput = 0;
		readMovieProgram();
		while(menuInput != 4) {
			printMainMenu();
			menuInput = acceptMainMenuInput();
			if (menuInput == -1 || menuInput == 4) {
				continue;
			}
			else {
				switch (menuInput) {
					case 1:
						System.out.println("-------------------------");
						CINEMACOMPLEX.showAllMoviesInTheater();
						System.out.println("-------------------------");
						break;
					case 2:
						System.out.println("-------------------------");
						CINEMACOMPLEX.handleBookingProcess();
						System.out.println("-------------------------");
						break;
					case 3:
						System.out.println("-------------------------");
						CINEMACOMPLEX.showAlltickets();
						System.out.println("-------------------------");
						break;
					default:
						break;
				}
			}
		}
		KEYBOARD.close();
		System.out.println("--- Exit ---");
	}
	
	public static void printMainMenu() {
		System.out.println("--- Main Menu ---");
		System.out.println("1 - View Available Movies");
		System.out.println("2 - Book Tickets");
		System.out.println("3 - View All Tickets");
		System.out.println("4 - Quit");
		System.out.print("Please select what to do: ");
	}
	
	public static int acceptMainMenuInput() {
		int input = KEYBOARD.nextInt();
		if (input < 1 || input > 4) {
			return -1;
		}
		return input;
	}
	
	public static void readMovieProgram() {
		boolean readingMovieList = false;
		boolean readingTheaterList = false;
		File file = null;
		BufferedReader fileReader = null;
		String thisLine = null;
		try {
			file = new File(inputFile);
			fileReader = new BufferedReader(new FileReader(file));
			while ((thisLine = fileReader.readLine()) != null) {
				if (thisLine.trim().equals("---Movie List---")) {
					readingMovieList = true;
					readingTheaterList = false;
					continue;
				}
				else if (thisLine.trim().equals("---Theater List---")) {
					readingMovieList = false;
					readingTheaterList = true;
					continue;
				}
				else if (thisLine.trim().equals("---Movie Program---")) {
					readingMovieList = false;
					readingTheaterList = false;
					continue;
				}
				else {
					if (readingMovieList) {
						CINEMACOMPLEX.createMovie(thisLine);
					}
					else if (readingTheaterList) {
						CINEMACOMPLEX.createTheater(thisLine);
					}
					else {
						CINEMACOMPLEX.assignMovieAndShowtimeToTheater(thisLine);
					}
				}
			}
		} 
		catch (IOException e) {
		    e.printStackTrace();
		} 
		finally {
		    try {
		        fileReader.close();
		    } 
		    catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
