package HackerRank;

public class ReverseStr {

public static void print(char a[], int n, int ind){

for (int i = ind; i < n + ind; i++)
	System.out.print(a[(i % n)] + " ");
}


public static void main(String argc[]){
	int k[] = new int[5];
	System.out.println(k[0]);
char[] a = new char[]{ 'F', 'L', 'A', 'M', 'E', 'S' };
int n = 6;
for(int i = 0 ; i < n ; i++){
print(a, n, 5);
n--;
System.out.println("----------");
}

}

}
