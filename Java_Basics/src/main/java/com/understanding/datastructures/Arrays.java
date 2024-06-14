package com.understanding.datastructures;

public class Arrays {

    public void defineArray(){
        /*
            For defining a 1 Dimensional array in Java we need to follow the below syntax.
            Datatype [] variableName = new DataType[]
         */
        int size = 5;

        //declare an array of primitive int type
        int[] primitiveIntArray = new int[size];

        //declare an Derived
        Integer[] derivedIntArray = new Integer[size];

       //Let us look at the methods available on primitive type  array.
        System.out.println(primitiveIntArray.length);


    }

}
