package ominext.com.solitaire.view

import android.content.Context
import android.view.ViewManager
import android.widget.ImageView
import ominext.com.solitaire.cardBackDrawable
import ominext.com.solitaire.emptyPileDrawable
import ominext.com.solitaire.no_android.GameModel
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.onClick

/**
 * Created by LuongHH on 5/22/2017.
 */

class DeckView(context: Context?) : ImageView(context) {
    init {
        imageResource = cardBackDrawable
        onClick {
            GameModel.onDeckTap()
        }
    }

    fun update() {
        imageResource = if (GameModel.deck.cardsInDeck.size > 0) cardBackDrawable else emptyPileDrawable
    }
}

val DECKVIEW_FACTORY = {ctx: Context -> DeckView(ctx)}
fun ViewManager.deckView(init: DeckView.() -> Unit = {}) =
        ankoView(DECKVIEW_FACTORY, 0, init)
