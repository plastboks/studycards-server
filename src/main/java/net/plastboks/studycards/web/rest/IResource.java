package net.plastboks.studycards.web.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by alex on 12/15/16.
 */
public interface IResource<T> {

    ResponseEntity<T> post(T t) throws URISyntaxException;
    ResponseEntity<T> get(@PathVariable int id);
    ResponseEntity<T> put(T t) throws URISyntaxException;
    ResponseEntity<Void> delete(@PathVariable int id);
    List<T> getAll();
}
