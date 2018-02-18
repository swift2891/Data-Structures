package testerClass;

import linkedlist.LL;

/**
 *
 * @author Vignesh
 */
public class testLL {    
    public static void main(String[] args){
        LL list = new LL();
        list.add(5);
        list.next = new LL();
        list.next.value = 6;
        System.out.println(list.value+" "+list.next.value);
    }
}
