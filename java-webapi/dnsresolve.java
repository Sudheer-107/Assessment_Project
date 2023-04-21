import java.net.*;
import java.util.*;
import com.google.gson.Gson;
import spark.Request;
import spark.Response;
import static spark.Spark.*;

public class ResolveIP {

    private static Gson gson = new Gson();

    public static void main(String[] args) {
        port(8080);
        post("/resolve-ip", ResolveIP::resolveIP);
    }

    private static String resolveIP(Request request, Response response) {
        String url = request.body();
        Map<String, List<String>> result = new HashMap<>();
        try {
            InetAddress[] addresses = InetAddress.getAllByName(url);
            List<String> ips = new ArrayList<>();
            for (InetAddress addr : addresses) {
                ips.add(addr.getHostAddress());
            }
            result.put("resolvedIp", ips);
            return gson.toJson(result);
        } catch (UnknownHostException e) {
            response.status(404);
            return "Unable to resolve " + url;
        }
    }
}