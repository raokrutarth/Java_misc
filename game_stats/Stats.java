import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Stats
{
	public static HashMap wins() throws IOException, FileNotFoundException

	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		String fileName = "lab14inputfile.txt";
		String line = null;


		FileReader fileReader =  new FileReader(fileName);
		BufferedReader br =  new BufferedReader(fileReader);

		while((line = br.readLine()) != null) 
		{
			String[] arrayLine = line.split(" ");
			if (arrayLine[0].equals("1"))
			{
				for (int i = 1; i < 6; i++)
				{
					if (!map.containsKey(arrayLine[i]))
					{
						map.put(arrayLine[i], 1);
					}
					else
					{
						int points = map.get(arrayLine[i]);
						map.put(arrayLine[i], points+1);
					}
				}
			}
			else if (arrayLine[0].equals("0"))
			{
				for (int i = 7; i < 12; i++)
				{
					if (!map.containsKey(arrayLine[i]))
					{
						map.put(arrayLine[i], 1);
					}
					else
					{
						int points = map.get(arrayLine[i]);
						map.put(arrayLine[i], points+1);
					}
				}

			}
		}  

		br.close();

		return (HashMap) map;
	}
	
	public static String winner() throws FileNotFoundException, IOException
	{
		HashMap hm = wins();
		int max = 0;		
		for ( Object points : hm.values())
		{
			int pointsNum = Integer.parseInt( points + "" );			
			if (  pointsNum > max)
			{
				max = pointsNum;
			}
		}
		String winner = "";
		for (Object name : hm.keySet())
		{
			if ( (int)hm.get(name) == max)
			{
				winner = name.toString();
			}
		}		
		return max + " points by " + winner;
		
	}

	public static void main(String[] args) throws IOException
	{
		System.out.println(winner());
	}
}



