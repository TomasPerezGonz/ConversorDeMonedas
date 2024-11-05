import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final String API_KEY = "b818487b9defce761fc997eb";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    private Map<String, String> currencyCodes = new HashMap<>();

    public CurrencyConverter() {
        currencyCodes.put("USD", "Dólar estadounidense");
        currencyCodes.put("EUR", "Euro");
        currencyCodes.put("GBP", "Libra esterlina");
        currencyCodes.put("CLP", "Peso chileno");
        currencyCodes.put("MXN", "Peso mexicano");
        currencyCodes.put("ARS", "Peso argentino");
        currencyCodes.put("BRL", "Real brasileño");
        currencyCodes.put("COP", "Peso colombiano");
        currencyCodes.put("PEN", "Sol peruano");
        currencyCodes.put("UYU", "Peso uruguayo");
        currencyCodes.put("VEF", "Bolívar venezolano");
        currencyCodes.put("PYG", "Guaraní paraguayo");
        currencyCodes.put("NIO", "Córdoba nicaragüense");
        currencyCodes.put("CUP", "Peso cubano");
        currencyCodes.put("DOP", "Peso dominicano");
        currencyCodes.put("HNL", "Lempira hondureña");
        currencyCodes.put("CRC", "Colón costarricense");
        currencyCodes.put("SVC", "Colón salvadoreño");
    }

    public double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        try {
            URL url = new URL(BASE_URL + fromCurrency);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            Gson gson = new Gson();
            JsonObject jsonResponse = gson.fromJson(reader, JsonObject.class);
            reader.close();

            JsonObject ratesJson = jsonResponse.getAsJsonObject("conversion_rates");
            if (ratesJson == null) {
                throw new Exception("La respuesta de la API no contiene el campo 'conversion_rates'.");
            }

            double fromRate = ratesJson.get(fromCurrency).getAsDouble();
            double toRate = ratesJson.get(toCurrency).getAsDouble();

            return (amount / fromRate) * toRate;

        } catch (Exception e) {
            System.out.println("Error al realizar la conversión: " + e.getMessage());
            return 0;
        }
    }

    public void displayCurrencyOptions() {
        System.out.println("Seleccione la moneda que desea convertir:");
        int index = 1;
        for (Map.Entry<String, String> entry : currencyCodes.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " - " + entry.getValue());
            index++;
        }
    }

    public String getCurrencyCode(int choice) {
        int index = 1;
        for (Map.Entry<String, String> entry : currencyCodes.entrySet()) {
            if (index == choice) {
                return entry.getKey();
            }
            index++;
        }
        return null;
    }
}

