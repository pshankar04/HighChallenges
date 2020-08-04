package HackerRank;

public class PowerSet{
    String str = "1724";  
    public static void main(String []args){
       PowerSet ps = new PowerSet();
       for(int i = 0; i< ps.str.length();i++){  
           ps.formSubstring("",i);
       }
    }

    void formSubstring(String substr,int index)
    {
        String s = ""+str.charAt(index);  
        s = substr+s;  
        System.out.println(s);   

        for(int i=index+1;i<str.length();i++)
        	formSubstring(s,i);  

    }
}
