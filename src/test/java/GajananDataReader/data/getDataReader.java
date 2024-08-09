package GajananDataReader.data;

import java.util.HashMap;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.commons.io.FileUtils;

public class getDataReader {
	
	public List<HashMap<String,String>> getJsonDataToMap() throws IOException
	{
		//read jason to string 
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"//src//test//java//GajananDataReader//data//DataReader.json"),StandardCharsets.UTF_8); 
	//String to Jackson datatbind
			ObjectMapper mapper= new ObjectMapper();
			List<HashMap<String,String>> data= mapper.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>(){});
				return data;
				
			}
}
	
	
	
	
	
	

