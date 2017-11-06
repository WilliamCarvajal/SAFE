package utilidades;

import com.google.gson.Gson;

public class SerializableJson {

	public String toJson() {
		Gson gson = new Gson();

		String json = gson.toJson(this);

		return json;
	}
}
