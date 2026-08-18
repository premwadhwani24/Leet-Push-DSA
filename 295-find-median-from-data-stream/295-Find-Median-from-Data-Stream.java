class MedianFinder {

    PriorityQueue<Integer> left;   // Max Heap
    PriorityQueue<Integer> right;  // Min Heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        // Add to left first
        left.add(num);

        // Largest from left goes to right
        right.add(left.poll());

        // Keep left equal to or one bigger than right
        if (right.size() > left.size()) {
            left.add(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() > right.size()) {
            return left.peek();
        }

        return (left.peek() + right.peek()) / 2.0;
    }
}