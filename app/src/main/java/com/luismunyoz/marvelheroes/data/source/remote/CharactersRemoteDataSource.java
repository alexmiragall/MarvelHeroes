package com.luismunyoz.marvelheroes.data.source.remote;

import com.luismunyoz.marvelheroes.data.models.Character;
import com.luismunyoz.marvelheroes.data.models.Comic;
import com.luismunyoz.marvelheroes.data.source.CharactersDataSource;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.CharacterInteractor;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.CharacterInteractorImpl;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.CharactersInteractor;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.CharactersInteractorImpl;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.ComicsInteractor;
import com.luismunyoz.marvelheroes.data.source.remote.interactors.ComicsInteractorImpl;

import java.util.List;

/**
 * Created by luis on 19/05/17.
 */

public class CharactersRemoteDataSource implements CharactersDataSource {

	@Override
	public void getCharacters(Integer limit, Integer offset, final GetCharactersCallback callback) {
		(new CharactersInteractorImpl()).execute(limit, offset, new CharactersInteractor.CharactersInteractorCallback() {
			@Override
			public void onCharactersDownloaded(List<Character> characters) {
				if (callback != null) {
					callback.onCharactersLoaded(characters);
				}
			}

			@Override
			public void onCharactersDownloadError(Integer status, String error) {
				if (callback != null) {
					callback.onCharactersLoadError();
				}
			}
		});
	}

	@Override
	public void getCharacter(Long characterId, final GetCharacterCallback callback) {
		(new CharacterInteractorImpl()).execute(characterId.toString(), new CharacterInteractor.CharacterInteractorCallback() {
			@Override
			public void onCharacterDownloaded(Character character) {
				if (callback != null) {
					callback.onCharacterLoaded(character);
				}
			}

			@Override
			public void onCharacterDownloadError(Integer status, String error) {
				if (callback != null) {
					callback.onCharacterLoadError();
				}
			}
		});
	}

	@Override
	public void getCharacterComics(Long characterId, Integer limit, Integer offset, final GetCharacterComicsCallback callback) {
		(new ComicsInteractorImpl()).execute(characterId.toString(), limit, offset, new ComicsInteractor.ComicsInteractorCallback() {
			@Override
			public void onComicsDownloaded(List<Comic> comics) {
				if (callback != null) {
					callback.onCharacterComicsLoaded(comics);
				}
			}

			@Override
			public void onComicsDownloadError(Integer status, String error) {
				if (callback != null) {
					callback.onCharacterComicsLoadError();
				}
			}
		});
	}
}
