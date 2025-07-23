package com.trackingapp.auth.oauth2;

import com.trackingapp.auth.expection.IllegalServiceInterfaceException;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class OAuth2ExtractorFactory {
    private final Map<String,OAuth2AttributeExtractor> extractorMap;

    public OAuth2ExtractorFactory(Map<String,OAuth2AttributeExtractor> extractors){
        this.extractorMap=extractors.values().stream().collect(Collectors.toMap(
                ext->ext.getProvider().toLowerCase(),
                ext->ext
        ));
    }

    public OAuth2AttributeExtractor getExtractor(String provider){
        OAuth2AttributeExtractor extractor=extractorMap.get(provider.toLowerCase());
        if(extractor==null){
            throw new IllegalServiceInterfaceException("No Extractor found for the provider"+provider);
        }
        return extractor;
    }
}
