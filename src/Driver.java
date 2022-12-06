import java.io.FileNotFoundException;

public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        final long startTime = System.nanoTime();
        SignalPacket packet = new SignalPacket();
        packet.readFile();
        System.out.println(packet.countToStartOfPacket(14));
        final long duration = System.nanoTime() - startTime;
        System.out.println(duration/1000000.0);
    }
}
