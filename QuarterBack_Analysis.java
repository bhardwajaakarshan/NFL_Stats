import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.List;
import java.io.*;

public class QuarterBack_Analysis {

	public static void main(String[] args) throws IOException {
		String csv_dest = "C:\\Users\\The Mamba\\Desktop\\output.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(csv_dest), "UTF-8"));
		} 
		catch (IOException e){
			System.out.println("File Not Found.");
			System.exit(0);
		}
		String line;
		ArrayList <QuarterBack> qbs = new ArrayList<QuarterBack>();
		while ((line = br.readLine()) != null){
			//System.out.println("New Play");
			String[] lineargs = line.split(",");
			String description = lineargs[14];
			QuarterBack curr = null;
			// Processing the play and adjusting appropriate fields
			if(description.contains("PASS") && !description.contains("TWO-POINT CONVERSION")){
				boolean flag = false;
				String[] name_info = description.split(" ");
				String name;
				if (description.contains("SHOTGUN") || description.contains("NO HUDDLE")){
					name = name_info[2];
				} else {
					name = name_info[1];
				}
				for (QuarterBack qb : qbs){
					if (qb.getName().equals(name)){
						curr = qb;
						flag = true;
					}
				}
				if (!flag){
					curr = new QuarterBack(name);
					qbs.add(curr);
				}
				//System.out.println("PASS");
				curr.setAttempts(curr.getAttempts() + 1);
				if(description.contains("INTERCEPTED")){
					curr.setInterceptions(curr.getInterceptions() + 1);
				} else {
					if(!description.contains("INCOMPLETE")){
						curr.setCompletions(curr.getCompletions() + 1);
						int i = description.indexOf("FOR ");
						String sub = description.substring(i);
						String[] in_yards = sub.split(" ");
						// When there is no gain
						if (in_yards[1].equals("NO")){
							curr.setYards(curr.getYards() + 0);
						} else {
							curr.setYards(curr.getYards() + Integer.parseInt(in_yards[1]));
						}
						if (lineargs[15].contains("TOUCHDOWN")){
							curr.setTouchdowns(curr.getTouchdowns() + 1);
						}
					}
				}
				System.out.println(curr.getName() + "," + curr.QBR() + "," + curr.getAttempts());//curr.getName() + " " + curr.QBR() + " " + curr.getCompletions() + " " + curr.getAttempts()+ " " + curr.getYards()+ " " + curr.getTouchdowns()+ " " + curr.getInterceptions());
			}
		}
	}
}

