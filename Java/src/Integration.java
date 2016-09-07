/*
 * To perform Numerical Integration using equation "y=1+x+sin(2*x)"
 *
 * @author Uttam Kumar
 */

import java.util.Scanner;

public class Integration {
    
    static int n = 0;
    public static Integration one = new Integration();
    
    public double findCurve(double x){
        return (1+x+Math.sin(2*x));
    }
    
    public void rectangularDivision(int xmin,int xmax){
        double dx = (xmax-xmin);
        dx/=n;
        double total_area = 0;
        for(double x=xmin; x<=(xmax-dx) ; x+=dx){
            total_area += findCurve(x);
        }
        total_area*=dx;
        System.out.println("The area under the curve is "+ total_area);
    }
    
    public void trapezoidDivison(int xmin, int xmax){
        double dx = (xmax-xmin);
        dx/=n;
        double total_area = 0;
        for(double x = xmin; x<=xmax ; x+=dx){
            total_area += findCurve(x);
        }
        total_area = total_area*2 - findCurve(xmin) - findCurve(xmax);
        total_area *= dx/2;
        
        System.out.println("The area under the curve using trapeziod divisions is "+ total_area);
    }
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the xmin and xmax values");
        int xmin = Integer.parseInt(scan.nextLine());
        int xmax = Integer.parseInt(scan.nextLine());
        System.out.println("Enter the number of divisions");
        n = Integer.parseInt(scan.nextLine());
        one.rectangularDivision(xmin,xmax);
        one.trapezoidDivison(xmin, xmax);
    }
}
