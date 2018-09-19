/* Muhammad Akmal / 1301164337 / IF 40-03 */

import java.lang.Math;

public class TugasSA {
	
	/* Initialize */
	static double x1c = 10;
	static double x2c = 10;
	static double current = expression(x1c,x2c);
	static double x1b = x1c;
	static double x2b = x2c;
	static double upper = 0.5;
	static double lower = -0.5;
	static double best = expression(x1b,x2b);
	static int t = 1000;
	
    public static void main(String[] args) {
		double x1n,x2n;
		while(t > 0){
			x1n = generate(x1c);
			x2n = generate(x2c);
			compare(x1n,x2n);
			t--;
		}
		System.out.println("X1 = " + x1b);
		System.out.println("X2 = " + x2b);
		System.out.println("F(X1,X2) = " + best);
    }
	
	/* The Math Function */
	public static double expression(double x1, double x2){
		double g = Math.pow(x1, 2) + Math.pow(x2, 2);
		double a = (double) Math.sqrt(g);
		double h = 1 - (a / Math.PI);
		double b = (double) Math.abs(h);
		double c = (double) Math.exp(b);
		double d = Math.sin(Math.toRadians(x1));
		double e = Math.cos(Math.toRadians(x2));
		double i = c * d * e;
		double f = Math.abs(i);
		return (f * -1);
	}
	
	/* Best Function */
	public static void compare(double x1, double x2){
		double test = expression(x1,x2);
		double delta = test - current;
		if(delta < 0){
			x1c = x1;
			x2c = x2;
			current = test;
			if(test < best){
				x1b = x1;
				x2b = x2;
				best = test;
			}
		}else{
			double a = -1 * delta;
			double b = a / t;
			double p = Math.exp(b);
			double r = Math.random();
			if(r < p){
				x1c = x1;
				x2c = x2;
				current = test;
			}
		}
	}
	
	/* Generate Function */
	public static double generate(double x){
		double r, n;
		n = 0;
		boolean stop = false;
		while(stop != true){
			r = (Math.random() * (upper - lower)) + lower;
			n = r + x;
			if(n <= 10 && n >= -10){
				stop = true;
			}
		}
		return n;
	}

}