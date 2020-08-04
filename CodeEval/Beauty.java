package CodeEval;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Collections;
public class Beauty {
	

	 
	  private static ArrayList < Integer > integers;
	    private static File f=new File("/Users/puneethshankar/Desktop/Solution.txt");
	    public static void main(String[] args) throws Exception {
	        FileReader fr = new FileReader("/Users/puneethshankar/Desktop/BeautifulStrings.txt");
	        LineNumberReader lnr = new LineNumberReader(fr);
	        int t = Integer.parseInt(lnr.readLine().trim());
	        FileWriter fw=new FileWriter(f);
	        for (int i = 0; i < t; i++) {
	           int sum= getMax(lnr.readLine().trim());
	        if(i<t-1)
	        fw.write("Case #" + (i+1) + ": " + sum+"\n");
	       else 
	           fw.write("Case #" + (i+1) + ": " + sum);
	       fw.flush();
	        
	        }
		}
		

	    private static int getMax(String string)throws Exception {
	        integers = new ArrayList < Integer > ();
	        for (int i = 65, j = 97; i <= 90 && j <= 123; i++, j++) {
	            String s = string.replaceAll("[^" + (char) i + (char) j + "]", "");
	            s.trim();
	            integers.add(s.length());
	        }
	        int sum = 0;
	        Collections.sort(integers);
	        for (int i = integers.size() - 1, j = 26; i >= 0 && j >= 1; --i, --j) {
	            sum += integers.get(i) * j;
				}
	      return sum;
	    }
	}



