package wrapper.core;

import wrapper.annotion.Wrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * config wrapper
 * @author yangyouwang
 */
public class ConfigWrapper extends BaseReflexWrapper {

    @Override
    public Map<String, Object> wrapperType(Wrapper wrapperAnnotation, String fieldName, String fieldValue) {
        Map<String, Object> result = new HashMap<>(16);
        for (String configKey : wrapperAnnotation.dictData()) {
            String configValue = CustomizedPropertyPlaceholderConfigurer.getContextProperty(configKey).toString();
            if (fieldValue.equals(configKey)) {
                result.put(fieldName, configValue);
            }
        }
        return result;
    }
}
