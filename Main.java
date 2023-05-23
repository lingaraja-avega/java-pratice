package com.avega.training.nio;

public class Main extends Thread {
	public static int amount = 0;

	public static void main(String[] args) {

//		Path original = Paths.get("D:\\Test\\Second\\text.txt");
//		Path destination = Paths.get("D:\\Test\\text.txt");
//		try {
//			Files.move(original, destination, StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}

//		Create Folder/Director
//		Path path = Paths.get("D:\\Test\\New Folder");
//		Path newPath = Files.createDirectory(path);
//		System.out.println(newPath);

//		Create File
//		Path path = Paths.get("D:\\Test\\New Folder\\text.txt");
//		Path newPath = Files.createFile(path);
//		System.out.println(newPath);

//		Read File
//		Path path = Paths.get("D:\\Test\\New Folder\\text.txt");
//		List<String> para = Files.readAllLines(path);
//		para.forEach(line -> System.out.println(line));

//		Write File
//		Path path = Paths.get("D:\\Test\\New Folder\\text.txt");
//		Files.write(path, "I am Lingesh from Bhavani".getBytes());

//		Copy File
//		Path source = Paths.get("D:\\Test\\New Folder\\text.txt");
//		Path destination = Paths.get("D:\\Test\\text12.txt");
//		Path path = Files.copy(source, destination);
//		System.out.println(path);

//		Move File
//		Path source = Paths.get("D:\\Test\\New Folder\\text.txt");
//		Path destination = Paths.get("D:\\Test\\text.txt");
//		Path path = Files.move(source, destination);
//		System.out.println(path);

//		Append File
//		Path path = Paths.get("D:\\Test\\New Folder\\text.txt");
//		String sentence = "Hai, I am Lingesh";
//		for (int i = 0; i < 10; i++) {
//			Files.write(path, ("\n" + sentence + " " + i).getBytes(), StandardOpenOption.APPEND);
//		}
	}
}
