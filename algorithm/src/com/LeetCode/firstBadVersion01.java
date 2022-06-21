package com.LeetCode;

class firstBadVersion01 extends VersonControl{
    public static void main(String[] args) {
        firstBadVersion01 firstBadVersion01 = new firstBadVersion01();
        int i = firstBadVersion01.firstBadVersion(2126753390);
        System.out.println(i);
    }
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        while (start <= end){
            int mid = start + (end - start) / 2;
            if(!isBadVersion(mid - 1) && isBadVersion(mid)){
                return mid;
            }
            if(isBadVersion(mid)){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 1;
    }
}



class VersonControl{
    boolean isBadVersion(int version){
        if(version >= 1702766719){
            return true;
        }
        return false;
    }
}