package examples

import com.jayway.jsonpath.JsonPath

class JsonPathUtils {
	companion object {
		fun <T> findByJsonPath(jsonPath: String, eventDataObject: String): T {
			try {
				return JsonPath.parse(eventDataObject).read(jsonPath)
			} catch (e: Exception) {
				throw Exception("Unable to resolve $jsonPath property in event data")
			}
		}
	}
}

