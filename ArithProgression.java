public class ArithProgression extends Progression {
    protected long inc;
    
    public ArithProgression() {
        this(1);
    }
    
    public ArithProgression(long inc) {
        this.inc = inc;
    }
    
    protected long nextValue() {
        return cur+=inc;
    }
}
