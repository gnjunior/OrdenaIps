import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenarIPs {
    public static void main(String[] args) {
        List<String> ips = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("ips.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.isEmpty()) {
                    ips.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Collections.sort(ips, Comparator.comparingLong(OrdenarIPs::ipToLong));

        for (String ip : ips) {
            System.out.println(ip);
        }
    }

    private static long ipToLong(String ip) {
        String[] octets = ip.split("\\.");

        long result = 0;
        for (int i = 0; i < 4; i++) {
            result <<= 8;
            if (!octets[i].isEmpty()) {
                result |= Long.parseLong(octets[i]);
            }
        }

        return result;
    }
}
