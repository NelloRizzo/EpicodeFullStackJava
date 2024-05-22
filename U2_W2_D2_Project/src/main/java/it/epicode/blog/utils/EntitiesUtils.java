package it.epicode.blog.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.stream.Stream;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class EntitiesUtils {

	public <E> void copy(E source, E destination) {
		Stream.of(source.getClass().getMethods()).filter(m -> m.getName().startsWith("set")).forEach(m -> {
			try {
				var dm = destination.getClass().getMethod(m.getName());
				if (dm.invoke(destination) != null)
					m.invoke(source, dm.invoke(destination));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
					| NoSuchMethodException | SecurityException e) {
				log.error("Exception copying objects", e);
				throw new RuntimeException(e);
			}
		});
	}
}
