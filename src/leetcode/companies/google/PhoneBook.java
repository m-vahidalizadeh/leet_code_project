package leetcode.companies.google;

import java.util.HashSet;
import java.util.Set;

public class PhoneBook {

    Set<Integer> availableEntries = new HashSet<>();

    /*
    get: Provide a number which is not assigned to anyone.
    check: Check if a number is available or not.
    release: Recycle or release a number.
     */

    public static void main(String[] args) {
        /*
// Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
PhoneDirectory directory = new PhoneDirectory(3);
// It can return any available phone number. Here we assume it returns 0.
directory.get();
// Assume it returns 1.
directory.get();
// The number 2 is available, so return true.
directory.check(2);
// It returns 2, the only number that is left.
directory.get();
// The number 2 is no longer available, so return false.
directory.check(2);
// Release number 2 back to the pool.
directory.release(2);
// Number 2 is available again, return true.
directory.check(2);
         */
        PhoneBook directory = new PhoneBook(3);
// It can return any available phone number. Here we assume it returns 0.
        System.out.println(directory.get());
// Assume it returns 1.
        System.out.println(directory.get());
// The number 2 is available, so return true.
        System.out.println(directory.check(2));
// It returns 2, the only number that is left.
        System.out.println(directory.get());
// The number 2 is no longer available, so return false.
        System.out.println(directory.check(2));
// Release number 2 back to the pool.
        directory.release(2);
// Number 2 is available again, return true.
        System.out.println(directory.check(2));
    }

    /**
     * Initialize your data structure here
     *
     * @param maxNumbers - The maximum numbers that can be stored in the phone directory.
     */
    public PhoneBook(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            availableEntries.add(i);
        }
    }

    /**
     * Provide a number which is not assigned to anyone.
     *
     * @return - Return an available number. Return -1 if none is available.
     */
    public int get() {
        if (availableEntries.isEmpty()) {
            return -1;
        }
        int availableEntry = availableEntries.stream().findFirst().get();
        availableEntries.remove(availableEntry);
        return availableEntry;
    }

    /**
     * Check if a number is available or not.
     */
    public boolean check(int number) {
        return availableEntries.contains(number);
    }

    /**
     * Recycle or release a number.
     */
    public void release(int number) {
        availableEntries.add(number);
    }

}
