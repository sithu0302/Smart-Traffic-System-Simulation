import java.util.ArrayList;

public class MaxHeap{
    ArrayList<EmergencyInterSection> heap;

    public MaxHeap(){
        heap= new ArrayList<>();
    }

    public void insert(EmergencyInterSection ei) {
        heap.add(ei);
        heapifyUp(heap.size() - 1);
    }

    public EmergencyInterSection extractMax() {
        if (heap.isEmpty()) return null;

        EmergencyInterSection max = heap.get(0);
        EmergencyInterSection last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {
            heap.set(0, last);
            heapifyDown(0);
        }

        return max;
    }

   
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index).priority > heap.get(parent(index)).priority) {
            swap(index, parent(index));
            index = parent(index);
        }
    }


    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heap.size() && heap.get(left).priority > heap.get(largest).priority)
            largest = left;
        if (right < heap.size() && heap.get(right).priority > heap.get(largest).priority)
            largest = right;

        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    private void swap(int i, int j) {
        EmergencyInterSection temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void displayHeap() {
        for (EmergencyInterSection ei : heap) {
            System.out.println(ei);
        }
    }
}