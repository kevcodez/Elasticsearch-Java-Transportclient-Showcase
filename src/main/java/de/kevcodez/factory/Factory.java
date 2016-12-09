package de.kevcodez.factory;

import de.kevcodez.model.AbstractEntity;

/**
 * // TODO add class comment
 *
 * @author Kevin
 */
public interface Factory<T extends AbstractEntity> {

    T createRandom();

}
