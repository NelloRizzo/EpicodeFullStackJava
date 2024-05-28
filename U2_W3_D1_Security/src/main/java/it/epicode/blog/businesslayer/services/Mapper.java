package it.epicode.blog.businesslayer.services;

public interface Mapper<D, S> {

	S map(D input);
}
