package ominext.com.solitaire

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import ominext.com.solitaire.no_android.GameModel
import ominext.com.solitaire.no_android.GamePresenter
import ominext.com.solitaire.no_android.GameView
import ominext.com.solitaire.view.DeckView
import ominext.com.solitaire.view.deckView
import org.jetbrains.anko.*

val cardBackDrawable = R.drawable.cardback_green5
val emptyPileDrawable = R.drawable.cardback_blue1

class MainActivity : AppCompatActivity(), GameView {

    var deckView: DeckView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cardWidth = (displayMetrics.widthPixels - dip(8)) / 7
        val cardHeight = cardWidth * 190 / 140

        GamePresenter.setGameView(this)
        GameModel.resetGame()

        verticalLayout {
            leftPadding = dip(4)
            rightPadding = dip(4)
            topPadding = dip(8)

            linearLayout {
                deckView = deckView().lparams(cardWidth, cardHeight)
                imageView(imageResource = emptyPileDrawable).lparams(cardWidth, cardHeight)
                view().lparams(cardWidth, 0)
                for (i in 0..3) {
                    imageView(imageResource = emptyPileDrawable).lparams(cardWidth, cardHeight)
                }
            }

            linearLayout {

            }
        }
    }

    override fun update(gameModel: GameModel) {
        deckView!!.update()
    }
}
