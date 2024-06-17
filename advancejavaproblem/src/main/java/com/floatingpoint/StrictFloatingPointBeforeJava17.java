package com.floatingpoint;

/**
 * By default, the floating-point computations in Java are platform-dependent.
 * And so, the floating-point outcome’s precision depends on the hardware in-use.
 * Before Java17 When we declare an interface or a class with strictfp,
 * all of its member methods and other nested types inherit its behavior.
 *
 * with JDK17 no need to use strictfp keyword anymore.
 * Default floating-point semantics have been changed to consistently strict
 *
 */
public strictfp class StrictFloatingPointBeforeJava17
{

    public static void main(String[] args)
    {
        double x = 1.0e+16;
        double y = 1.0e-15;
        System.out.println("Result with strictfp: " + multiply(x, y));
    }

    private static double multiply(double numberOne, double numberTwo)
    {
        return numberOne * numberTwo;
    }

}
