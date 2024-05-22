package it.epicode.blog.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EntitiesUtils {

	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.METHOD)
	public @interface Ignore {
	}

	public <E> void copy(E source, E destination) {
		Stream.of(source.getClass().getMethods()).filter(m -> m.getName().startsWith("set")).forEach(m -> {
			try {
				var getterName = String.format("get%s", m.getName().substring(3));
				var dm = destination.getClass().getMethod(getterName);
				if (dm != null && !dm.isAnnotationPresent(Ignore.class)) {
					var res = dm.invoke(destination);
					if (res != null)
						m.invoke(source, res);
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				log.error(String.format("Exception copying objects (%s)", source.getClass().getSimpleName()), e);
				throw new RuntimeException(e);
			}
		});
	}
}
