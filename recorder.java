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
    public static void main(String[] args) {
        try{
            // User editable variables
            String streamURL = "https://wxpnhi.xpn.org/xpnhi-nopreroll";
            String saveDirectory = "C:/Users/Paktric/Desktop/";
            String radioProgramName = "IndieRockHP";
            LocalDateTime startTime = LocalDateTime.of(2022, Month.AUGUST, 23, 20, 34);
            int recordingDuration = 0;

            // Program variables
            LocalDateTime endTime = startTime.plusHours(recordingDuration).plusMinutes(1);
            String recordingDate = startTime.toLocalDate().toString();
            String outputPath = saveDirectory + radioProgramName + "_" + recordingDate + ".mp3";

            // I/O variables
            URLConnection conn = new URL(streamURL).openConnection();
            InputStream inStream = conn.getInputStream();
            OutputStream outStream = new FileOutputStream(new File(outputPath));
            byte[] buffer = new byte[4096];
            int len = 0;

            ///////////////////////////////////////////////////////////////////////////////////////

            System.out.println();
            System.out.println("   Current time: " + LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES));
            System.out.println("Scheduled Start: " + startTime);
            System.out.println("  Scheduled End: " + endTime);

            // Record within the startTime/endTime window
            while (endTime.isAfter(LocalDateTime.now())) {
                while ((len = inStream.read(buffer)) > 0 && startTime.isBefore(LocalDateTime.now()) && endTime.isAfter(LocalDateTime.now())) {
                    outStream.write(buffer, 0, len);
                }
            }
            outStream.close();
            System.out.println("\nRecording complete: " + outputPath);

        }
        catch(Exception e){
            System.out.print("Error while trying to record.\nException: " + e);
        }
    }
}
