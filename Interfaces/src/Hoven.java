
public class Hoven implements Machine{
	private int noiseLevel;
    public Hoven(int db)
    {
        noiseLevel = db;
    }
    public void Play()
    {
        System.out.printf("Making some noise at %d dB!", noiseLevel);
    }
    public int getNoiseLevel() {
    	return noiseLevel;
    }
    public void setNoiseLevel(int n) {
    	noiseLevel = n;
    }
    public void Upgrade(int inc) {
    	noiseLevel+=inc;
    }
}
