package com.hzw.StadiumRentalSystem.utils;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.json.JSONArray;
import org.json.JSONObject;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * ����������JSON/XML�����֮��ת��������
 * 
 * @author WCF
 * @version 1.0
 */
public class JsonMapper {

	private static ObjectMapper objectMapper;

	private static XmlMapper xmlMapper;

	/**
	 * ��̬��ʵ��objectMapper/xmlMapper����
	 */
	static {
		objectMapper = new ObjectMapper();
		xmlMapper = new XmlMapper();
	}

	/**
	 * javaBean,list,array convert to json string
	 */
	public static String obj2json(Object obj) {
		try {
			return objectMapper.writeValueAsString(obj);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return obj2json(obj);
	}

	/**
	 * json string convert to javaBean
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static <T> T json2bean(String jsonStr, Class<T> clazz)
			throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(jsonStr, clazz);
	}

	/**
	 * json string convert to map
	 * 
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, Serializable> json2map(String jsonStr)
			throws JsonParseException, JsonMappingException, IOException {
		return objectMapper.readValue(jsonStr, Map.class);
	}

	/**
	 * json string convert to map with javaBean
	 */
	public static <T> Map<String, T> json2map(String jsonStr, Class<T> clazz)
			throws Exception {
		Map<String, Map<String, Serializable>> map = objectMapper.readValue(
				jsonStr, new TypeReference<Map<String, T>>() {
				});
		Map<String, T> result = new HashMap<String, T>();
		for (Entry<String, Map<String, Serializable>> entry : map.entrySet()) {
			result.put(entry.getKey(), map2bean(entry.getValue(), clazz));
		}
		return result;
	}

	/**
	 * json array string convert to list with javaBean
	 */
	public static <T> List<T> json2list(String jsonArrayStr, Class<T> clazz)
			throws Exception {
		List<Map<String, Serializable>> list = objectMapper.readValue(
				jsonArrayStr, new TypeReference<List<T>>() {
				});
		List<T> result = new ArrayList<T>();
		for (Map<String, Serializable> map : list) {
			result.add(map2bean(map, clazz));
		}
		return result;
	}

	/**
	 * map convert to javaBean
	 */
	public static <T> T map2bean(Map<String, Serializable> map, Class<T> clazz) {
		return objectMapper.convertValue(map, clazz);
	}

	/**
	 * json string convert to xml string
	 */
	public static String json2xml(String jsonStr) {
		JsonNode root;
		String xml = null;
		try {
			root = objectMapper.readTree(jsonStr);
			xml = xmlMapper.writeValueAsString(root);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return xml;
	}

	/**
	 * xml string convert to json string
	 */
	public static String xml2json(String xml) throws Exception {
		StringWriter w = new StringWriter();
		JsonParser jp = xmlMapper.getFactory().createParser(xml);
		JsonGenerator jg = objectMapper.getFactory().createGenerator(w);
		while (jp.nextToken() != null) {
			jg.copyCurrentEvent(jp);
		}
		jp.close();
		jg.close();
		return w.toString();
	}

	/**
	 * Object to xml
	 * 
	 * @param obj
	 * @return
	 */
	public static String obj2Xml(Object obj) {
		XmlMapper xml = new XmlMapper();
		StringWriter sw = new StringWriter();
		try {
			xml.writeValue(sw, obj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}

	/**
	 * ��ȡ���͵�Collection Type
	 * 
	 * @param collectionClass
	 *            ���͵�Collection
	 * @param elementClasses
	 *            Ԫ����
	 * @return JavaType Java����
	 * @since 1.0
	 */
	public static JavaType getCollectionType(Class<?> collectionClass,
			Class<?>... elementClasses) {
		return objectMapper.getTypeFactory().constructParametricType(
				collectionClass, elementClasses);
	}

    /**
     * ����������������JSON�ַ�ת��Ϊjava���϶���
     * @param <T>
     * @param clazz
     * @param jsons 
     * @return 
     * @return
     */
//    @SuppressWarnings({"rawtypes", "unchecked" })
//	public static <T> List<T> json2BeanList(String jsonStr,T clazz) {
//        List<T> objs=null;
//        JSONArray jsonArray=(JSONArray)JSONSerializer.toJSON(jsonStr);
//        if(jsonArray != null && jsonArray.size() > 0){
//            objs = new ArrayList<T>();
//            List list=(List)JSONSerializer.toJava(jsonArray);
//            for(Object o : list){
//                JSONObject jsonObject=JSONObject.fromObject(o);
//                String[] dateFormats = new String[] {"yyyy��MM��dd��"};
//                JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
//                T obj= (T)JSONObject.toBean(jsonObject, clazz.getClass());
//                objs.add(obj);
//            }
//        }
//        return objs;
//    }
}
