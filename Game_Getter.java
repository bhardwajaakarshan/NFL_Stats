import java.util.Scanner;
import java.io.*;

public class Game_Getter {

	public static void main(String[] args) throws IOException{
		Scanner kb = new Scanner(System.in);
		
		//CSV Destination
		String csv_dest = "C:\\Users\\The Mamba\\Desktop\\pbp-2014.csv";
		String output = "C:\\Users\\The Mamba\\Desktop\\output.txt";
		BufferedReader br = null;
		BufferedWriter bw = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(csv_dest), "UTF-8"));
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found.");
			System.exit(0);
		}
		int desired_game_id = kb.nextInt();
		String line;
		try {
			// Eliminate the first line of the CSV file (preventing illegal cast exeception
			br.readLine();
			while ((line = br.readLine())!= null){
				String[] lineargs = line.split(",");
				if (Integer.parseInt(lineargs[0]) == desired_game_id){
				bw.write(line);
				bw.newLine();
				bw.flush();
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.close();
		bw.close();
	}
}
