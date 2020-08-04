package Serials;

class TestJoinMethod1 extends Thread{  
	 public void run(){  
	  for(int i=1;i<=5;i++){  
	   try{  
	    Thread.sleep(500);  
	   }catch(Exception e){System.out.println(e);}  
	  System.out.println(i+" "+Thread.currentThread());  
	  }  
	 }  
	public static void main(String args[]){  
	 TestJoinMethod1 t1=new TestJoinMethod1();  
	t1.start();
	}
}

 
