class NumberContainers {

     private Map<Integer, Integer> idxToNum;
    private Map<Integer, TreeSet<Integer>> numToIdx;

    public NumberContainers() {
        idxToNum = new HashMap<>();
        numToIdx = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if(idxToNum.containsKey(index)) { // O(1)
            int prevNum = idxToNum.get(index);
            numToIdx.get(prevNum).remove(index); // O(log(n))
            if(numToIdx.get(prevNum).isEmpty()) {
                numToIdx.remove(prevNum); // O(1)
            }
        }

        idxToNum.put(index, number);
        numToIdx.putIfAbsent(number, new TreeSet<>());
        numToIdx.get(number).add(index); // O(log(n))
    }
    
    public int find(int number) {
        if(numToIdx.containsKey(number)) { // O(1)
            return numToIdx.get(number).first(); // O(1)
        }
        return -1;
    }
}