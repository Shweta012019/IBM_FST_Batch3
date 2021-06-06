package Activities;

public class Activity1 {

	    public static void main(String[] args) {
	        Car  hundai=new Car();
	        hundai.make = 2014;
	        hundai.color = "Black";
	        hundai.transmission = "Manual";
	    
	        //Using Car class method
	        hundai.displayCharacterstics();
	        hundai.accelerate();
	        hundai.brake();
	    }

	}

