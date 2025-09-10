public class Progression {
    protected long first;
    protected long cur;
    
    public Progression() {
        cur = first = 0;
    }
    
    protected long firstValue() {
        return first;
    }
    
    protected long nextValue() {
        return cur++;
    }
    
    protected void printProgression() {
        System.out.println(first);
        System.out.println(cur);
    }
}
