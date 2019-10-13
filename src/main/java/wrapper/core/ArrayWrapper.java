package wrapper.core;

import wrapper.annotion.Wrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Array Wrap
 * @author yangyouwang
 */
public class ArrayWrapper extends BaseReflexWrapper {

    @Override
    public Map<String, Object> wrapperType(Wrapper wrapperAnnotation, String fieldName, String fieldValue) {
        Map<String, Object> result = new HashMap<>(16);
        for (String dict : wrapperAnnotation.dictData()) {
            String[] split = dict.split(":");
            if (fieldValue.equals(split[0])) {
                result.put(fieldName, split[1]);
            }
        }
        return result;
    }
}
