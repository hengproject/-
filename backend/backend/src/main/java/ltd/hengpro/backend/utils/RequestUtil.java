package ltd.hengpro.backend.utils;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

public class RequestUtil {

    public static String getRequestData(HttpServletRequest req) throws IOException {

        BufferedReader bufferReaderBody = null;

        try {

            bufferReaderBody = new BufferedReader(req.getReader());
            String postData = bufferReaderBody.readLine();

            return postData;
        } catch (IOException e) {

            throw e;

        } finally {

            if (bufferReaderBody != null) {
                bufferReaderBody.close();
            }
        }
    }
}
