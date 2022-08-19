import java.net.URLConnection;
import java.net.URL;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.util.Calendar;
import java.util.Date;

public class recorder {
    private static String streamURL = "https://wxpnhi.xpn.org/xpnhi-nopreroll";
    private static String outputPath = "C:/Users/Paktric/Desktop/output_" + System.currentTimeMillis() + ".mp3";

    public static void main(String[] args) {
        try{
            URLConnection conn = new URL(streamURL).openConnection();
            InputStream is = conn.getInputStream();
            OutputStream outstream = new FileOutputStream(new File(outputPath));
            byte[] buffer = new byte[4096];
            int len;
            long t = System.currentTimeMillis();
            long endTime = t + Math.round(5 * 1000 * .95);

            System.out.println("Program initialized, recording started...");

            while ((len = is.read(buffer)) > 0 && System.currentTimeMillis() <= endTime) {
                outstream.write(buffer, 0, len);
                //System.out.print(".");
            }

            outstream.close();
            System.out.println("Recording complete");



            Date t1 = new Date();
            Date t2 = new Date(122, 7,17, 13,35);

            System.out.println(t1);
            System.out.println(t2);

        }
        catch(Exception e){
            System.out.print("Exception thrown: " + e);
        }
    }
}
