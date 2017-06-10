package com.luismunyoz.marvelheroes.data.source;

import com.luismunyoz.marvelheroes.data.models.Character;
import com.luismunyoz.marvelheroes.data.models.Comic;

import java.util.List;

/**
 * Created by luis on 19/05/17.
 */

public interface CharactersDataSource {

	void getCharacters(Integer limit, Integer offset, GetCharactersCallback callback);

	void getCharacter(Long characterId, GetCharacterCallback callback);

	void getCharacterComics(Long characterId, Integer limit, Integer offset, GetCharacterComicsCallback callback);

	interface GetCharactersCallback {
		void onCharactersLoaded(List<Character> characters);

		void onCharactersLoadError();
	}

	interface GetCharacterCallback {
		void onCharacterLoaded(Character character);

		void onCharacterLoadError();
	}

	interface GetCharacterComicsCallback {
		void onCharacterComicsLoaded(List<Comic> comics);

		void onCharacterComicsLoadError();
	}
}
