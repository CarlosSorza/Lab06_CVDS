package edu.eci.cvds.servlet;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.swing.JOptionPane;
import java.lang.Math.*;
import java.util.ArrayList;


@ManagedBean(name = "CalculadoraBean")
@ApplicationScoped
public class BeanCalculator{
    private ArrayList<Double> num_to_operate;
    private double mode;
    private double mean;
    private double variance;
    private double standar;
    private int length;
    
    public void setMode(double mode){
        this.mode = mode;
    }

    public void setMean(double mean){
        this.mean = mean;
    }

    public void setVariance(double variance){
        this.variance = variance;
    }

    public void setStandarDeviation(double standar){
        this.standar = standar;
    }
    
    public void restart(){
        num_to_operate = new ArrayList<Double>();
        num_to_operate.add(0.0);
        calculate();
    }

    public double getMode(){
        return mode;
    }

    public double getMean(){
        return mean;
    }

    public double getVariance(){
        return variance;
    }

    public double getStandarDeviation(){
        return standar;
    }

    public int getLength(){
        return length;
    }

    public void setNumbers(ArrayList<Double> numbers) {
        this.num_to_operate = numbers;
        setLength(numbers.size());
    }
    
    public void setLength(int length) {
        this.length = length;
    }

    public void calculate(){
        setNumbers(num_to_operate);
        calculateMean(num_to_operate);
    	calculateMode(num_to_operate);
    	calculateVariance(num_to_operate);
    	calculateStandardDeviation(num_to_operate);
    }

    public void calculate(String  number_list){
        try{ 
            num_to_operate = new ArrayList<Double>();
            String[] array = number_list.split(",");

            for (String string: array){
                num_to_operate.add(Double.parseDouble(string));
            }
            
            calculate();
                    
        }
        catch (Exception e){
            restart();
        }
    }
    
    public void calculateMean(ArrayList<Double>  number_list){
        mean = 0;
        for (Double num_to_operate:  number_list){
            mean = mean + num_to_operate;
        }
        mean = mean / length;
    }
    
    public double calculateVariance(ArrayList<Double>  number_list){
        double a = 0;
        variance = 0;
        for (Double num_to_operate:  number_list){
            a= a + Math.pow(mean -num_to_operate, 2f);
        }
        variance = a /(length-1);
        return variance;
    }
    
    public void calculateMode(ArrayList<Double>  number_list){
        int index = -1,count;
        mode = 0;
        for (int i =0; i<length ; i++){
            double a = num_to_operate.get(i);
            count =0;
            for (int j=i ; j<length; j++){
                if ( number_list.get(j) == a){
                    count++;
                }
            }
            if (count > index){
                mode = a;
                index = count;
            }
        }
    }
    
   
    
    public void calculateStandardDeviation(ArrayList<Double>  number_list){
        standar = Math.sqrt(calculateVariance(number_list));
    }
    
    
    
    
    
    
    
}