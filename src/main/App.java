package main;

public class App {

	public static void main(String[] args) throws Exception {

		Engine eng = new Engine();

		eng.changeToJson("src/data/hello_unicode.txt", "src/data/hello.txt");

		System.out.println("Done !!!");

	}

}
