/**
 *   By:  Patrick Moran
 * Date:  27 MAR 2023
 * Desc:  Program to record streamed audio from a radio station's website
 */

import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Recorder {
    /**
     * param  args[0]  Number of hours the program should record for
     * param  args[1]  Number of minutes the program should record for
     * param  args[2]  Stream URL             eg. "https://wxpnhi.xpn.org/xpnhi-nopreroll"
     * param  args[3]  Save directory         eg. "C:/Users/Paktric/Desktop/"
     * param  args[4]  Radio program name     eg. "IndieRockHP"
     */
    public static void main(String[] args) {
        try{
            ////////////////////////////////////////////////////////////////////////////////////
            ////                              Stream setup                                  ////

            // Get stream information from command line arguments
            byte recordingDurationHours   = Byte.parseByte(args[0]);
            byte recordingDurationMinutes = Byte.parseByte(args[1]);
            String streamURL              = args[2];
            String saveDirectory          = args[3];
            String radioProgramName       = args[4];

            // Create start / end times
            LocalDateTime startTime = LocalDateTime.now();
            LocalDateTime endTime = startTime
                    .plusHours(recordingDurationHours)
                    .plusMinutes(recordingDurationMinutes);

            // Build the output path
            String recordingDate = startTime.toLocalDate().toString();
            String outputPath = saveDirectory + radioProgramName + "_" + recordingDate + ".mp3";

            // I/O stream variables
            URLConnection conn = new URL(streamURL).openConnection();
            InputStream inStream = conn.getInputStream();
            OutputStream outStream = new FileOutputStream(new File(outputPath));
            byte[] buffer = new byte[4096];
            int len = 0;


            ////////////////////////////////////////////////////////////////////////////////////
            ////                            Start Recording!                                ////

            System.out.println( "                _ _                      \n"    +
                                "               | (_)                     \n"    +
                                "  _ __ __ _  __| |_  ___                 \n"    +
                                " | '__/ _` |/ _` | |/ _ \\                \n"   +
                                " | | | (_| | (_| | | (_) |   _           \n"    +
                                " |_|  \\__,_|\\__,_|_|\\___/   | |          \n" +
                                "  _ __ ___  ___ ___  _ __ __| | ___ _ __ \n"    +
                                " | '__/ _ \\/ __/ _ \\| '__/ _` |/ _ \\ '__|\n" +
                                " | | |  __/ (_| (_) | | | (_| |  __/ |   \n"    +
                                " |_|  \\___|\\___\\___/|_|  \\__,_|\\___|_|\n"  +
                                " Made with love by Patrick Moran, 2023\n\n");

            System.out.printf(" Starting scheduled recording (%s)...",
                    startTime.truncatedTo(ChronoUnit.MINUTES));

            // Record until endTime is reached
            while ((len = inStream.read(buffer)) > 0 && endTime.isAfter(LocalDateTime.now())) {
                outStream.write(buffer, 0, len);
            }
            outStream.close();

        }
        catch(Exception e){
            System.out.print("Error while trying to record.\nException: " + e);
        }
    }
}
