package main;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Engine {

	/**
	 * 
	 * @param path file path
	 * @return List containing each line of the file
	 * @throws Exception
	 */
	public List<String> readEachLine(String path) throws Exception {

		List<String> list = new ArrayList<String>();

		Path p = Paths.get(path);

		BufferedReader rd = Files.newBufferedReader(p);

		while (true) {
			String line = rd.readLine();
			if (line == null) {
				break;
			}
			list.add(line.toLowerCase());
		}

		return list;
	}

	/**
	 * 
	 * @param copyFrom file to copy values from
	 * @param writeTo  empty file to hold the result
	 * @throws Exception
	 */
	public void changeToJson(String copyFrom, String writeTo) throws Exception {

		// read the base file
		List<String> line = readEachLine(copyFrom);

		// open write permission to destination file
		FileWriter myWriter = new FileWriter(writeTo);

		// what to add to each line
		int no = 1;

		// add opening curly bracket
		myWriter.write("{" + "\r\n");

		for (String ln : line) {
			myWriter.write("\"" + no + "\"" + " : " + "\"" + ln + "\"," + "\r\n");
			no++;
		}

		// add closing curly bracket
		myWriter.write("{" + "\r\n");

		myWriter.close();
	}

}
