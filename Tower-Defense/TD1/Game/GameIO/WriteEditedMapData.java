package GameIO;

import java.io.BufferedWriter;
import java.io.FileWriter;

import GraphicsController.Graphics;

public class WriteEditedMapData {

	public WriteEditedMapData(String[][] data, String file){
		
		try{
			FileWriter fstream = new FileWriter("gameData\\" + file + ".txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			
			out.newLine();
			out.write("[Map]");
			out.newLine();
			
			
			for(int i = 0; i < 21; i++){
				for(int j = 0; j < 18; j++){
					if(data[i][j] == null)
						out.write("white ");
					else
						out.write(data[i][j] + " ");
				}
				out.newLine();
			}
			
			
			out.close();
			
		}catch (Exception e){e.printStackTrace();}
	}
}
