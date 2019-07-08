package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};

        Heap h = new Heap();
        h.MakeHeap(arr, 3); //max 17
        //System.out.println(h.GetMax()); //max 15
        //System.out.println(h.GetMax()); //max 13

        System.out.println("add 7 " + h.Add(7));
        System.out.println("add 16 " + h.Add(16));
        System.out.println("add 11 " + h.Add(11));
        System.out.println("add 14 " + h.Add(14));

        System.out.println("add 23 " + h.Add(23));

        Heap p = new Heap();
        int[] a = {1};
        p.MakeHeap(a, 3);
        System.out.println(p.GetMax());

        for (int i = 2; i < 16; i++) {
            System.out.println(i + " " +p.Add(i));
        }
        System.out.println(p.Add(23));
        System.out.println();
    }
}
