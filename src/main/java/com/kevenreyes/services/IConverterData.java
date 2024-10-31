package com.kevenreyes.services;

public interface IConverterData {
    <T> T obtainData(String json, Class<T> classConv);
}
