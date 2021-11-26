package com.mall.core.utils.JsonSerializer;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.mall.db.utils.StringUtil;

import java.io.IOException;
import java.util.List;

public class ListStringArrayJsonSerializer extends JsonDeserializer<List<String>> {

    public List<String> deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        String str = jsonParser.getText();
        if(StringUtil.isBlank(str)) return null;

        return JSON.parseArray(str, String.class);
    }
}
