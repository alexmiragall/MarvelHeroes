package com.luismunyoz.marvelheroes.characters;

import com.luismunyoz.marvelheroes.BaseContract;
import com.luismunyoz.marvelheroes.data.Character;

import java.util.List;

/**
 * Created by luis on 22/05/17.
 */

public interface CharactersContract {

    interface View extends BaseContract.BaseView<Presenter> {

        void showLoading(boolean active);

        void showCharacters(List<Character> characters);

        void showEmptyList();

        void showErrorLoading();

        void openCharacterDetails(Character character);
    }

    interface Presenter extends BaseContract.BasePresenter {

        void loadCharacters();

        void onCharacterClicked(Character character);

        void onLoadMore();
    }
}
