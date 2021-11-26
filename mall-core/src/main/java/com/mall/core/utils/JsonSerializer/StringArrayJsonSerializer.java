package com.mall.core.utils.JsonSerializer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mall.db.utils.StringUtil;


import java.io.IOException;
import java.util.List;


/*public class StringArrayJsonSerializer extends JsonDeserializer<List<String>> {

    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
        String str = jsonParser.getText();
        return JSON.parseArray(str, String.class);

    }
}*/

public class StringArrayJsonSerializer extends JsonDeserializer<String[]> {

    public String[] deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        String str = jsonParser.getText();
        if(StringUtil.isBlank(str)) return null;
        List<String> strings = JSON.parseArray(str, String.class);

        return strings.toArray(new String[]{});
    }
}
