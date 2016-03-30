package com.skyscanner.browsegrid.app;

import com.skyscanner.browsegrid.service.SkyScnSchedService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello User!" );
        
//        if(args.length==0){
//        	System.out.println("Please enter an Time Interval for the scheduler as an argument");
//        }else{
        	try{
//        	Long schdIntrv = Long.parseLong(args[0]);
//        	SkyScnSchedService service = new SkyScnSchedService(schdIntrv);
        	SkyScnSchedService service = new SkyScnSchedService(10000l);
        	service.start();
        	}catch(NumberFormatException e){
        		System.out.println("Please Enter a Valid interval in milliseconds");
//        	}
        }
    }
}
