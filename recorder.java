import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class recorder {
    private static String streamURL = "https://wxpnhi.xpn.org/xpnhi-nopreroll";
    private static String outputPath = "C:/Users/Paktric/Desktop/output_" + System.currentTimeMillis() + ".mp3";

    public static void main(String[] args) {
        try{
            URLConnection conn = new URL(streamURL).openConnection();
            InputStream is = conn.getInputStream();
            OutputStream outstream = new FileOutputStream(new File(outputPath));
            byte[] buffer = new byte[4096];
            int len = 0;

            LocalDateTime start = LocalDateTime.of(2022, Month.AUGUST, 19, 23, 0);
            LocalDateTime   end = LocalDateTime.of(2022, Month.AUGUST, 20, 2, 0);

            System.out.println();
            System.out.println("   Current time: " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
            System.out.println("Scheduled Start: " + start);
            System.out.println("  Scheduled End: " + end);

            // Record within the start/end window
            while (end.isAfter(LocalDateTime.now())) {
                while ((len = is.read(buffer)) > 0 && start.isBefore(LocalDateTime.now()) && end.isAfter(LocalDateTime.now())) {
                    outstream.write(buffer, 0, len);
                }
            }
            outstream.close();
            System.out.println("\nRecording complete: " + outputPath);

        }
        catch(Exception e){
            System.out.print("Exception thrown: " + e);
        }
    }
}
