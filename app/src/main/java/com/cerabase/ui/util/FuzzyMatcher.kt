package com.cerabase.ui.util

object FuzzyMatcher {
    /**
     * Fuzzy match algorithm - finds the score between 0 (no match) and 1 (exact match)
     * Allows for typos and partial matches
     */
    fun fuzzyMatch(query: String, target: String): Double {
        if (query.isBlank() || target.isBlank()) return 0.0

        val queryLower = query.lowercase()
        val targetLower = target.lowercase()

        // Exact match
        if (queryLower == targetLower) return 1.0

        // Substring match
        if (targetLower.contains(queryLower)) {
            return 0.9
        }

        // Check if all characters of query are in target in order
        var queryIndex = 0
        var targetIndex = 0
        var matchCount = 0
        var consecutiveMatches = 0
        var maxConsecutive = 0

        while (queryIndex < queryLower.length && targetIndex < targetLower.length) {
            if (queryLower[queryIndex] == targetLower[targetIndex]) {
                matchCount++
                consecutiveMatches++
                maxConsecutive = maxOf(maxConsecutive, consecutiveMatches)
                queryIndex++
            } else {
                consecutiveMatches = 0
            }
            targetIndex++
        }

        // If not all characters matched, return 0
        if (queryIndex < queryLower.length) {
            return 0.0
        }

        // Calculate score based on match density
        val matchDensity = matchCount.toDouble() / queryLower.length
        val positionScore = (targetLower.length - targetIndex).toDouble() / targetLower.length
        val consecutiveScore = maxConsecutive.toDouble() / queryLower.length

        // Weighted average
        val score = (matchDensity * 0.5) + (consecutiveScore * 0.3) + (0.2 * (1.0 - positionScore))

        return score.coerceIn(0.0, 1.0)
    }

    /**
     * Filter and sort results by fuzzy match score
     */
    fun <T> fuzzyFilter(
        items: List<T>,
        query: String,
        selector: (T) -> String
    ): List<Pair<T, Double>> {
        if (query.isBlank()) return emptyList()

        return items
            .map { item -> Pair(item, fuzzyMatch(query, selector(item))) }
            .filter { (_, score) -> score > 0.4 } // Minimum 40% match
            .sortedByDescending { (_, score) -> score }
    }
}
