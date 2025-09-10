public class FibonacciProgression extends Progression {
    protected long inc;
    
    public FibonacciProgression() {
        this(0,1);
    }
    
    public FibonacciProgression(long v1, long v2) {
        first = v1;
        prev = v2 - v1;
    }
    
    protected long nextValue() {
        temp prev;
        prev = cur;
        cur+=temp;
        return cur;
    }
}
