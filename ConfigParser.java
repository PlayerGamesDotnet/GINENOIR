import org.json.JSONArray;
import org.json.JSONObject;

public class ConfigParser {
    public static void main(String[] args) {
        // O seu JSON
        String jsonStr = "{" +
                "  \"version\": 2," +
                "  \"cmakeMinimumRequired\": {" +
                "    \"major\": 3," +
                "    \"minor\": 20," +
                "    \"patch\": 0" +
                "  }," +
                "  \"configurePresets\": [" +
                "    {" +
                "      \"name\": \"linux-clang-base\"," +
                "      \"hidden\": true," +
                "      \"generator\": \"Ninja\"," +
                "      \"cacheVariables\": {" +
                "        \"EZ_EXPERIMENTAL_EDITOR_ON_LINUX\": \"ON\"," +
                "        \"EZ_BUILD_EXPERIMENTAL_VULKAN\": \"ON\"," +
                "        \"EZ_ENABLE_FOLDER_UNITY_FILES\" : \"OFF\"" +
                "      }," +
                "      \"environment\": {}" +
                "    }," +
                "    {" +
                "      \"name\": \"linux-clang-debug\"," +
                "      \"inherits\": [\"linux-clang-base\"]," +
                "      \"hidden\": true," +
                "      \"binaryDir\": \"${sourceDir}/build-debug-clang-ide\"," +
                "      \"cacheVariables\": {" +
                "        \"CMAKE_BUILD_TYPE\": \"Debug\"" +
                "      }" +
                "    }," +
                "    {" +
                "      \"name\": \"linux-clang-dev\"," +
                "      \"inherits\": [\"linux-clang-base\"]," +
                "      \"hidden\": true," +
                "      \"binaryDir\": \"${sourceDir}/build-dev-clang-ide\"," +
                "      \"cacheVariables\": {" +
                "        \"CMAKE_BUILD_TYPE\": \"Dev\"" +
                "      }" +
                "    }," +
                "    {" +
                "      \"name\": \"linux-clang-shipping\"," +
                "      \"inherits\": [\"linux-clang-base\"]," +
                "      \"hidden\": true," +
                "      \"binaryDir\": \"${sourceDir}/build-shipping-clang-ide\"," +
                "      \"cacheVariables\": {" +
                "        \"CMAKE_BUILD_TYPE\": \"Shipping\"" +
                "      }" +
                "    }" +
                "  ]" +
                "}";

        // Converter o JSON para um objeto JSONObject
        JSONObject jsonObj = new JSONObject(jsonStr);

        // Obter o array de "configurePresets"
        JSONArray presetsArray = jsonObj.getJSONArray("configurePresets");

        // Iterar sobre os objetos no array
        for (int i = 0; i < presetsArray.length(); i++) {
            JSONObject preset = presetsArray.getJSONObject(i);

            // Exibir o nome do preset
            System.out.println("Nome do preset: " + preset.getString("name"));

            // Se houver outras operações que você deseja realizar com cada preset, faça aqui...
        }
    }
}
