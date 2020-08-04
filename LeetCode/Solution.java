package TestRun; 

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
//        Scanner sc = new Scanner(new File("C:\\Users\\malva01\\IdeaProjects\\Learn\\src\\temp.txt"));
        ArrayList<Integer> ratingList = new ArrayList<Integer>();
        boolean first = true;
        int size = 0;
        while(sc.hasNextLine()) {
            if(first) {
                size = Integer.parseInt(sc.nextLine());
                first = false;
                continue;
            }
            String s = sc.nextLine();
            int num = Integer.parseInt(s);
            ratingList.add(num);
        }

        int candies[] = new int[size];
        for(int i=0;i<size;i++) candies[i] = 1;
        boolean dirty = true;

        while (dirty)
        {
            dirty = false;
            for(int i=0;i<size;i++)
            {
                if(i > 0 && ratingList.get(i-1) < ratingList.get(i) && candies[i] <= candies[i-1])
                {
                    candies[i] = candies[i-1] + 1;
                    dirty = true;
                }
                if(i < (size-1) && ratingList.get(i) > ratingList.get(i+1) && candies[i] <= candies[i+1] )
                {
                    candies[i] = candies[i+1] + 1;
                    dirty = true;
                }
            }
        }
        int sum = 0;
        for(int i=0;i<size;i++) {
            sum += candies[i];
        }

        System.out.println(sum);
    }
}