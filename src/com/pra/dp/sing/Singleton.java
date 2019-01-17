package com.pra.dp.sing;

public class Singleton {
	

	    private static volatile Singleton instance;
		private int i = 1;
	    
	    private Singleton(){
	    	System.out.println("The Instance is created " + i++  );
	    }
	    
	    public static Singleton getInstance(){
	        if(instance == null){
	        	synchronized(Singleton.class) {
	        		instance = new Singleton();
	        	}
	        }
	        return instance;
	    }
	    

}
