package com.allianz.networking.thread;

public class ThreadMain {

	/**
	 * @param args
	 */
	
	  public static void main(String[] args)
	  {     
	    ThreadGroup tg = new ThreadGroup("Testgruppe");
	    Thread t1 = new SleepThread(tg, "t1");
	    Thread t2 = new SleepThread(tg, "t2");
	 
	    t1.start();
	    t2.start();
	 
	    Thread array[] = new Thread[tg.activeCount()];
	 
	    tg.enumerate(array);
	 
	    for(Thread t: array)
	    {
	      System.out.println(t.getName() + " ist Gruppenmitglied von " + tg.getName() );
	    }
	  }

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		System.out.println("Calling Sleep");
//		SleepThread st = new SleepThread();
//		st.start();
//		System.out.println("Ending Sleep");
//	}

}
