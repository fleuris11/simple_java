import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import fi.iki.elonen.NanoHTTPD;

public class Calculator extends NanoHTTPD {
    public Calculator() throws IOException {
        super(getPort());
        start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
        System.out.println("Server started at http://localhost:" + getPort() + "/");
    }

    private static int getPort() {
        String portStr = System.getenv("PORT");
        return portStr != null ? Integer.parseInt(portStr) : 8080;
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

    @Override
    public Response serve(IHTTPSession session) {
        String uri = session.getUri();
        if (uri.equals("/")) {
            return serveFile("index.html");
        } else if (uri.equals("/add")) {
            return serveCalculation(add(4, 6), "Addition");
        } else if (uri.equals("/subtract")) {
            return serveCalculation(subtract(10, 4), "Soustraction");
        } else if (uri.equals("/a-propos")) {
            return serveFile("a-propos.html");
        }
        return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "Not Found");
    }

    private Response serveFile(String fileName) {
        try {
            File file = new File("src/main/webapp/" + fileName);
            if (file.exists()) {
                FileInputStream fis = new FileInputStream(file);
                return newFixedLengthResponse(Response.Status.OK, getContentType(fileName), fis, file.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newFixedLengthResponse(Response.Status.NOT_FOUND, "text/plain", "File Not Found");
    }

    private Response serveCalculation(int result, String operation) {
        String html = "<html><body><h1>Résultat de " + operation + "</h1>" +
                      "<p>" + operation + " : " + result + "</p>" +
                      "<p><a href='/'>Retour</a></p>" +
                      "</body></html>";
        return newFixedLengthResponse(Response.Status.OK, "text/html", html);
    }

    private String getContentType(String fileName) {
        if (fileName.endsWith(".html")) return "text/html";
        return "application/octet-stream";
    }

    public static void main(String[] args) {
        try {
            new Calculator();
            while (true) {
                Thread.sleep(1000);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}