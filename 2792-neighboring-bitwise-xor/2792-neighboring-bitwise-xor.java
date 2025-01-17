class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n=derived.length;

        if(isValidOriginal(derived,0,n)){
            return true;
        }
        return isValidOriginal(derived,1,n);

    }

    private boolean isValidOriginal(int[] derived, int firstElement, int n){
        int[] original = new int[n];
        original[0]=firstElement;

        for(int i=1;i<n;i++){
            original[i]=original[i-1]^derived[i-1];
        }

        return (original[n-1] ^ original[0])== derived[n-1];
    }
}