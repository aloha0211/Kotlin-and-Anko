package ominext.com.solitaire.no_android

fun main(args: Array<String>) {
    GameModel.resetGame()
    GamePresenter.onDeckTap()
    GameModel.debugPrint()
}
