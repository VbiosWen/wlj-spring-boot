package org.geeksword.springboot.util.serialization;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;

import java.io.IOException;
import java.io.Serializable;

public class FastJsonSerializer implements Serializer {
    @Override
    public byte[] encode(Serializable obj) throws IOException {
        return JSON.toJSONBytes(obj, JSON.DEFAULT_GENERATE_FEATURE);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends Serializable> T decode(byte[] bytes, Class<? extends Serializable> tClass) {
        Object object = JSON.parse(bytes, Feature.AllowArbitraryCommas);
        return (T) object;
    }
}
