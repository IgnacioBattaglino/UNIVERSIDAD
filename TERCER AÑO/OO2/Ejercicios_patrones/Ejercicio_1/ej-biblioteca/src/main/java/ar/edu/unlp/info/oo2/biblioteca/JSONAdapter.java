package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSONAdapter implements Target {
    public String exportar(List<Socio> socios) {
        if (socios.isEmpty()) {
            return "[]";
        }
        
        JSONArray json = new JSONArray();
        for (Socio socio : socios) {
            JSONObject socioJSON = new JSONObject();
            socioJSON.put("nombre", socio.getNombre());
            socioJSON.put("email", socio.getEmail());
            socioJSON.put("legajo", socio.getLegajo());
            json.add(socioJSON);
        }
        
        // Agregar espacios después de los dos puntos
        String jsonString = json.toJSONString()
            .replace("\":", "\": ");
            
        return jsonString;
    }
}

