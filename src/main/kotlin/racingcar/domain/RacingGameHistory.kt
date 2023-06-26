package racingcar.domain

class RacingGameHistory {
    private val histories: MutableList<RoundHistory> = mutableListOf()

    fun addHistory(roundHistory: RoundHistory) {
        histories.add(roundHistory)
    }

    fun getWinnerNames(): List<String> {
        val lastRoundCarInfos = histories.last().carInfos
        val ranks = lastRoundCarInfos.sortedByDescending { it.position }
        val maxPosition = ranks.first().position

        return ranks.filter { it.position == maxPosition }
            .map { it.name }
    }

    fun getHistories(): List<RoundHistory> {
        return histories.toList()
    }
}
