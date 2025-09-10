public class GeomProgression extends Progression {
    protected long base;
    
    public GeomProgression() {
        this(2);
    }
    
    public GeomProgression(long base) {
        this.base = base;
        first = 1;
        cur = first;
    }
    
    protected long nextValue() {
        return cur*=base;
    }
}
