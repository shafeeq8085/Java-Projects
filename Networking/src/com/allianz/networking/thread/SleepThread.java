package com.allianz.networking.thread;

import java.util.Date;



public class SleepThread extends Thread {
	
	 public SleepThread(ThreadGroup tg, String name) {
		// TODO Auto-generated constructor stub
		 super(tg, name);

	}

	public void run()
	  {
		Date date = new Date(); 
		System.out.println("Start" + date.toString());
	    for (int i = 0; i<=10; i++)
	    {
	      System.out.println(getName() + ": " + i);

	     try
	      {
	        sleep(5000);
	      }
	      catch(InterruptedException ie)
	      {
	        // ...
	      }
	    }
	    System.out.println("End" + date.toString());
	  }
//	
//	public void Run(){
//		Date date = new Date();
//		System.out.println("Start" + date.toString());
//		for(int i=0;i<10;i++){
//			System.out.println(getName() + ": " + i);
//		}
//		
//		try {
//			sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("End" + date.toString());
//	}
//	
}


