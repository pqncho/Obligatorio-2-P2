//Marcos Coszion(332945), Francisco Lino(347691)
package Dominio;
import com.google.gson.Gson;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class geminiAI {

  private static final String MODEL = "gemini-2.5-flash";

    private String getAPIKey() {
        return System.getenv("ERP_API_KEY");
    }

    public String consultarIA(String prompt) throws Exception {
        String apiKey = getAPIKey();
        if (apiKey == null) {
            throw new RuntimeException("La variable de entorno ERP_API_KEY no está configurada.");
        }

        // URL de la API de Google AI Studio
        URL url = new URL(
            "https://generativelanguage.googleapis.com/v1beta/models/" 
            + MODEL + ":generateContent?key=" + apiKey
        );

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        conn.setDoOutput(true);

        // Construcción del JSON usando Gson
        Gson gson = new Gson();
        String jsonInput = gson.toJson(new Prompt(prompt));

        try (OutputStream os = conn.getOutputStream()) {
            byte[] input = jsonInput.getBytes(StandardCharsets.UTF_8);
            os.write(input, 0, input.length);
        }

        StringBuilder response = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8)
        )) {
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
        }

        return response.toString(); // JSON completo devuelto por Gemini
    }

    // Clase interna para construir el JSON
    public static class Prompt {
        Content[] contents;

        public Prompt(String text) {
            this.contents = new Content[]{ new Content(text) };
        }
    }

    public static class Content {
        Part[] parts;

        public Content(String text) {
            this.parts = new Part[]{ new Part(text) };
        }
    }

    public static class Part {
        String text;

        public Part(String text) {
            this.text = text;
        }
    }

    
    
}


