import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class Record {
    public static void main(String[] args) {
        try{
            // User editable variables
            final String streamURL = "https://wxpnhi.xpn.org/xpnhi-nopreroll";
            String saveDirectory = "C:\\Users\\Paktric\\Programming\\RadioRecorder\\recordings\\";
            String radioProgramName = "IndieRockHP";
            LocalDateTime startTime = LocalDateTime.now();
            int recordingDurationHours = 0;
            int recordingDurationMinutes = 1;

            // Program variables
            LocalDateTime endTime = startTime.plusHours(recordingDurationHours).plusMinutes(recordingDurationMinutes);
            String recordingDate = startTime.toLocalDate().toString();
            String outputPath = saveDirectory + radioProgramName + "_" + recordingDate + ".mp3";

            // I/O variables
            URLConnection conn = new URL(streamURL).openConnection();
            InputStream inStream = conn.getInputStream();
            OutputStream outStream = new FileOutputStream(new File(outputPath));
            byte[] buffer = new byte[4096];
            int len = 0;

            ///////////////////////////////////////////////////////////////////////////////////////


            System.out.println("\nRecording started at " + startTime.truncatedTo(ChronoUnit.MINUTES) + " ... ");

            // Record until endTime is reached
            while (endTime.isAfter(LocalDateTime.now())) {
                while ((len = inStream.read(buffer)) > 0 && endTime.isAfter(LocalDateTime.now())) {
                    outStream.write(buffer, 0, len);
                }
            }
            outStream.close();

            System.out.println("Recording complete: " + outputPath);

        }
        catch(Exception e){
            System.out.print("Error while trying to record.\nException: " + e);
        }
    }
}
