//Author: Marcus Ridley
//Date: 7/2/2021
//Program Name: Ridley_WordOccurrences
//Purpose: Analyzes text from an HTML file and returns results using JUnit

package Ridley_WordOccurrences

import static org.junit.Assert.*;

import org.junit.Test;
import java.io.IOException;
import java.util.ArrayList;
import javafx.util.Pair;

/** Tests Ridley_WordOccurrences using a test case. */
public class Ridley_WordOccurrencesTest {

	//main method, which invokes class's own test method.
	/** Invokes class's own test method.
	 *  @param args Default args parameter included in main method. Not used here.
	 *  @throws IOException Needed if the file to be analyzed can't be found. */
	public static void main(String[] args) throws IOException {

		//Creates Ridley_WordOccurrencesTest object, then invokes its test method.
		Ridley_WordOccurrencesTest WordOccurrencesTest = new Ridley_WordOccurrencesTest();
		WordOccurrencesTest.test();
	}

	/** Tests Ridley_WordOccurrences against a test case to determine if it's functioning properly.
	 *  @throws IOException Needed if the file to be analyzed can't be found. */
	@Test
	public void test() throws IOException {

		//Creates ArrayList object testTop20 to contain known answers to the test case.
		//This test case is testing the script from the movie The Matrix
		ArrayList<Pair<String, Integer>> testTop20 = new ArrayList<Pair<String, Integer>>();
		testTop20.add(new Pair<String, Integer>("the",       13));
		testTop20.add(new Pair<String, Integer>("computer",      12));
		testTop20.add(new Pair<String, Integer>("matrix",  12));
		testTop20.add(new Pair<String, Integer>("a",         11));
		testTop20.add(new Pair<String, Integer>("neo", 11));
		testTop20.add(new Pair<String, Integer>("gun",        7));
		testTop20.add(new Pair<String, Integer>("hacker",    7));
		testTop20.add(new Pair<String, Integer>("pill",    7));
		testTop20.add(new Pair<String, Integer>("trinity",       6));
		testTop20.add(new Pair<String, Integer>("of",        6));
		testTop20.add(new Pair<String, Integer>("the",        4));
		testTop20.add(new Pair<String, Integer>("one",         3));
		testTop20.add(new Pair<String, Integer>("enter",     3));
		testTop20.add(new Pair<String, Integer>("love",        3));
		testTop20.add(new Pair<String, Integer>("most",      3));
		testTop20.add(new Pair<String, Integer>("now",       3));
		testTop20.add(new Pair<String, Integer>("will",      3));
		testTop20.add(new Pair<String, Integer>("can",       3));
		testTop20.add(new Pair<String, Integer>("you",       3));
		testTop20.add(new Pair<String, Integer>("me",        3));

		//Creates Ridley_WordOccurrences object analyzer to invoke its main method using test file.
		Ridley_WordOccurrences analyzer = new Ridley_WordOccurrences();

		//Compares two ArrayList objects. The first is testTop20, the ArrayList object from above.
		//The other is the ArrayList object returned by the main method of analyzer using a test file.
		//If the two objects are not equal, then the JUnit error will return the given string.
		assertEquals("Top 20 results not equal!", testTop20, analyzer.main("test.html"));
	}
}
