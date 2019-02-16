/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Source {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        stack = sort(stack);
        deleteFirstHalf(stack);

        Queue<Integer> queue = new LinkedList<Integer>();
        n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
        queue = sort(queue);
        deleteSecondHalf(queue);
        
    }

    // Method to sort the elements of the stack in ascending order
    static Stack<Integer> sort(Stack<Integer> stack) {
        // Write your code here
        stack = mergeSort(stack);
        stack = reverse(stack);
        System.out.println(stack);
        return stack;
    }

    // Method to sort the queue
    static Queue<Integer> sort(Queue<Integer> queue) {
        // Write your code here
        queue = mergeSort(queue);
        System.out.println(queue);
        return queue;
    }

    public static Queue<Integer> reverseQueue(Queue<Integer> q) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!q.isEmpty()) {
            temp.push(q.remove());
        }
        while(!temp.empty()) {
            q.add(temp.pop());
        }
        return q;
    }

    public static Stack<Integer> reverse(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<Integer>();
        while(!stack.empty()) {
            temp.push(stack.pop());
        }
        return temp;
    }

    public static Stack<Integer> merge(Stack<Integer> lStack, Stack<Integer> rStack) {
        Stack<Integer> stack = new Stack<Integer>();
         
        while(!lStack.empty() && !rStack.empty()) 
        { 
            if(lStack.peek() <= rStack.peek()) 
            { 
                stack.push(lStack.pop());
            } 
            else
            { 
                stack.push(rStack.pop());
            }
        }
        // Copy remaining elements of lStack if any
        while(!lStack.empty()) { 
            stack.push(lStack.pop()); 
        } 
  
        // Copy remaining elements of rStack if any 
        while (!rStack.empty()) { 
            stack.push(rStack.pop()); 
        }
        stack = reverse(stack);
        return stack;
    } 

    public static Queue<Integer> merge(Queue<Integer> lQueue, Queue<Integer> rQueue) {
        Queue<Integer> queue = new LinkedList<Integer>();
         
        while(!lQueue.isEmpty() && !rQueue.isEmpty()) 
        { 
            if(lQueue.peek() <= rQueue.peek()) 
            { 
                queue.add(lQueue.remove());
            } 
            else
            { 
                queue.add(rQueue.remove());
            }
        }
        // Copy remaining elements of lStack if any
        while(!lQueue.isEmpty()) { 
            queue.add(lQueue.remove()); 
        } 
  
        // Copy remaining elements of rStack if any 
        while (!rQueue.isEmpty()) { 
            queue.add(rQueue.remove()); 
        }

        return queue;
    }

    public static Stack<Integer> mergeSort(Stack<Integer> stack) { 
        if (stack.size() > 1) 
        { 
            // Find the middle point 
            int m = stack.size() / 2; 
  
            Stack<Integer> rStack = new Stack<Integer>();
            for(int i = 0; i < m; i++) {
                rStack.push(stack.pop());
            }
            Stack<Integer> lStack = stack;
            // Sort first and second halves
            lStack = mergeSort(lStack); 
            rStack = mergeSort(rStack); 
  
            // Merge the sorted halves 
            stack = merge(lStack, rStack);
            
        }

        return stack;
    } 

    public static Queue<Integer> mergeSort(Queue<Integer> queue) { 
        if (queue.size() > 1) 
        { 
            // Find the middle point 
            int m = queue.size() / 2; 
  
            Queue<Integer> rQueue = new LinkedList<Integer>();
            for(int i = 0; i < m; i++) {
                rQueue.add(queue.remove());
            }
            Queue<Integer> lQueue = queue;
            // Sort first and second halves
            lQueue = mergeSort(lQueue); 
            rQueue = mergeSort(rQueue); 
  
            // Merge the sorted halves 
            queue = merge(lQueue, rQueue);
            
        }

        return queue;
    }

    // Method to reverse the last half of the elements from the bottom of the stack
    static void reverseSecondHalf(Stack<Integer> stack) {
        // Write your code here
        int half = stack.size() / 2;

        System.out.println(half);
        Stack<Integer> hStack = new Stack<Integer>();
        for(int i = 0; i < half; i++) {
            hStack.push(stack.pop());
        }

        Stack<Integer> tStack = new Stack<Integer>();
        while(!hStack.empty()) {
            tStack.push(hStack.pop());
        }
        
        while(!tStack.empty()) {
            stack.push(tStack.pop());
        }
        System.out.println(stack);
    }

    // Method to delete the first half of the elements from the bottom of the stackand print the remaining elements
    static void deleteFirstHalf(Stack<Integer> stack) {
        // Write your code here
        int half;
        if(stack.size() % 2 == 0) {
            half = stack.size() / 2;
        } else {
            half = (stack.size() / 2) + 1;
        }

        Stack<Integer> hStack = new Stack<Integer>();
        for(int i = 0; i < half; i++) {
            hStack.push(stack.pop());
        }
        System.out.println(reverse(hStack));
    }

    // Method to delete the second half of the elements and print the remaining elements
    static void deleteSecondHalf(Queue<Integer> queue) {
        // Write your code hereint half;
        int half = queue.size() / 2;

        for(int i = queue.size(); i > 0; i--) {
            if(i > half) {
                queue.add(queue.remove());
            } else {
                queue.remove();
            }
        }
        System.out.println(queue);
    }
}
