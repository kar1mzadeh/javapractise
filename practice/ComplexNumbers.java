package practice;

import java.util.Scanner;
import practice.Test;
class ComplexNumbers {
    double imaginary;
    double real;

    public ComplexNumbers(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public ComplexNumbers() {

    }
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ComplexNumbers other = (ComplexNumbers) obj;
        return Double.compare(other.imaginary, imaginary) == 0 && Double.compare(other.real, real) == 0;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    void magnitude() {
        System.out.println("Real part: " + real + ", Imaginary part: " + imaginary);
    }
}
