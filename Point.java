package com.example.lab12.beans;

public record Point(double x, double y) {

        public double getY() {
            return y;
        }

        public double getX() {

            return x;
        }
}
