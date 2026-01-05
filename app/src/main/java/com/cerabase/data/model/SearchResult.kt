package com.cerabase.data.model

sealed class SearchResult {
    abstract val id: String
    abstract val title: String
    abstract val subtitle: String
    abstract val category: String

    data class SegerConeResult(
        override val id: String,
        override val title: String,
        override val subtitle: String,
        override val category: String = "seger_cones",
        val cone: SegerCone
    ) : SearchResult()

    data class ExpansionResult(
        override val id: String,
        override val title: String,
        override val subtitle: String,
        override val category: String = "expansion",
        val coefficient: ExpansionCoefficient
    ) : SearchResult()

    data class OxideResult(
        override val id: String,
        override val title: String,
        override val subtitle: String,
        override val category: String = "oxides",
        val oxide: Oxide
    ) : SearchResult()

    data class ClayFormulaResult(
        override val id: String,
        override val title: String,
        override val subtitle: String,
        override val category: String = "clay_formulas",
        val formula: ClayFormula
    ) : SearchResult()

    data class TroubleshootingResult(
        override val id: String,
        override val title: String,
        override val subtitle: String,
        override val category: String = "troubleshooting",
        val item: TroubleshootingItem
    ) : SearchResult()
}

object SearchEngine {
    fun search(query: String): List<SearchResult> {
        if (query.isBlank()) return emptyList()

        val results = mutableListOf<SearchResult>()
        val lowerQuery = query.lowercase()

        // Search Seger Cones
        SegerConeData.cones.forEach { cone ->
            val searchText = "${cone.number} ${cone.temperatureCelsius} ${cone.temperatureFahrenheit} ${cone.description} ${cone.usage}".lowercase()
            if (searchText.contains(lowerQuery)) {
                results.add(
                    SearchResult.SegerConeResult(
                        id = "cone_${cone.number}",
                        title = "Koni ${cone.number}",
                        subtitle = "${cone.temperatureCelsius}°C - ${cone.usage}",
                        cone = cone
                    )
                )
            }
        }

        // Search Expansion Coefficients
        ExpansionCoefficientData.coefficients.forEach { coeff ->
            val searchText = "${coeff.material} ${coeff.coefficient} ${coeff.category} ${coeff.notes}".lowercase()
            if (searchText.contains(lowerQuery)) {
                results.add(
                    SearchResult.ExpansionResult(
                        id = "expansion_${coeff.material.replace(" ", "_")}",
                        title = coeff.material,
                        subtitle = "Katsayı: ${coeff.coefficient} - ${coeff.category}",
                        coefficient = coeff
                    )
                )
            }
        }

        // Search Oxides
        OxideData.oxides.forEach { oxide ->
            val searchText = "${oxide.name} ${oxide.formula} ${oxide.colorEffect} ${oxide.firingType} ${oxide.notes}".lowercase()
            if (searchText.contains(lowerQuery)) {
                results.add(
                    SearchResult.OxideResult(
                        id = "oxide_${oxide.name.replace(" ", "_")}",
                        title = oxide.name,
                        subtitle = "${oxide.colorEffect} - ${oxide.percentageRange}",
                        oxide = oxide
                    )
                )
            }
        }

        // Search Clay Formulas
        ClayFormulaData.formulas.forEach { formula ->
            val searchText = "${formula.name} ${formula.type} ${formula.cone} ${formula.properties} ${formula.usage}".lowercase()
            if (searchText.contains(lowerQuery)) {
                results.add(
                    SearchResult.ClayFormulaResult(
                        id = "formula_${formula.name.replace(" ", "_")}",
                        title = formula.name,
                        subtitle = "${formula.type} - ${formula.cone}",
                        formula = formula
                    )
                )
            }
        }

        // Search Troubleshooting
        TroubleshootingData.items.forEach { item ->
            val searchText = "${item.problem} ${item.category} ${item.causes.joinToString()} ${item.solutions.joinToString()}".lowercase()
            if (searchText.contains(lowerQuery)) {
                results.add(
                    SearchResult.TroubleshootingResult(
                        id = "trouble_${item.problem.replace(" ", "_")}",
                        title = item.problem,
                        subtitle = item.category,
                        item = item
                    )
                )
            }
        }

        return results
    }
}
