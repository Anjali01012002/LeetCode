class ProductOfNumbers {

    private List<Integer> prefixProducts;
    public ProductOfNumbers() {
        prefixProducts= new ArrayList<>();
        prefixProducts.add(1);
    }
    
    public void add(int num) {
        if(num==0){
            prefixProducts.clear();
            prefixProducts.add(1);
        }else{
           int lastProducts=prefixProducts.get(prefixProducts.size()-1);
           prefixProducts.add(lastProducts*num);
        }
    }
    
    public int getProduct(int k) {
        int size=prefixProducts.size();
        if(k>=size){
            return 0;
        }
        return prefixProducts.get(size - 1) / prefixProducts.get(size - 1 - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */