package HackerRank;

import java.text.DecimalFormat;
import java.util.Scanner;

public class CurrencyArbitrage {

	public static double totalUSD = 100000d;
	public static DecimalFormat df = new DecimalFormat("#.####");
	public static DecimalFormat df1 = new DecimalFormat("#");

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int total = Integer.parseInt(input.nextLine());
		for(int i = 0 ; i < total ; i++){
			findArbitrage(input.nextLine());
		}
		input.close();
	}


	public static void findArbitrage(String priceQuotes){

		double initial_usd = 0d , mean_gbp = 0d , final_usd = 0d;
		double usd_euro = Double.parseDouble(df.format(Double.parseDouble(priceQuotes.split(" ")[0])));
		double euro_gbp = Double.parseDouble(df.format(Double.parseDouble(priceQuotes.split(" ")[1])));
		double gbp_usd  =  Double.parseDouble(df.format(Double.parseDouble(priceQuotes.split(" ")[2])));

		initial_usd = Double.parseDouble(df.format(((1/usd_euro) * totalUSD)));
		mean_gbp = Double.parseDouble(df.format(((1/euro_gbp) * initial_usd )));
		final_usd = Double.parseDouble(df.format(((1/gbp_usd) * mean_gbp )));
		final_usd = final_usd - totalUSD;
		final_usd = Double.parseDouble(df1.format(Math.floor(final_usd)));
		if(final_usd > 0d){
			System.out.println(Math.round(final_usd));
		}else{
			System.out.println("0");
		}


	}
}
