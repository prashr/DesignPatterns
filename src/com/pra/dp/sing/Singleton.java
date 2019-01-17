package com.pra.dp.sing;

public class Singleton {
	

	    private static volatile Singleton instance;
		private static  int i = 0;
		private int j = 0;
	    
	    private Singleton(){
	    	j = ++i;
	    	System.out.println("The Instance is created " + i  );
	    }
	    
	    public static Singleton getInstance(){
	        if(instance == null){
	        	synchronized(Singleton.class) {
	        		if(instance == null)
	        			instance = new Singleton();
	        	}
	        }
	        return instance;
	        
	    }
	    @Override
	    public String toString() {
			return "inst-" + j;
	    	
	    }
	    

}
