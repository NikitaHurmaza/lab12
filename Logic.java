package com.example.lab12.beans;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
@SessionScope
public class Logic {
    private List<Point> points;
    double eps = 1.0E-4;
    public void fillPoints(double a,double begin, double end, double step){
        points= new ArrayList<Point>();
        int n = (int) Math.round(((end-begin)/step) +1);
        for( int i=0; i<n;i++){
            double x = begin+i * step;
            double y =f(x,a);
            points.add(new Point(x,y));
        }
    }
    public double f(double x,double a){
        if (x < 1.7 - this.eps){
            return 3.14 * (x*x) - 7.0 / (x * x);
        } else if (Math.abs(x - 1.7) < this.eps) {
            return a * Math.pow(x, 3.0) + 7.0 * Math.sqrt(x);
        } else {
            return Math.log10(x + 7.0 * Math.sqrt(x));
        }
    }
    public double findMaxY() {
        double maxY = Double.NEGATIVE_INFINITY;
        for (Point p : points) {
            if (p.getY() > maxY) {
                maxY = p.getY();
            }
        }
        return maxY;
    }
    public int findMaxYIndex() {
        double maxY = Double.NEGATIVE_INFINITY;
        int maxIndex = -1;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.getY() > maxY) {
                maxY = p.getY();
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public double findMaxX() {
        for (Point p : points) {
            if (p.getY() ==  findMaxY()) {
                return p.getX();
            }
        }
        return Double.NaN;
    }
    public double findMinY() {
        double minY = 0;
        for (Point p : points) {
            if (p.getY() < minY) {
                minY = p.getY();
            }
        }
        return minY;
    }
    public int findMinYIndex() {
        double minY = 0;
        int minIndex = -1;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (p.getY() < minY) {
                minY = p.getY();
                minIndex = i;
            }
        }
        return minIndex;
    }
    public double findMinX() {
        for (Point p : points) {
            if (p.getY() ==  findMinY()) {
                return p.getX();
            }
        }
        return Double.NaN;
    }
    public double sum() {
        double Sum = 0.0;
        for (Point p : points) {
            Sum += p.getY();
        }
        return Sum;
    }
    public double average() {
        double avar = sum();
        avar /= points.size();
        return avar;
    }
}