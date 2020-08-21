class MedianFinder {
         
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->{
            return b - a;
        });
        
        public MedianFinder() {
             
        }
        
        public void addNum(int num) {
            if( maxHeap.size() == 0 || num <= maxHeap.peek())  maxHeap.add(num);
            else minHeap.add(num);

            if(maxHeap.size() > minHeap.size() + 1){
                minHeap.add(maxHeap.peek());
                maxHeap.remove();
            }else if(maxHeap.size() < minHeap.size()){
                maxHeap.add(minHeap.peek());
                minHeap.remove();
            }  
        }
        
        public double findMedian() {
            if(maxHeap.size() == minHeap.size() && maxHeap.size() != 0) return (maxHeap.peek() + minHeap.peek()) / 2.0;
            else if(maxHeap.size() != minHeap.size()) return maxHeap.peek();
            return -1;
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */