package org.geeksword.springboot.util.model.future;

public interface Task<IN, OUT> {

    OUT get(IN input);
}
