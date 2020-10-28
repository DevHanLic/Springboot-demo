package com.example.spring.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.*;

public class MyRedisSerializer implements RedisSerializer{

	private static final Logger logger = LoggerFactory.getLogger(MyRedisSerializer.class);

	@Override
	public byte[] serialize(Object t) throws SerializationException {
		ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
		ObjectOutputStream objOut;
		try {
			objOut = new ObjectOutputStream(byteOut);
			objOut.writeObject(t);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return byteOut.toByteArray();
	}

	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if(bytes == null){
			return null;
		}
		ByteArrayInputStream byteIn = new ByteArrayInputStream(bytes);
		ObjectInputStream objIn;
		Object obj = null;
		
		try {
			objIn = new ObjectInputStream(byteIn);
			obj = objIn.readObject();
		} catch (IOException e) {
			logger.info("反序列化报错",e);
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			logger.info("反序列化报错",e);
		}
		return obj;
	}

}
