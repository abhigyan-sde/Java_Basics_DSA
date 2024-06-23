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

        //String array declaration
        String[] stringArr = new String[size];
    }

    public void printContentsOfAnArray(String[] arr){
        //Here we knew that the input array is of type String. So, we iterated from [1,length) of array
        //where length was exclusive because arrays are 0 indexed and then we printed out the elements.
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
        //Iteration method 2
        for(String element : arr){
            System.out.println(element);
        }
    }

    //Let's see how to print elements of a generic array
    //Here T refers the datatype which can be generic. Like it could be Integer, String, Object, etc
    public <T> void printElementsOfGenericArray(T[] arr){
        //Iteration method 1
        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }

        //Iteration method 2
        for(T element : arr){
            System.out.println(element);
        }
    }
}
