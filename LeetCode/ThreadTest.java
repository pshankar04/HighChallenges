package Serials;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
 

public class ThreadTest implements Runnable{
	public static List<Integer> numberList = new LinkedList<Integer>(); 

	public static void main(String[] args) {
		ThreadTest th1 = new ThreadTest();
		ThreadTest th2 = new ThreadTest();
		Thread t1 = new Thread(th1);
		Thread t2 = new Thread(th2);
		t1.setName("insertThread");
		numberList = (List<Integer>)Collections.synchronizedList(numberList);
		t1.start();
		
		try{
		t1.join();
		for(Integer i : numberList){
			System.out.println(i);
		}
		System.out.println("_________________");
		t2.start();
		t2.join();
		}catch(InterruptedException ie){
			ie.printStackTrace();
		}
		
		for(Integer i : numberList){
			System.out.println(i);
		}
	}

	public void run(){
		if(Thread.currentThread().getName().equals("insertThread")){
			for(int i = 1 ; i <= 10 ; i++){
				numberList.add(i * 10);
			}
		}else{
			for(int i = 1 ; i <= 5 ; i++){
				numberList.remove(i);
			}
		}
	}
}
